package com.vrivoire.rules;

import com.vrivoire.rules.core.ExecutionException;
import com.vrivoire.rules.core.OrderProcessingRulesBook;
import com.vrivoire.rules.pojo.Order;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.deliveredtechnologies.rulebook.FactMap;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);
    public static final String ORDER = "order";

    public static void main(String[] args) {

        OrderProcessingRulesBook ruleBook = new OrderProcessingRulesBook();
        Order order = new Order();
        order.setTitle("Learning to Ski");
        order.setMembership(false);

        test("physicalProduct", order, ruleBook);

        test("book", order, ruleBook);

        test("membership", order, ruleBook);

        order.setMembership(true);
        test("upgrade", order, ruleBook);

        test("video", order, ruleBook);
    }

    private static void test(String type, Order order, OrderProcessingRulesBook ruleBook) {
        LOG.debug(order);
        FactMap<Object> factMap = new FactMap<>();
        factMap.setValue("action", type);
        factMap.setValue(Main.ORDER, order);
        try {
            ruleBook.orderProcessingRules().run(factMap);
        } catch (ExecutionException ee) {
            LOG.error(ee.getMessage(), ee);
        }
        LOG.info("--------------------------------");
    }
}
