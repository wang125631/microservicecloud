package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * @EnableHystrixDashboard
 * 表示该类为是Hystrix的仪表盘组件,主要用来实时监控Hystrix的各项指标信息,通过界面反馈的信息可以快速发现系统中存在的问题
 * 
 * 所有微服务提供类都需要actuator的监控依赖配置
 * 
 * 
 * @author wangpx
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {
public static void main(String[] args) throws Exception {
	SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
}

}
