package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(updatable = false, nullable = false)
    private Integer orderId;
    private LocalDateTime orderDate;


    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_cart_id")
    private FoodCart cart;
    private String orderStatus;

//    public OrderDetails() {
//    }
//
//    public OrderDetails(Integer orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
//        this.orderId = orderId;
//        this.orderDate = orderDate;
//        this.cart = cart;
//        this.orderStatus = orderStatus;
//    }
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public LocalDateTime getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public FoodCart getCart() {
//        return cart;
//    }
//
//    public void setCart(FoodCart cart) {
//        this.cart = cart;
//    }
//
//    public String getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(String orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderDetails{" +
//                "orderId=" + orderId +
//                ", orderDate=" + orderDate +
//                ", cart=" + cart +
//                ", orderStatus='" + orderStatus + '\'' +
//                '}';
//    }
}
