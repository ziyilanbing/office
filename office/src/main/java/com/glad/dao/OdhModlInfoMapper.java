package com.glad.dao;

import com.glad.entity.OdhModlInfo;
import java.util.List;

public interface OdhModlInfoMapper {
    int deleteByPrimaryKey(String modelId);

    int insert(OdhModlInfo record);

    OdhModlInfo selectByPrimaryKey(String modelId);

    List<OdhModlInfo> selectAll();

    int updateByPrimaryKey(OdhModlInfo record);
}