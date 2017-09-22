/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */

package com.glad.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class to convert values from some formated data into java bean.
 */
public class BeanDataUtils {

	/**
	 * The <code>Log</code> instance for this class.
	 */
	private static final Log log = LogFactory.getLog(BeanDataUtils.class);
	/**
	 * a <code>String</code> prefix of common field's name of CommandForm class
	 */
	private static final String UNDER_LINE = "_";
	/**
	 * a final <code>String</code> of point
	 */
	private static final String POINT = ".";
	/**
	 * a final <code>String</code> of java package
	 */
	private static final String JAVA_LANG = "java.lang.";
	/**
	 * a final <code>String</code> key of a <code>Map</code>'s key
	 */
	private static final String MAP_KEY = "KEY";
	/**
	 * a final <code>String</code> key of a <code>Map</code>'s value
	 */
	private static final String MAP_VALUE = "VALUE";
	/**
	 * split by \n
	 */
	private static final String SPLIT_LIST = "\n";

	/**
	 * Default value for coverage test mode
	 */
	private static final String DEFAULT_IGNORE_ITEM_FIELD = "$jacocoData";

	/**
	 * Private constructor.
	 */
	private BeanDataUtils() {
	}

	/**
	 * bind all data from excel into a <code>Map</code>
	 * 
	 * @param dataList a <code>List</code> of <code>BeanData</code>
	 * @param mapField a field of <code>Map</code>
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void bindMap(List<BeanData> dataList, Map mapField) {
		if (dataList == null || dataList.isEmpty() || mapField == null) {
			throw new IllegalArgumentException("Illegal argument.");
		}
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> kv = null;
		String key = null, value = null;
		for (BeanData data : dataList) {
			kv = data.getValues();
			key = null;
			value = null;
			for (Map.Entry<String, String> entry : kv.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(MAP_KEY)) {
					key = entry.getValue();
				} else if (entry.getKey().equalsIgnoreCase(MAP_VALUE)) {
					value = entry.getValue();
				}
			}
			if (StringUtils.isNotBlank(key)) {
				map.put(key, value);
			}
		}
		mapField.putAll(map);
	}

	/**
	 * convert <code>Map</code> data into a java bean with a prefix key
	 * 
	 * @param data <code>Map</code> data
	 * @param bean the <code>Class</code> of CommandForm or DTO
	 * @param preKey a prefix key of item name
	 */
	public static void bind(Map<String, String> data, Object bean, String preKey) {
		if (data == null || data.isEmpty() || bean == null) {
			throw new IllegalArgumentException("Illegal argument.");
		}
		if (bean instanceof List) {
			// Collection
			throw new DataBindException("Pls use \"for(...) { BeanDataBindUtils.bind(...); }\" instead.");
		} else if (bean instanceof Map) {
			// Map
			throw new DataBindException("Pls use \"BeanDataBindUtils.bindMap(...);\" instead.");
		} else {
			// other (try do as a bean)
			bindBeanValue(data, bean, preKey);
		}
	}

	/**
	 * Compare the expect data <code>Map</code> with a java bean with actual value
	 * 
	 * @param expectData <code>Map</code> data
	 * @param actualBean a POJO
	 * @param ignoreItems a <code>String</code> <code>List</code> of field name to ignore.
	 * @return true if values between the <code>Map</code> data and the POJO are similar, otherwise false
	 */
	public static boolean compare(Map<String, String> expectData, Object actualBean, String... ignoreItems) {
		if (expectData == null || expectData.isEmpty() || actualBean == null) {
			throw new IllegalArgumentException("Illegal argument.");
		}

		StringBuilder msg = new StringBuilder();
		compare(expectData, actualBean, ignoreItems, msg);

		return checkMsg(msg.toString());
	}

	/**
	 * Compare the expect and the actual POJO. Ignore while item's name in the ignore list
	 * 
	 * @param expectBean expect bean instance
	 * @param actualBean actual bean instance
	 * @param ignoreItems a <code>String</code> <code>List</code> of field name to ignore.
	 * @return true if both POJO are similar, otherwise false
	 */
	public static boolean compare(Object expectBean, Object actualBean, List<String> ignoreItems) {
		if (expectBean == null || actualBean == null || !expectBean.getClass().equals(actualBean.getClass())) {
			throw new IllegalArgumentException("Illegal argument.");
		}

		StringBuilder msg = new StringBuilder();
		compare(expectBean, actualBean, ignoreItems, msg);

		return checkMsg(msg.toString());
	}

	/**
	 * Compare the expect and the actual POJO. Ignore while item's name in the ignore list
	 * 
	 * @param expectList expect bean list
	 * @param actualList actual bean list
	 * @param sortFieldNames sort by field names
	 * @return true if both POJO are similar, otherwise false
	 */
	public static boolean compareList(List<?> expectList, List<?> actualList, String... sortFieldNames) {
		return compareList(expectList, actualList, null, sortFieldNames);
	}

	/**
	 * Compare the expect and the actual POJO. Ignore while item's name in the ignore list
	 * 
	 * @param expectList expect bean list
	 * @param actualList actual bean list
	 * @param ignoreItems a <code>String</code> <code>Array</code> of field name to ignore.
	 * @param sortFieldNames sort by field names
	 * @return true if both POJO are similar, otherwise false
	 */
	@SuppressWarnings({"unchecked"})
	public static boolean compareList(List<?> expectList, List<?> actualList, String[] ignoreItems, String... sortFieldNames) {
		if (expectList == null) {
			if (actualList == null) {
				return true;
			}
			return false;
		}
		if (actualList == null) {
			return false;
		}
		int number = expectList.size();
		if (number != actualList.size()) {
			System.out.println("Number of object between expectList[" + number + "] and actualList[" + actualList.size() + "] are different.");
			log.error("Number of object between expectList[" + number + "] and actualList[" + actualList.size() + "] are different.");
			return false;
		}
		if (sortFieldNames != null) {
			sort(expectList, sortFieldNames);
			sort(actualList, sortFieldNames);
		}
		Object expect = null;
		Object actual = null;
		Map<String, String> data = null;
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < number; i++) {
			expect = expectList.get(i);
			actual = actualList.get(i);
			if (BeanData.class.equals(expect.getClass())) {
				data = ((BeanData) expect).getValues();
				compare(data, actual, ignoreItems, msg);
			} else if (expect instanceof Map) {
				compare((Map<String, String>) expect, actual, ignoreItems, msg);
			} else {
				compare(expect, actual, ignoreItems == null ? null : Arrays.asList(ignoreItems), msg);
			}
		}
		return checkMsg(msg.toString());
	}

	private static boolean checkMsg(String msg) {
		if (StringUtils.isEmpty(msg)) {
			return true;
		}
		System.out.println(msg);
		log.error(msg);
		return false;
	}

	/**
	 * Compare the expect data <code>Map</code> with a java bean with actual value
	 * 
	 * @param expectData <code>Map</code> data
	 * @param actualBean a POJO
	 * @param ignoreItems items ignored to compare
	 * @param msg error message
	 */
	private static void compare(Map<String, String> expectData, Object actualBean, String[] ignoreItems, StringBuilder msg) {
		if (expectData == null || expectData.isEmpty() || actualBean == null) {
			throw new IllegalArgumentException("Illegal argument.");
		}
		Object actualValue = null;
		String key = null;
		String value = null;
		List<?> list = null;
		List<String> expectList = null;
		List<String> actualList = new ArrayList<String>();
		for (Map.Entry<String, String> entry : expectData.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			if (StringUtils.isEmpty(key)) {
				continue;
			}
			actualValue = getBeanValue(actualBean, key);
			if (value == null || actualValue == null) {
				continue;
			} else if ((value == null && actualValue != null) || (value != null && actualValue == null)) {
				msg.append("The expect and actual value of field(" + key + ") are different. \n");
				log.error("The expect and actual value of field(" + key + ") are different. ");
				continue;
			} else if (value != null && actualValue != null) {
				if (actualValue instanceof List) {
					expectList = Arrays.asList(value.split(SPLIT_LIST));
					actualList.clear();
					list = (List<?>) actualValue;
					for (Object v : list) {
						actualList.add(v.toString());
					}
					if (!expectList.equals(actualList)) {
						msg.append("The expect and actual value of field(" + key + ") are different. \n");
						log.error("The expect and actual value of field(" + key + ") are different. ");
						continue;
					}
				} else if (!value.equals(actualValue.toString())) {
					msg.append("The expect and actual value of field(" + key + ") are different. \n");
					log.error("The expect and actual value of field(" + key + ") are different. ");
					continue;
				}
			}
		}
	}

	private static void compare(Object expectBean, Object actualBean, List<String> ignoreItems, StringBuilder msg) {
		if (expectBean == null || actualBean == null || !expectBean.getClass().equals(actualBean.getClass())) {
			throw new IllegalArgumentException("Illegal argument.");
		}
		List<String> ignoreItemArrayList = null;
		if (ignoreItems == null) {
			ignoreItemArrayList = new ArrayList<String>();
		} else {
			ignoreItemArrayList = new ArrayList<String>(ignoreItems);
		}
		ignoreItemArrayList.add(DEFAULT_IGNORE_ITEM_FIELD);

		Class<?> beanClass = expectBean.getClass();
		do {
			Field[] fields = beanClass.getDeclaredFields();
			for (Field field : fields) {
				if (ignoreItemArrayList.contains(parseFieldName(field.getName())) || field.getName().contains("$")) {
					continue;
				}
				compareValue(expectBean, actualBean, field, msg);
			}
			beanClass = beanClass.getSuperclass();
		} while (!Object.class.equals(beanClass));
	}

	/**
	 * make list sorted by the <code>String</code> value of given field
	 * 
	 * @param list data list
	 * @param sortFieldNames sort by field names of data
	 */
	private static void sort(List<?> list, final String[] sortFieldNames) {

		Collections.sort(list, new Comparator<Object>() {

			private String[] fieldNames = sortFieldNames;

			private Class<?> objType = null;

			public int compare(Object o1, Object o2) {
				objType = o1.getClass();
				int result = 0;
				for (String fieldName : fieldNames) {
					if (StringUtils.isNotBlank(fieldName)) {
						result = compare(o1, o2, fieldName);
					}
					if (result != 0) {
						return result;
					}
				}
				return result;
			}

			/**
			 * Compares its two arguments(String) for order.
			 * 
			 * @param o1 first object
			 * @param o2 second object
			 * @param fieldName order by field name
			 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
			 */
			@SuppressWarnings({"unchecked"})
			private int compare(Object o1, Object o2, String fieldName) {
				Object v1 = null;
				Object v2 = null;
				if (BeanData.class.equals(objType)) {
					v1 = ((BeanData) o1).getValues().get(fieldName);
					v2 = ((BeanData) o2).getValues().get(fieldName);
				} else if (o1 instanceof Map) {
					v1 = ((Map<String, String>) o1).get(fieldName);
					v2 = ((Map<String, String>) o2).get(fieldName);
				} else {
					try {
						v1 = getBeanValue(o1, objType, fieldName);
						v2 = getBeanValue(o2, objType, fieldName);
					} catch (DataBindException e) {
						// try {
						// v1 = BeanUtils.getProperty(o1, fieldName);
						// v2 = BeanUtils.getProperty(o2, fieldName);
						// } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e1) {
						// log.info("Misinterpretation of getter method of field: " + fieldName + ". Message:" + e.getLocalizedMessage());
						// }
					}
				}
				if (v1 == null) {
					if (v2 == null) {
						return 0;
					}
					return -1;
				}
				if (v2 == null) {
					return 1;
				}
				return String.valueOf(v1).compareTo(String.valueOf(v2));
			}

			/**
			 * get the field value from a POJO
			 * 
			 * @param bean the POJO instance
			 * @param type of the POJO instance
			 * @param fieldName the field name
			 * @return the value of the field
			 */
			private Object getBeanValue(Object bean, Class<?> type, String fieldName) {
				String getterName = Xetter.get.getMethodName(fieldName);
				Method getter = null;
				Class<?> fieldType = null;

				try {
					fieldType = type.getDeclaredField(fieldName).getType();
				} catch (NoSuchFieldException | SecurityException e) {
					throw new DataBindException("Can not get value of Field of [", fieldName, ")] with NO getter method.");
				}

				try {
					getter = type.getDeclaredMethod(getterName, new Class<?>[]{});
				} catch (NoSuchMethodException e1) {
					if (fieldType.equals(boolean.class)) {
						getterName = Xetter.is.getMethodName(fieldName);
						try {
							getter = type.getDeclaredMethod(getterName, new Class<?>[]{});
						} catch (NoSuchMethodException | SecurityException e) {
							return getBeanValue(bean, type.getSuperclass(), fieldName);
						}
					} else if (!Object.class.equals(type)) {
						return getBeanValue(bean, type.getSuperclass(), fieldName);
					}
					if (getter == null) {
						throw new DataBindException("Can not get value of Field of [", fieldName, ")] with NO getter method.");
					}
				}

				try {
					getter.setAccessible(true);
					return getter.invoke(bean, new Object[]{});
				} catch (IllegalAccessException e) {
					throw new DataBindException(e, "Can not get value from [", fieldName, "(", getterName, ")]");
				} catch (InvocationTargetException e) {
					throw new DataBindException(e, "Can not get value from [", fieldName, "(", getterName, ")]");
				}
			}

		});

	}

	/**
	 * Compare value of the expect and the actual POJO field.
	 * 
	 * @param expectBean expect bean instance
	 * @param actualBean actual bean instance
	 * @param field compare object field
	 * @return true if both value of field are similar, otherwise false
	 */
	private static void compareValue(Object expectBean, Object actualBean, Field field, StringBuilder msg) {
		String fieldName = parseFieldName(field.getName());
		Object expectValue = null;
		Object resultValue = null;
		try {
			// try {
			// expectValue = BeanUtils.getProperty(expectBean, fieldName);
			// resultValue = BeanUtils.getProperty(actualBean, fieldName);
			// } catch (NoSuchMethodException e) {
			// log.info("Misinterpretation of getter method of field: " + fieldName + ". Message:" + e.getLocalizedMessage());
			// expectValue = getBeanValue(expectBean, field.getName());
			// resultValue = getBeanValue(actualBean, field.getName());
			// }

			if (expectValue == null && resultValue == null) {
				return;
			} else if ((expectValue == null && resultValue != null) || (expectValue != null && resultValue == null) || !expectValue.equals(resultValue)) {
				log.error("The expect[" + expectValue + "] and actual[" + resultValue + "] value of field(" + fieldName + ") are different. ");
				msg.append("The expect[" + expectValue + "] and actual[" + resultValue + "] value of field(" + fieldName + ") are different. \n");
			}
		} catch (Exception e) {
			msg.append("Comparing value of field(" + fieldName + ") failed : " + e.toString() + ". \n");
			log.error(e);
		}
	}

	/**
	 * get the field value from a POJO
	 * 
	 * @param bean the POJO instance
	 * @param fieldName the field name
	 * @return the value of the field
	 */
	private static Object getBeanValue(Object bean, String fieldName) {
		return getBeanValue(bean, bean.getClass(), fieldName);
	}

	/**
	 * get the field value from a POJO
	 * 
	 * @param bean the POJO instance
	 * @param type of the POJO instance
	 * @param fieldName the field name
	 * @return the value of the field
	 */
	private static Object getBeanValue(Object bean, Class<?> type, String fieldName) {
		String getterName = Xetter.get.getMethodName(fieldName);
		Method getter = null;
		Class<?> fieldType = null;

		try {
			fieldType = type.getDeclaredField(fieldName).getType();
		} catch (NoSuchFieldException | SecurityException e) {
			if (!Object.class.equals(type)) {
				return getBeanValue(bean, type.getSuperclass(), fieldName);
			}
		}

		try {
			getter = type.getDeclaredMethod(getterName, new Class<?>[]{});
		} catch (NoSuchMethodException e1) {
			if (fieldType.equals(boolean.class)) {
				getterName = Xetter.is.getMethodName(fieldName);
				try {
					getter = type.getDeclaredMethod(getterName, new Class<?>[]{});
				} catch (NoSuchMethodException | SecurityException e) {
					throw new DataBindException("Can not get value of Field of [", fieldName, ")] with NO getter method.");
				}
			} else {
				throw new DataBindException("Can not get value of Field of [", fieldName, ")] with NO getter method.");
			}
		}

		try {
			getter.setAccessible(true);
			return getter.invoke(bean, new Object[]{});
		} catch (IllegalAccessException e) {
			throw new DataBindException(e, "Can not get value from [", fieldName, "(", getterName, ")]");
		} catch (InvocationTargetException e) {
			throw new DataBindException(e, "Can not get value from [", fieldName, "(", getterName, ")]");
		}
	}

	/**
	 * convert <code>Map</code> data into a java bean with a prefix key
	 * 
	 * @param data <code>Map</code> data
	 * @param bean the <code>Class</code> of CommandForm or DTO
	 * @param preKey a prefix key of item name
	 */
	private static void bindBeanValue(Map<String, String> data, Object bean, String preKey) {
		String value = null;
		Class<?> beanClass = bean.getClass();
		do {
			Field[] fields = beanClass.getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.toString(field.getModifiers()).contains("final")) {
					// Do nothing
				} else {
					// try {
					// value = getExpectValue(data, field, preKey);
					// } catch (NotDataDefinedException e) {
					// // Do nothing if data is not set
					// continue;
					// }
					bindField(bean, field, value);
				}
			}
			beanClass = beanClass.getSuperclass();
		} while (!Object.class.equals(beanClass));
	}

	/**
	 * set a value into a field of the bean
	 * 
	 * @param bean the instance of CommandForm or DTO
	 * @param field a field of the bean instance
	 * @param value a value for the field
	 */
	private static void bindField(Object bean, Field field, String value) {
		if (value == null) {
			if (field.getType().isPrimitive()) { //
				log.info("primitive型にnullはセットできません。[" + field.getName() + "(" + field.getType().getName() + ")]");
				return;
			}
		} else if (StringUtils.isBlank(value) && !(field.getType().equals(String.class))) {
			log.info("String型以外に空文字、空白文字はセットできません。[" + field.getName() + "(" + field.getType().getName() + ")]");
			return;
		}

		String fieldName = field.getName();
		String fieldTypeName = field.getType().getName();
		String setterName = Xetter.set.getMethodName(fieldName);
		String beanClassName = bean.getClass().getName();
		try {
			Object param = null;
			if (null == value) {
				// Do nothing
			} else {
				param = parseValue(beanClassName, field, value);
			}
			Method setter = getMethod(bean.getClass(), setterName, new Class<?>[]{field.getType()});
			// if (setter == null) {
			// BeanUtils.setProperty(bean, fieldName, param);
			// } else {
			// setter.invoke(bean, new Object[]{param});
			// }
		} catch (ParseException e) {
			throw new DataBindException(e, "Can not parse the value[", String.valueOf(value), "] of field[", fieldName, "(", field.getType().getName(),
										")] in class[", beanClassName, "] into a [java.util.Date].");
			// } catch (InvocationTargetException e) {
			// throw new DataBindException(e, "Can not invoke the method[", String.valueOf(value), "] on class[", beanClassName, "].");
			// } catch (IllegalAccessException e) {
			// throw new DataBindException(e, "Exception happened while excuting value[", String.valueOf(value), "] on field[", fieldName, "(", fieldTypeName,
			// ")] in class[", beanClassName, "].");
		} catch (ClassNotFoundException e) {
			throw new DataBindException(e, "Exception happened while casting a enum value[", String.valueOf(value), "] on field[", fieldName, "(",
										fieldTypeName, ")] in class[", beanClassName, "].");
		}
	}

	/**
	 * メソッドの取得
	 * 
	 * @param clazz メソッド取得対象クラス
	 * @param methodName メソッド名
	 * @param params メソッドの引数
	 * @return 対象メソッド
	 */
	private static Method getMethod(Class<? extends Object> clazz, String methodName, Class<?>[] params) {
		Method method = null;

		while (clazz != null) {
			try {
				method = clazz.getDeclaredMethod(methodName, params);
			} catch (NoSuchMethodException e) {
				// 見つからない場合、親のメソッドを探しに行く
				// ClassがObjectの場合nullが返る
				clazz = clazz.getSuperclass();
				continue;
			}

			break;
		}

		return method;
	}

	/**
	 * get the value from <code>MsgBlock</code> data with a prefix key
	 * 
	 * @param beanClassName class name of bean(CommandForm or DTO) class
	 * @param field common field name
	 * @param value a <code>String</code> value of the field
	 * @return value on type
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private static Object parseValue(String beanClassName, Field field, String value) throws ParseException, ClassNotFoundException {
		Class fieldType = field.getType();
		String fieldName = field.getName();
		String fieldTypeName = fieldType.getName();
		if (fieldType.isPrimitive() || (fieldTypeName.startsWith(JAVA_LANG) && fieldTypeName.substring(JAVA_LANG.length()).indexOf(POINT) < 0)) {
			if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
				return Integer.parseInt(value);
			} else if (fieldType.equals(byte.class) || fieldType.equals(Byte.class)) {
				return Byte.parseByte(value);
			} else if (fieldType.equals(short.class) || fieldType.equals(Short.class)) {
				return Short.parseShort(value);
			} else if (fieldType.equals(char.class) || fieldType.equals(Character.class)) {
				return value.charAt(0);
			} else if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
				return Long.parseLong(value);
			} else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
				return Boolean.parseBoolean(value);
			} else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
				return Double.parseDouble(value);
			} else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {
				return Float.parseFloat(value);
			} else if (fieldType.equals(String.class)) {
				return value;
			} else {
				throw new DataBindException("Unkonwn type : Field[", fieldName, "(", fieldTypeName, ")] in class[", beanClassName, "].");
			}
			// } else if (fieldType.isEnum()) {
			// Class enumType = Class.forName(fieldType.getName());
			// return Enum.valueOf(enumType, value);
		} else if (fieldType.equals(Date.class)) {
			// return DateUtils.parseDate(value);
		} else if (fieldType.equals(BigDecimal.class)) {
			return new BigDecimal(value);
		} else if (fieldType.isAssignableFrom(List.class)) {
			// if it's a List, try to bind with String values
			String[] values = value.split(SPLIT_LIST);
			Type fg = field.getGenericType();
			if (fg != null && fg instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) fg;
				Type rawType = pt.getActualTypeArguments()[0];
				if (String.class.equals(rawType)) {
					List<String> newList = new ArrayList<String>();
					for (String v : values) {
						newList.add(v);
					}
					return newList;
				} else if (Integer.class.equals(rawType)) {
					List<Integer> newList = new ArrayList<Integer>();
					for (String v : values) {
						newList.add(Integer.parseInt(v));
					}
					return newList;
				} else if (Long.class.equals(rawType)) {
					List<Long> newList = new ArrayList<Long>();
					for (String v : values) {
						newList.add(Long.parseLong(v));
					}
					return newList;
				} else if (Double.class.equals(rawType)) {
					List<Double> newList = new ArrayList<Double>();
					for (String v : values) {
						newList.add(Double.parseDouble(v));
					}
					return newList;
				} else if (Date.class.equals(rawType)) {
					List<Date> newList = new ArrayList<Date>();
					for (String v : values) {
						// newList.add(DateUtils.parseDate(v));
					}
					return newList;
				} else if (BigDecimal.class.equals(rawType)) {
					List<BigDecimal> newList = new ArrayList<BigDecimal>();
					for (String v : values) {
						newList.add(new BigDecimal(v));
					}
					return newList;
				} else {
					log.debug("Can not bind value with the type : Field["	+ fieldName + "(" + fieldTypeName + ")] whith rawtype[" + rawType.toString()
								+ "] in class[" + beanClassName + "].");
					throw new DataBindException("Can not bind value with the type : Field[", fieldName, "(", fieldTypeName, ")] whith rawtype[",
												rawType.toString(), "] in class[", beanClassName, "].");
				}
			} else {
				log.warn("Bind values on Field[" + fieldName + "(" + fieldTypeName + ")] as String.");
				List newList = new ArrayList();
				for (String v : values) {
					newList.add(v);
				}
				return newList;
			}
		} else {
			log.debug("Field[" + fieldName + "(" + fieldTypeName + ")] in class[" + beanClassName + "].");
			throw new DataBindException("Can not bind value with the type : Field[", fieldName, "(", fieldTypeName, ")] in class[", beanClassName, "].");
		}
		return fieldTypeName;
	}

	/**
	 * get the value from <code>Map</code> data with a prefix key
	 * 
	 * @param data <code>Map</code> data
	 * @param field common field name
	 * @param preKey a prefix key
	 * @return a <code>String</code> value of the field
	 * @throws NotDataDefinedException
	 */
	private static String getExpectValue(Map<String, String> data, Field field, String preKey) {
		String fieldName = parseFieldName(field.getName());
		if (StringUtils.isNotBlank(preKey)) {
			fieldName = preKey.trim().concat(POINT).concat(fieldName);
		}
		// if (!data.containsKey(fieldName)) {
		// throw new NotDataDefinedException(fieldName);
		// }
		return data.get(fieldName);
	}

	/**
	 * get common field name
	 * 
	 * @param name the field name
	 * @return the common field name
	 */
	private static String parseFieldName(String fieldName) {
		if (fieldName.indexOf(UNDER_LINE) == 1) {
			return fieldName.substring(fieldName.indexOf(UNDER_LINE) + 1);
		}
		return fieldName;
	}

	/**
	 * method names of POJO
	 */
	private enum Xetter {
		get, set, is;
		/**
		 * get setter method name of a field
		 * 
		 * @param name the field name
		 * @return the setter method name
		 */
		public String getMethodName(String fieldName) {
			fieldName = parseFieldName(fieldName);
			StringBuilder xetter = new StringBuilder();
			xetter.append(name()).append(String.valueOf(fieldName.charAt(0)).toUpperCase()).append(fieldName.substring(1));
			return xetter.toString();
		}
	}

}
