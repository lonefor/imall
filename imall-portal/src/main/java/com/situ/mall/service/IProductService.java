package com.situ.mall.service;


import com.situ.mall.pojo.Product;

public interface IProductService {
    Product selectById(Integer id);
}