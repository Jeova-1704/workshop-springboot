package com.workShop.work.shop.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CategoryModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public CategoryModel(){}

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
