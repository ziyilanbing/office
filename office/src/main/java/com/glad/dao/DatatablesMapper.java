package com.glad.dao;

import com.glad.entity.Datatables;
import java.util.List;

public interface DatatablesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Datatables record);

    Datatables selectByPrimaryKey(Integer id);

    List<Datatables> selectAll();

    int updateByPrimaryKey(Datatables record);
}