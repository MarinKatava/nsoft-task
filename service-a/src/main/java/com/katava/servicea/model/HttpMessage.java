package com.katava.servicea.model;

import java.util.UUID;

public class HttpMessage
{
    private String id;
    private Double amount;
    private String currency;

    public HttpMessage()
    {
        id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "HttpMessage{" + "id='" + id + '\'' + ", amount=" + amount + ", currency='" + currency + '\'' + '}';
    }
}
