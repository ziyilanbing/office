package com.glad.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<PK extends Serializable, T> {

	T selectByPrimaryKey(PK key);

	List<T> selectAll();

	int insert(T entity);

	int updateEntity(T entity);

	int delete(PK key);

}
