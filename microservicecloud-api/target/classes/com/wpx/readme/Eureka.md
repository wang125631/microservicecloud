#Eureka

1.Eureka服务端pom.xml
	
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka-server</artifactId>
		</dependency>
	
2.application.yml

	server: 
	 port: 7001
 
	eureka: 
	  instance:
	    hostname: localhost #eureka服务端的实例名称
	    #hostname: eureka7001.com   集群配置要配置hosts将相关hostname映射为本地
	  client: 
	    register-with-eureka: false     #false表示不向注册中心注册自己。
	    fetch-registry: false           #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
	    service-url: 
	      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/  
	         #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址（单机）。
	      #defaultZone: http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka
	      
3.Eureka服务器启动

	@SpringBootApplication
	@EnableEurekaServer
	public class EurekaServer7001_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer7001_App.class, args);
		}
	}

4.将provider注册进Eureka

4.1 provider的pom.xml添加Eureka客户端

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>

4.3 provider的yml文件中指定那个Eureka

	eureka:
	  client: #客户端注册进eureka服务列表内
	    service-url: 
	      defaultZone: http://localhost:7001/eureka
	      #defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
	  instance: 
	    instance-id: microservicecloud-dept8001 #Provider集群配置时instance-id应不同,而spring.application.name不变,不同实例指向相同应用
	    prefer-ip-address: true     #访问路径可以显示IP地址     
	  info: 
		  app.name: microservicecloud
		  company.name: www.wpxcloud.xyz
		  build.artifactId: $project.artifactId$
		  build.version: $project.version$

5.启动Provider

	@SpringBootApplication
	@EnableEurekaClient
	public class DeptProvider8003_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptProvider8003_App.class, args);
		}
	}
	
6.将Consumer注册进入Eureka
6.1 Consumer端加入Eureka客户端
	
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>

6.2  在Consumer端指定那个Eureka
	
	eureka:
	  client:
	    register-with-eureka: false
	    service-url:
	     #defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/, http://eureka7003.com:7003/eureka/,
	      defaultZone: http://localhost:7001/eureka/

6.3 控制层使用spring.application.name来调用服务

	/**
	 *	提供者将服务注册进入Eureka,
	 * 消费者通过注册入服务的名称获取服务
	 * @author wangpx
	 *
	 */
	@RestController
	@RequestMapping("/consumer/dept")
	public class DeptController_Consumer {

	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@Resource
	private RestTemplate restTemplate;

	@RequestMapping(value="/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value="/get/{id}")
	public Dept get(@PathVariable("id")Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
		}
	}

7.启动Consumer服务进行测试

	@SpringBootApplication
	@EnableEurekaClient
	public class DeptConsumer80_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
	}
		
