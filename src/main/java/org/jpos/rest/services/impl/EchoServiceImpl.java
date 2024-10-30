package org.jpos.rest.services.impl;


import org.jpos.rest.dtos.response.EchoResponseDTO;
import org.jpos.rest.services.contracts.EchoService;
import org.jvnet.hk2.annotations.Service;




@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public EchoResponseDTO echo() {
        return new EchoResponseDTO("Echo!");
    }

}
