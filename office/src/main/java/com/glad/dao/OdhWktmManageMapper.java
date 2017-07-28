/**
  * copyright -------TODO -------
 */
package com.glad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.glad.entity.OdhWktmManage;

public interface OdhWktmManageMapper {
	/**
	 * 刪除ODH_WKTM_MANAGE
	 */
	int deleteByPrimaryKey(@Param("userNo") String userNo, @Param("recNo") Integer recNo);

	/**
	 * 插入ODH_WKTM_MANAGE
	 */
	int insert(OdhWktmManage record);

	/**
	 * ODH_WKTM_MANAGE
	 */
	OdhWktmManage selectByPrimaryKey(@Param("userNo") String userNo, @Param("recNo") Integer recNo);

	/**
	 * ODH_WKTM_MANAGE
	 */
	List<OdhWktmManage> selectAll();

	/**
	 * ODH_WKTM_MANAGE
	 */
	int updateByPrimaryKey(OdhWktmManage record);
}