package org.jpos.rest.config.inyection;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jpos.rest.services.contracts.EchoService;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.services.impl.EchoServiceImpl;
import org.jpos.rest.services.impl.ThalesServiceImpl;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {

        bind(new EchoServiceImpl()).to(EchoService.class);

    }
}

