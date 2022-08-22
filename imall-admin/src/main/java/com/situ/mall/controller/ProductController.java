package com.situ.mall.controller;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;


    @RequestMapping("/selectById")
    @ResponseBody
    public Product selectById(Integer id) {
        return productService.selectById(id);
    }

    @RequestMapping("/getProudctListPage")
    public String getProudctListPage() {
        return "product_list";
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
        LayUITableJSONResult layUITableJSONResult = productService.selectByPage(page, limit);
        return layUITableJSONResult;
    }

    @RequestMapping("/getProductAddPage")
    public String getProductAddPage() {
        return "product_add";
    }
}
