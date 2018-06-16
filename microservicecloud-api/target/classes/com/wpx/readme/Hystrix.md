#Hystix

1.说明
	
	Netflix的 Hystrix 是一个帮助解决分布式系统交互时超时处理和容错的类库, 它同样拥有保护系统的能力

2.在Provider端添加Hystrix依赖

	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-hystrix</artifactId>
	</dependency>

3.对错误信息进行处理

	/**
	 * @HystrixCommand(fallbackMethod="processHystrix_Get")
	 * 发生异常执行processHystrix_Get方法
	 */
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id")Long id){
		 Dept dept = deptService.get(id);
		if(dept ==null){
			throw new RuntimeException("该ID: "+id+" 没有与之相对应的信息!!");
		}
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

4.主启动类添加@EnableCircuitBreaker注解

	@SpringBootApplication
	@EnableEurekaClient
	@EnableCircuitBreaker
	public class DeptProvider8001_Hystrix_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
		}
	
	}
		