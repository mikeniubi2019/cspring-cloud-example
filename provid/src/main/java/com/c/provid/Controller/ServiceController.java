package com.c.provid.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceController implements ApplicationListener<WebServerInitializedEvent> {
    private int port;
    @Value("${name}")
    private String name;
    @RequestMapping(value = "/service/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String service(@PathVariable("id") int id) throws InterruptedException {
        //Thread.sleep(ThreadLocalRandom.current().nextInt(3)*1000);
        return "service:port"+port+"--value:"+id+"->:name:"+name;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        port = webServerInitializedEvent.getWebServer().getPort();
    }
}
