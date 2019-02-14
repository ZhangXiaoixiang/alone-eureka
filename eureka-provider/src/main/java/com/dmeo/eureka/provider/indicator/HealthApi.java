package com.dmeo.eureka.provider.indicator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthApi
 * 通过api模拟数据库连接状态
 * @author 10905 2019/2/14
 * @version 1.0
 */
@RestController
public class HealthApi {
    /**
     * 默认模拟不能连接数据库
     */
   static   Boolean canVisitDB=false;
    @RequestMapping(value = "/db/{canVisitDB}",method = RequestMethod.GET)
    public String setConnectState(@PathVariable("canVisitDB") Boolean canVisitDB){
        /**
         * 为当前对象的canVisitDB赋值
         */
        HealthApi.canVisitDB=canVisitDB;
        return "当前数据库连接是否正常: "+canVisitDB;
    }

}
