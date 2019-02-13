package com.dmeo.eureka.provider.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProviderApi
 *
 * @author 10905 2019/2/13
 * @version 1.0
 */
@RestController
public class ProviderApi {
    @RequestMapping(value = "/getPerson/{id}",method = RequestMethod.GET)
    public String getPerson(@PathVariable("id") Integer id){
        System.out.println("进入服务提供者---");
        return "我是first-service-provider: 服务的getPerson,你输入的id是: "+id.toString();
    }
}
