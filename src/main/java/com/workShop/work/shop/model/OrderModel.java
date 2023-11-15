package com.workShop.work.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.workShop.work.shop.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class OrderModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT")
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserModel client;

    public OrderModel(){}

    public OrderModel(Long id, Instant moment,OrderStatus orderStatus, UserModel client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }
}
