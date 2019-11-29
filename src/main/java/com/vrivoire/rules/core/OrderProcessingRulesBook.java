package com.vrivoire.rules.core;

import com.vrivoire.rules.Main;
import com.vrivoire.rules.handler.AbstractHandler;
import com.vrivoire.rules.handler.Book;
import com.vrivoire.rules.handler.Commission;
import com.vrivoire.rules.handler.Email;
import com.vrivoire.rules.handler.Membership;
import com.vrivoire.rules.handler.PhysicalProduct;
import com.vrivoire.rules.handler.Upgrade;
import com.vrivoire.rules.pojo.Order;

import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class OrderProcessingRulesBook {

    private AbstractHandler abstractHandler;

    public RuleBook<Object> orderProcessingRules() throws ExecutionException {

        return RuleBookBuilder.create()
                // physicalProduct
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> facts.getValue("action").equals("physicalProduct"))
                .then(facts -> abstractHandler = new PhysicalProduct())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                )
                // book
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> facts.getValue("action").equals("book"))
                .then(facts -> abstractHandler = new Book())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                )
                // generate a commission
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> ((String) facts.getValue("action")).contains("book") || ((String) facts.getValue("action")).contains("physicalProduct"))
                .then(facts -> abstractHandler = new Commission())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                .stop())
                // membership
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> facts.getValue("action").equals("membership") && !((Order) facts.getValue(Main.ORDER)).hasMembership())
                .then(facts -> abstractHandler = new Membership())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                )
                // Upgrade
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> facts.getValue("action").equals("upgrade") && ((Order) facts.getValue(Main.ORDER)).hasMembership())
                .then(facts -> abstractHandler = new Upgrade())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                )
                // email
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> ((String) facts.getValue("action")).contains("membership") || ((String) facts.getValue("action")).contains("upgrade"))
                .then(facts -> abstractHandler = new Email())
                .then((facts) -> abstractHandler.setFacts(facts))
                .then((facts) -> abstractHandler.process())
                .stop())
                // video
                .addRule(rule -> rule.withFactType(Object.class)
                .when(facts -> facts.getValue("action").equals("video") && ((Order) facts.getValue(Main.ORDER)).getTitle().equals("Learning to Ski"))
                .then(facts -> ((Order) facts.getValue(Main.ORDER)).addLine("First Aid"))
                .stop())
                .build();
    }
}
