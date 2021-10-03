package com.shift.eshop.model.goods;

import com.shift.eshop.model.Good;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Screen extends Good {
    @Column(name = "diagonal")
    public double diagonal;
}
