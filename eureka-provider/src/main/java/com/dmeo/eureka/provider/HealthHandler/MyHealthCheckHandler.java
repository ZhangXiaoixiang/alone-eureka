package com.dmeo.eureka.provider.HealthHandler;


import com.dmeo.eureka.provider.indicator.MyHealthIndicator;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * MyHealthCheckHandler
 * 注入健康检查处理器---实现getStatus方法 获取实例状态
 * @author 10905 2019/2/14
 * @version 1.0
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator indicator;
    /**
     * 通过外部注入健康指示器的状态类,将状态传入到健康处理器进行处理
     * @param instanceStatus 实例健康状态
     * @return 检查结果状态
     */
    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = indicator.health().getStatus();
        if (status.equals(Status.UP)){
            System.out.println("检查结果为数据库连接正常!");
            return InstanceInfo.InstanceStatus.UP;
        }else {
            System.out.println("检查结果为数据库无法连接!");
            return InstanceInfo.InstanceStatus.DOWN;
        }


    }
}
