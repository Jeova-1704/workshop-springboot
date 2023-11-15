package com.workShop.work.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserModel client;

    public OrderModel(){}

    public OrderModel(Long id, Instant moment, UserModel client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }
}
