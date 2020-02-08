package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1 查询所有的上架商品
        List<ProductInfo>  productInfoList=productService.findUpAll();

        //2.精简方法
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e-> e.getCategoryType())
                .collect(Collectors.toList());
       List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVO> productVoList=new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVo=new ProductVO();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOList(productInfoVOList);
            productVoList.add(productVo);
        }



        return ResultVOUtil.success(productVoList);

    }

}
