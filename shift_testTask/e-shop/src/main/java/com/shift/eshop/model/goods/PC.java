package com.shift.eshop.model.goods;

import com.shift.eshop.model.Good;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PC extends Good {
    @Column(name = "formFactor")
    public FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}
