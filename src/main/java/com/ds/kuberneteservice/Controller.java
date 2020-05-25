package com.ds.kuberneteservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "teste")
public class Controller {

    private final static Logger LOGGER = Logger.getLogger(Controller.class.getName());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(){
        String response = "Here we found the service response";
        LOGGER.info(response);
        return response;
    }
}
