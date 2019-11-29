package com.vrivoire.rules.handler;

import com.vrivoire.rules.core.ExecutionException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PhysicalProduct extends AbstractHandler {

    private static final Logger LOGGER = LogManager.getLogger(PhysicalProduct.class);

    @Override
    public void process() throws ExecutionException {
        LOGGER.info("Generate a packing slip for shipping");

    }
}
