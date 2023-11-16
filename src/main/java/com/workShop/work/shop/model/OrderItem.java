package com.workShop.work.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workShop.work.shop.model.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(){

    }
    public OrderItem(OrderModel orderModel, ProductModel productModel, Integer quantity, Double price){
        id.setOrder(orderModel);
        id.setProduct(productModel);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public OrderModel getOrderModel(){
        return id.getOrder();
    }

    public void setOrderModel(OrderModel orderModel){
        id.setOrder(orderModel);
    }


    public ProductModel getProductModel(){
        return id.getProduct();
    }

    public void setProductModel(ProductModel productModel){
        id.setProduct(productModel);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
