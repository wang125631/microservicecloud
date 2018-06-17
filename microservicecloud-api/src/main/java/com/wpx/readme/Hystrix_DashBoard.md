
1.说明
	
	Hystrix Dashboard是Hystrix的仪表盘组件,主要用来实时监控Hystrix的各项指标信息,
	通过界面反馈的信息可以快速发现系统中存在的问题

2.添加依赖
	
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-hystrix</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
	</dependency>
	
3.主启动类
	
	@SpringBootApplication
	@EnableHystrixDashboard
	public class DeptConsumer_DashBoard_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}
	}
	
4.提供者启动类

	@SpringBootApplication
	@EnableEurekaClient
	@EnableCircuitBreaker
	public class DeptProvider8001_Hystrix_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
		}
	}
5.访问http://localhost:9001/hystrix/

![](https://github.com/wang125631/microservicecloud/blob/master/microservicecloud-api/src/test/resources/springcloud/hystrixdashboard.png)


6.查看实现监控信息

![](https://github.com/wang125631/microservicecloud/blob/master/microservicecloud-api/src/test/resources/springcloud/hystrixdashboard2.png)		 