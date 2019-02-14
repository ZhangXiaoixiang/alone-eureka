package com.dmeo.eureka.provider.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * MyHealthIndicator
 * 注入  健康指示器,需要重写health方法
 * @author 10905 2019/2/14
 * @version 1.0
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    /**
     * health返回一个状态即可
     * @return
     */
    @Override
    public Health health() {
        if (HealthApi.canVisitDB){
            System.out.println("数据库连接  成功!---");
            return new Health.Builder(Status.UP).build();
        }else {
            System.out.println("数据库连接  失败!---");
            return new Health.Builder(Status.DOWN).build();
        }

    }
}
