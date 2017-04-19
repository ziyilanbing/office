package com.glad.dao;

import com.glad.entity.SysMenu;
import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuPk);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuPk);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);
}