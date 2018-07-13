package cn.shuhe.controller;


import cn.shuhe.common.PageResult;
import cn.shuhe.common.Result;
import cn.shuhe.domain.Product;
import cn.shuhe.domain.ProductVo;
import cn.shuhe.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private IProductService productService;


    @RequestMapping(value = "/productList",method = RequestMethod.GET)
    public List<Product> selectProductList(){
        List<Product> productList = productService.selectProductList();
        return productList;
    }

    @RequestMapping(value = "/selectProductPageList",method = RequestMethod.GET)
    public PageResult selectProductPageList(@RequestParam Integer pageNum,@RequestParam(required = false,defaultValue = "2") Integer pageSize){
        PageResult pageResult = productService.selectProductPageList(pageNum, pageSize);
        return pageResult;
    }

    @RequestMapping(value = "/selectProductByExample",method = RequestMethod.GET)
    public PageResult selectProductBYExampl(@RequestParam Integer pageNum,@RequestParam(required = false,defaultValue = "2") Integer paegSize,@RequestParam(defaultValue = "") String productName){
        PageResult pageResult = productService.selectProductBYExampl(pageNum, paegSize, productName);
        return pageResult;
    }


    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Result addProduct(@RequestBody ProductVo productVo){

        Product product = new Product();
        Double productPrice = productVo.getProductPrice();
        double v = productPrice.doubleValue() * 100;


        product.setProductPrice((long) v);
        product.setProductName(productVo.getProductName());
        product.setProductImg(productVo.getProductImg());
        Result result = productService.addProduct(product);
        return result;
    }

    @RequestMapping(value = "/deleteProduct/{productId}",method = RequestMethod.DELETE)
    public Result deleteProductByProductId(@PathVariable Integer productId){
        Result result = productService.deleteProductByProductId(productId);
        return result;
    }

    @RequestMapping(value = "/updateProduct/{productId}",method = RequestMethod.PUT)
    public Result updateProductByProduct(@RequestBody Product product,@PathVariable Integer productId){
        product.setProductId(productId.longValue());
        Result result = productService.updateProductByProduct(product);
        return result;
    }







}
