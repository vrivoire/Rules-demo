package com.vrivoire.rules.handler;

import com.vrivoire.rules.Main;
import com.vrivoire.rules.core.ExecutionException;
import com.vrivoire.rules.pojo.Order;

import com.deliveredtechnologies.rulebook.NameValueReferableMap;

public abstract class AbstractHandler {

    private NameValueReferableMap<Object> factMap;
    private Order order;

    public void setFacts(NameValueReferableMap<Object> factMap) {
        this.factMap = factMap;
        order = (Order) factMap.getValue(Main.ORDER);
    }

    public NameValueReferableMap<Object> getFactMap() {
        return factMap;
    }

    public Order getOrder() {
        return order;
    }

    public abstract void process() throws ExecutionException;
}
