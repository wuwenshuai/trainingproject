package cn.shuhe.service;

import cn.shuhe.common.PageResult;
import cn.shuhe.common.Result;

import cn.shuhe.domain.Product;
import cn.shuhe.domain.ProductExample;
import cn.shuhe.mapper.ProductMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{


    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectProductList() {
        List<Product> productList = productMapper.selectByExample(null);
        return productList;
    }

    @Override
    public PageResult selectProductBYExampl(Integer pageNo, Integer pageSize, String productName) {
        //分页查询+条件
        if (StringUtils.isBlank(productName)){
            //分页
            PageHelper.startPage(pageNo,pageSize);
            Page<Product> page = (Page<Product>) productMapper.selectByExample(null);

            return new PageResult(page.getTotal(),page.getResult());
        }else {
            //设置分页
            PageHelper.startPage(pageNo,pageSize);
            //执行查询
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria = productExample.createCriteria();
            criteria.andProductNameEqualTo(productName);
            Page<Product> page = (Page<Product>) productMapper.selectByExample(productExample);
            PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
            return pageResult;
        }


    }

    @Override
    public PageResult selectProductPageList(Integer pageNo, Integer pageSize) {

        //分页
        PageHelper.startPage(pageNo,pageSize);
        Page<Product> page = (Page<Product>) productMapper.selectByExample(null);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Result addProduct(Product product) {
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        //把价格x100
        product.setProductPrice(product.getProductPrice());
        int i = productMapper.insert(product);
        if(i<=0){
            return new Result(false,"插入失败");
        }
        return new Result(true,"插入成功");
    }

    @Override
    public Result deleteProductByProductId(Integer id) {
        int i = productMapper.deleteByPrimaryKey(id.longValue());
        if (i<=0){
            return new Result(false,"删除失败");
        }
        return new Result(true,"删除成功");
    }

    @Override
    public Result updateProductByProduct(Product product) {

        //修改时间
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        int i = productMapper.updateByPrimaryKeySelective(product);
       // int i = productMapper.updateByPrimaryKey(product);
        if (i<=0){
            return new Result(false,"更新失败");
        }
        return new Result(true,"更新成功");
    }


    /*@Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> selectProductList() {
        List<Product> productList = productMapper.selectProductList();
        return productList;
    }

    @Override
    public PageResult selectProductBYExampl(Integer pageNum, Integer pageSize, String productName) {

        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        //执行查询
        Page<Product> page = (Page<Product>) productMapper.selectProductBYExampl(productName);


        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
        return pageResult;
    }

    @Override
    public PageResult selectProductPageList(Integer pageNum, Integer pageSize) {

        //设置分页
        PageHelper.startPage(pageNum,pageSize);


        //执行查询
        Page page= (Page) productMapper.selectProductPageList();


        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());

        return pageResult;
    }

    @Override
    public Result addProduct(Product product) {


        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        int i = productMapper.addProduct(product);
        if(i<=0){
            return new Result(false,"插入失败");
        }
        return new Result(true,"插入成功");
    }

    @Override
    public Result deleteProductByProductId(Integer id) {

        int i = productMapper.deleteProductByProductId(id);
        if (i<=0){
            return new Result(false,"删除失败");
        }
        return new Result(true,"删除成功");
    }

    @Override
    public Result updateProductByProduct(Product product) {
        //修改时间
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        int i = productMapper.updateProductByProduct(product);
        if (i<=0){
            return new Result(false,"更新失败");
        }
        return new Result(true,"更新成功");
    }*/


}
