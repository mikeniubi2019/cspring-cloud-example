package com.c.consumer.Controller;

import com.c.consumer.service.ServiceClient;
import com.c.consumer.service.ServiceRabbitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    ServiceClient serviceClient;
    @Autowired
    ServiceRabbitClient serviceRabbitClient;

    @Value("${name}")
    private String name;

    @RequestMapping(value = "/consumer/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String service(@PathVariable("id") int id){
        String rpo = serviceClient.service(id);
        return rpo + "consumer:name:"+name;
    }

    @RequestMapping(value = "/rabbit/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String rabbit(@PathVariable("id") int id){
        String rpo = serviceRabbitClient.service(id);
        return rpo + "consumer:name:"+name;
    }
}
