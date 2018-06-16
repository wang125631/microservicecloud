#Feign

1.说明
	
	Feign是一个声明式的Web Service客户端,它使得编写Web Serivce客户端变得更加简单

2. 在Consumer端添加Feign依赖

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-feign</artifactId>
		</dependency>
3. 在公共模块添加服务发布接口

		/**
		 * @FeignClient指定那个服务
		 * 此接口方法的@RequestMapping为服务提供者的访问路径
		 *  即服务 +  url 
		 * @author wangpx
		 *
		 */
		@FeignClient(value="MICROSERVICECLOUD-DEPT")
		public interface DeptClientService {
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
	}
	
4.将接口注入Consumer端

	@RestController
	@RequestMapping("/consumer")
	public class DeptController_Consumer {
		@Resource
		private DeptClientService service;
	
	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/dept/list")
	public List<Dept> list()
	{
		return this.service.list();
	}

	@RequestMapping(value = "/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}

	}
	
5. Feign启动类

	@SpringBootApplication
	@EnableEurekaClient
	@EnableFeignClients(basePackages = { "com.wpx" })
	@ComponentScan("com.wpx")
	public class DeptConsumerFeign_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptConsumerFeign_App.class, args);
		}
	}
