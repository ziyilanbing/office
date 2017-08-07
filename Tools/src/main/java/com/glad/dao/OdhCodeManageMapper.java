/**
  * Copyright &copy; 2012-2017 <a href="">GLAD</a> All rights reserved.
 */
package com.glad.dao;

import com.glad.entity.OdhCodeManage;
import java.util.List;

public interface OdhCodeManageMapper {
    /**
     * 刪除ODH_CODE_MANAGE
     */
    int deleteByPrimaryKey(Integer recNo);

    /**
     * 插入ODH_CODE_MANAGE
     */
    int insert(OdhCodeManage record);

    /**
     * 查詢ODH_CODE_MANAGE
     */
    OdhCodeManage selectByPrimaryKey(Integer recNo);

    /**
     * 查詢ODH_CODE_MANAGE
     */
    List<OdhCodeManage> selectAll();

    /**
     * 修改ODH_CODE_MANAGE
     */
    int updateByPrimaryKey(OdhCodeManage record);
}