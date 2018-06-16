#Ribbo

1.说明
	
	Ribbo实现客户端的负载均衡,即合理调用提供者服务

2.Consumer的pom.xml端添加Ribbo的依赖
	
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-ribbon</artifactId>
		</dependency>
		
3.在RestTemplate上添加@LoadBalanced注解

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
4.同时你可以在此文件下更换负载均衡策略

	@Bean
	public IRule myRule(){
		return new RetryRule();
	}
	
5. 你也可以自定义负载均衡策略
	
	@SpringBootApplication
	@EnableEurekaClient
	@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyselfRibboRule.class)
	public class DeptConsumer80_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptConsumer80_App.class, args);
		}
	}
	需要注意的是自定义的类不能在启动类所在包以及其子包下


