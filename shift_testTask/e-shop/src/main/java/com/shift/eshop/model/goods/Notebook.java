package com.shift.eshop.model.goods;

import com.shift.eshop.model.Good;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Notebook extends Good {
    @Column(name = "size")
    public int size;

    public enum Diagonal {
        THIRTEEN,
        FOURTEEN,
        FIFTEEN,
        SEVENTEEN
    }
}