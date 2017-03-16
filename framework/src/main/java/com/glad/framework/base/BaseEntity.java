package com.glad.framework.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhongqs
 * @date 2017年3月16日
 */
public class BaseEntity {

	/**
	 * create time
	 */
	private String createTime;

	private String createBy;

	private String updateTime;

	private String updateBy;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	private List<String> fetchVarVal(Class<?> cls) {
		List<String> rtn = new ArrayList<String>();
		Field[] fields = cls.getDeclaredFields();
		Method[] methods = cls.getDeclaredMethods();
		for (Field f : fields) {
			String fieldName = f.getName();
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			for (Method m : methods) {
				if (methodName.equals(m.getName())) {
					try {
						rtn.add(fieldName + " = " + m.invoke(this));
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		return rtn;
	}

	@Override
	public String toString() {
		List<String> list = new ArrayList<String>();
		Class<?> cls = this.getClass();
		Class<?> type = cls;
		while ((type = (Class<?>) type.getGenericSuperclass()) != null) {
			list.addAll(fetchVarVal(type));
		}
		list.addAll(fetchVarVal(cls));
		return list.toString();
	}
}
