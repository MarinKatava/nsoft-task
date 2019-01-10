package com.katava.servicea;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundAmount
{
    private Double amount;


    public RoundAmount(Double amount) {
        this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Double getAmount() {
        return amount * 100;
    }
}
