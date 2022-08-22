package com.situ.mall.service;

import com.situ.mall.pojo.Product;
import com.situ.mall.util.LayUITableJSONResult;

public interface IProductService {
    Product selectById(Integer id);

    LayUITableJSONResult selectByPage(Integer page, Integer limit);
}
