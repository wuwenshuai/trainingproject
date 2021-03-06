package cn.shuhe.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.util.Date;


public class Product {

    private Long productId;


    private String productName;


    private Long productPrice;


    private String productImg;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date updatedAt;


    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_id
     *
     * @param productId the value for product.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_name
     *
     * @return the value of product.product_name
     *
     * @mbggenerated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_name
     *
     * @param productName the value for product.product_name
     *
     * @mbggenerated
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_price
     *
     * @return the value of product.product_price
     *
     * @mbggenerated
     */
    public Long getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_price
     *
     * @param productPrice the value for product.product_price
     *
     * @mbggenerated
     */
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_img
     *
     * @return the value of product.product_img
     *
     * @mbggenerated
     */
    public String getProductImg() {
        return productImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_img
     *
     * @param productImg the value for product.product_img
     *
     * @mbggenerated
     */
    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.created_at
     *
     * @return the value of product.created_at
     *
     * @mbggenerated
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.created_at
     *
     * @param createdAt the value for product.created_at
     *
     * @mbggenerated
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.updated_at
     *
     * @return the value of product.updated_at
     *
     * @mbggenerated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.updated_at
     *
     * @param updatedAt the value for product.updated_at
     *
     * @mbggenerated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}