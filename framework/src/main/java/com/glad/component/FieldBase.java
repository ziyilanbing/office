package com.glad.component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FieldBase {

	public String fetchFieldValue() {

		List<String> list = new ArrayList<String>();
		Class<?> cls = this.getClass();
		fetchVarVal(list, cls);

		return list.toString();
	}

	public List<String> fetchVarVal(List<String> list, Class<?> cls) {
		Field[] fields = cls.getDeclaredFields();
		Method[] methods = cls.getDeclaredMethods();
		for (Field f : fields) {
			String fieldName = f.getName();
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			for (Method m : methods) {
				if (methodName.equals(m.getName())) {
					try {
						list.add(fieldName + " = " + m.invoke(this));
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if ((cls = (Class<?>) cls.getGenericSuperclass()) != null) {
			fetchVarVal(list, cls);
		}
		return list;
	}

}
