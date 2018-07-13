package cn.shuhe.service;

import cn.shuhe.common.PageResult;
import cn.shuhe.common.Result;
import cn.shuhe.domain.Product;

import java.util.List;

public interface IProductService {


    //查询所有的商品信息
    List<Product> selectProductList();

    //模糊查询商品列表
    PageResult  selectProductBYExampl(Integer pageNo, Integer pageSize,String productName);

    //商品的分页列表查询
    PageResult selectProductPageList(Integer pageNo, Integer pageSize);

    // 添加商品
    Result addProduct(Product product);

    //删除商品
    Result deleteProductByProductId(Integer id);

    //更新商品
    Result updateProductByProduct(Product product);

}
