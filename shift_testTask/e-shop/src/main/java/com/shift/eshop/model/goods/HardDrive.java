package com.shift.eshop.model.goods;

import com.shift.eshop.model.Good;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HardDrive extends Good {
    @Column(name = "volume")
    public double volume;
}
