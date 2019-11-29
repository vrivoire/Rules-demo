package com.vrivoire.rules.handler;

import com.vrivoire.rules.core.ExecutionException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Book extends AbstractHandler {

    private static final Logger LOGGER = LogManager.getLogger(Book.class);

    @Override
    public void process() throws ExecutionException {
        LOGGER.info("Create a duplicate packing slip for the royalty department");
    }
}
