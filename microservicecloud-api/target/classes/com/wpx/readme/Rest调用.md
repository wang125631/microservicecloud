#Rest微服务

1.设置提供者端口和数据库连接配置
	
	server:
	  port: 8001
	  
	mybatis:
	  config-location: classpath:mybatis/mybatis.cfg.xml        # mybatis配置文件所在路径
	  type-aliases-package: com.wpx.pojo    # 所有Entity别名类所在包
	  mapper-locations:
	  - classpath:mybatis/mapper/**/*.xml                       # mapper映射文件
	    
	spring:
	   application:
	    name: microservicecloud-dept 
	   datasource:
	    type: com.alibaba.druid.pool.DruidDataSource            # 当前数据源操作类型
	    driver-class-name: org.gjt.mm.mysql.Driver              # mysql驱动包
	    url: jdbc:mysql://localhost:3306/cloudDB01              # 数据库名称
	    username: root
	    password: root
	    dbcp2:
	      min-idle: 5                                           # 数据库连接池的最小维持连接数
	      initial-size: 5                                       # 初始化连接数
	      max-total: 5                                          # 最大连接数
	      max-wait-millis: 200                                  # 等待连接获取的最大超时时间
2.编写相关服务,启动主启动类发布服务
	
	package com.wpx;

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
	/**
	 * @springBootAppliction 注解会自动扫描其子包
	 * @author wangpx
	 *
	 */
	@SpringBootApplication
	@EnableEurekaClient
	public class DeptProvider8001_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptProvider8001_App.class, args);
		}
	
	}
3.客户端配置RestTemplate

	@Configuration
	public class ConfigBean {
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

4.使用restTemplate调用
	
	package com.wpx.controller;

	import java.util.List;
	
	import javax.annotation.Resource;
	
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;
	
	import com.wpx.pojo.Dept;
	
	/**
	 * 
	 * SpringMVC中RestFul要结合HiddenHttpMethodFilter使用, 在post表单中指定name="_method"
	 * 的值为delete,put
	 * 
	 * restTemplate在此基础加以封装 访问接口(url.requestMap,ResponseBean.class)
	 * 三个参数分别为Rest请求地址,请求参数,HTTP响应转化被转化成的对象类型
	 * 
	 * @author wangpx
	 *
	 */
	@RestController
	@RequestMapping("/consumer/dept")
	public class DeptController_Consumer {

	private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	
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
	
