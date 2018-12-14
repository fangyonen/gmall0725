package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseAttrInfo;

import java.util.List;
import java.util.Set;

public interface BaseAttrService {
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    void saveAttr(BaseAttrInfo baseAttrInfo);

    List<BaseAttrInfo> attrInfoList(String catalog3Id);

    List<BaseAttrInfo> getAttrListByvalueIds(Set<String> valueIds);
}

