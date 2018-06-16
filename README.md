# microservicecloud

#什么是微服务?
	
	     就目前而言对于微服务业界没有一个统一的,标准的定义.但通常而言,微服务是一种架构模式或者说是一种架构风格,
	它提倡单一应用程序划分为一组小的服务,每个服务在其独立的自己的进程中,服务之间相互协调,互相配合,为用户提
	供最终价值.服务之间采用轻量级的通信机制互相沟通(基于Http的Restful API)每个服务都围绕着具体的业务进行
	构建,并且能够被独立的部署到生产环境,类生产环境进行构建,可以有一个非常轻量级的集中式管理来协调这些服务,
	可以使用不同的语言来编写服务,也可以使用不同的数据存储.


#技术维度理解
	      微服务的核心就是将传统的一站式应用,根据业务分成一个一个的服务,彻底的解耦,每一个微服务提供 单个业务功能
	 的服务.一个服务做一件事,从技术角度看就是一种小而独立的处理过程,类似进程概念,能够自行单独启动或销毁,拥
	有自己独立的数据库

#微服务技术栈:

<table  align="center">
	<tr>
		<th>微服务条目</th>
		<th>产品实现</th>
	<tr>
	<tr>
		<td>服务开发</td>
		<td>Springboot,Spring,SpringMVC</td>
	</tr>
	<tr>
		<td>服务配置与管理</td>
		<td>Netflix公司的Archaius,阿里的Diamond等</td>
	</tr>
	<tr>
		<td>服务的注册与发现</td>
		<td>Eureka,Consul,Zookeeper等</td>
	</tr>
	<tr>
		<td>服务调用</td>
		<td>Rest,PRC,gRPC</td>
	</tr>
	<tr>
		<td>服务熔断器</td>
		<td>Hystrix,Envoy</td>
	</tr>
	<tr>
		<td>负载均衡</td>
		<td>Ribbon,Nginx</td>
	</tr>
	<tr>
		<td>服务接口调用</td>
		<td>Feign等</td>
	</tr>
	<tr>
		<td>消息队列</td>
		<td>Kafka,RabbitMq,ActiveMq</td>
	</tr>
	<tr>
		<td>服务配置中心管理</td>
		<td>SpringConfig,Chef等</td>
	</tr>
	<tr>
		<td>服务路由(API网关)</td>
		<td>Zuul等</td>
	</tr>
	<tr>
		<td>服务监控</td>
		<td>Zabbix,Nagios,Metrices,Spectator</td>
	</tr>
	<tr>
		<td>全链路追踪</td>
		<td>Zipkin,Brace,Dapper等</td>
	</tr>
	<tr>
		<td>服务部署</td>
		<td>OpenStack,Docker,Kubernetes</td>
	</tr>
	<tr>
		<td>数据流操作开发包</td>
		<td>SpringCloud Stream</td>
	</tr>
	<tr>
		<td>事件消息总线</td>
		<td>SpringCloud Bus</td>
	</tr>
	
<table>

 
#选型依据:
 *	1.整体解决方案和框架成熟度
 *	2.社区热度
 *  3.可维护性
 *  4.学习曲线
 
#微服务框架分类:
 *  1.阿里Dubbo/HSF
 *  2.京东JSF
 *  3.新浪微博Motan
 *  4.当当网DubboX
 

<table border="1"  style="border-collapse:collapse;">
  <tr>
    <th>功能点/服务框架</th>
    <th>Netflix/SpringCloud</th>
    <th>Motan</th>
    <th>gPRC</th>
    <th>Thrift</th>
    <th>Dubbo/DubboX</th>
  </tr>
  <tr>	
    <td>功能定位</td>
    <td>完整的微服务框架</td>
    <td>RPC框架.但整合了ZK的Consul,实现集群环境的基本服务注册/发现 </td>
    <td>RPC框架</td>
    <td>RPC框架</td>
    <td>服务框架</td>
  </tr>
  <tr>
    <td>支持Rest	</td>
    <td>是(Hession2)	</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
  <tr>							  		  			
    <td>支持RPC</td>
    <td>否</td>
    <td>是(Hession)</td>
    <td>是</td>
    <td>是</td>
    <td>是</td>
  </tr>
  <tr>							  		  			
    <td>支持多语言</td>
    <td>是(Rest形式)</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
  </tr>
  <tr>							  		  			
    <td>服务注册与发现</td>
    <td>Eureka Eureka服务注册表,Karyon服务端框架支持服务自注册和健康检查</td>
    <td>是(Zookeeper/consul)</td>
    <td>否</td>
    <td>否</td>
    <td>是</td>
  </tr>
    <tr>							  		  			
    <td>负载均衡</td>
    <td>是(服务端zuul+客户端Ribbon)Zuul-服务,动态路由 云端负载均Eureka(针对中间层服务器) </td>
    <td>是(客户端)</td>
    <td>否</td>
    <td>否</td>
    <td>是(客户端)</td>
  </tr>
  <tr>							  		  			
    <td>配置服务</td>
    <td>Netflix SpringCloud Config Server集中配置</td>
    <td>是(Zookeeper提供)</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
  </tr>
    <tr>							  		  			
    <td>服务调用链监控</td>
    <td>是(zuul) Zuul提供边缘服务,API网关</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
    <td>否</td>
  </tr>

  
</table>
 

#微服务与微服务架构?
 *  微服务强调的是服务的大小,他关注的是以点,是具体解决某一个问题/提供落地对象服务的一个服务应用,
 *  狭义的看,可以看做Eclipse中的一个个微服务工程.
 *  微服务架构为一种架构模式.他提倡将单一应用程序分成一组小的服务,服务之间互相协调,互相配合,为用户提供最终价值.
 *  每个服务运行在其独立的进程中,服务于服务间采用轻量级的通信机制互相协作(通常是Http 的Restful API) 每一个服务
 *  都围绕着具体业务进行构建,并且能够被独立的部署到生产环境,类生产环境中.另外,应当尽量避免统一的,集中式的服务管理机制,
 *  对具体的一个服务而言,应根据业务上下文,选择合适的语言,工具对其进行构建.

#SpringCloud 是什么?
 * 基于SpringBoot提供了一套为微服务(microservices)解决方案,包括服务注册与发现,
 * 配置中心,全链路监控,服务网关,负载均衡,熔断器等组件,除了基于NetFlix的开营组件做 高度抽象之外,还有一些选型中立了的开源组件.
 * 分布式微服务架构下的一站式解决方案,是各个微服务架构落地技术的结合体,俗称为微服务全家桶.

#SpringBoot和SpringCloud的关系和区别
 * 1.SpringBoot专注于方便的开发单个个体微服务
 * 2.SpringCloud是关注于全局的微服务协调治理框架,它将SpringBoot开发的一个个单体微服务整合并管理起来.
 * 为各个微服务之间提供配置管理,服务发现,断路器,路由,微代理,事件总线,决策竞选,分布式会话等集成服务.
 * 3.SpringBoot可以离开SpringCloud单独使用,而SpringCloud离不开SpringBoot
 
 
 
 

#问题汇总:
	
[Wiki说明](https://github.com/wang125631/microservicecloud/wiki)

	
