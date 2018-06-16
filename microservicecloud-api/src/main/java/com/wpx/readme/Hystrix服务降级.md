#Hystix

1.在对外暴露的接口添加fallbackFactory
	
	@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
	public interface DeptClientService {
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
	}
	
2.重写DeptClientServiceFallbackFactory类
	
	/**
	 * 针对DeptClientService接口进行降级处理 大坑 不要忘记@Component注解
	 * 实现FallbackFactory接口并指定泛型类型
	 * @author wangpx
	 *
	 */
	@Component
	public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}
	}
	
3.主启动类请求测试

	@SpringBootApplication
	@EnableEurekaClient
	@EnableFeignClients(basePackages = { "com.wpx" })
	@ComponentScan("com.wpx")
	public class DeptConsumerFeign_App {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(DeptConsumerFeign_App.class, args);
		}
	}