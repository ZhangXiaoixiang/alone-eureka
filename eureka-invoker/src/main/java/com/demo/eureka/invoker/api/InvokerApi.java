package com.demo.eureka.invoker.api;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * InvokerApi
 *
 * @author 10905 2019/2/13
 * @version 1.0
 */
@RestController
@Configuration
public class InvokerApi {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
        RestTemplate restTemplate = getRestTemplate();
//        根据注册的应用名称调用服务

        String forObject = restTemplate.getForObject("http://first-service-provider/getPerson/123", String.class);
        System.out.println("进入了服务调用---");
        return forObject;
    }


    @Autowired
    private  DiscoveryClient discoveryClient;

    /**
     * 通过一个方法查询服务实例列表
     * @return
     */
    @RequestMapping(value = "/router2",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router2(){
        RestTemplate restTemplate = getRestTemplate();
//        根据注册的应用名称调用服务
        List<ServiceInstance> serviceInstance = getServiceInstance();

        for (ServiceInstance instance : serviceInstance) {
            EurekaDiscoveryClient.EurekaServiceInstance eurekaInstance=(EurekaDiscoveryClient.EurekaServiceInstance)instance;
            /**
             * 调用实例信息的方法
             */
            InstanceInfo info = eurekaInstance.getInstanceInfo();
            System.out.println("实例名称: "+info.getAppName()+"  实例ID:  "+info.getInstanceId()+"  实例状态:  "+info.getStatus());

        }
        return "看idea控制台----注意缓存和监测心跳时间";

    }

    /**
     * 查询服务实例的方法
     */
    private List<ServiceInstance> getServiceInstance(){
        /**
         * 获取所以服务名称
         */
        List<String> services = discoveryClient.getServices();
        /**
         * 存放实例的集合
         */
        List<ServiceInstance> instances=new ArrayList<>();
        for (String service : services) {
            /**
             * 根据服务的名称获取相应的实例并且将实例放到集合
             */
            List<ServiceInstance> instanceList = discoveryClient.getInstances(service);
            instances.addAll(instanceList);
        }
        return instances;
    }




}
