package com.vrivoire.rules.handler;

import com.vrivoire.rules.core.ExecutionException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Upgrade extends AbstractHandler {

    private static final Logger LOGGER = LogManager.getLogger(Upgrade.class);

    @Override
    public void process() throws ExecutionException {
        LOGGER.info("Apply the upgrade");
    }

}
