#Lombok使用

[官芳网址](https://www.projectlombok.org/)

下载lombok.jar

通过命令 java -jar lombok所在目录运行程序

选择Idea进行安装

Lom常用注解及其说明
	
	@Getter getter方法
	@Setter setter方法
	@Getter(AccessLevel.PROTECTED) protected的getter方法
	@Data 
	@NoArgsConstructor 无参构造器
	@AllArgsConstructor 全参构造器
	@ToString toString方法
	@ToString(exclude="{xx1,xx2}") 排除特定字段
	@EqualsAndHashCode 默认规则重写equals和hashcode方法
	@Slf4j (使用logback框架时)可直接使用log作为对象
	@Log4j	 (使用log4j框架时)


