package com.vrivoire.rules.handler;

import com.vrivoire.rules.core.ExecutionException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Email extends AbstractHandler {

    private static final Logger LOGGER = LogManager.getLogger(Email.class);

    @Override
    public void process() throws ExecutionException {
        LOGGER.info("E-mail the owner and inform them of the activation/upgrade");
    }

}
