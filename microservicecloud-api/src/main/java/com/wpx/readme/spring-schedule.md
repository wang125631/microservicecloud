# Spring Schedule Cron 表达式快速入门

1.Cron表达式的格式: 秒 分 时 日 月 周 年(可选)

<table>
	
<tr>
	<th>字段名</th>	
	<th>允许的值</th>	
	<th>允许的特殊的字符</th>		
</tr>
<tr>
	<td>秒</td>	
	<td>0-59</td>	
	<td>, - * /</td>		
</tr>
<tr>
	<td>分</td>	
	<td>0-59</td>	
	<td>, - * /</td>		
</tr>
<tr>
	<td>小时</td>	
	<td>0-23</td>	
	<td>, - * /</td>		
</tr>
<tr>
	<td>月内日期</td>	
	<td>1-31</td>	
	<td>, - ? * / L W C /</td>		
</tr>
<tr>
	<td>月</td>	
	<td>1-12 或者 IAN-DEC</td>	
	<td>, - * /</td>		
</tr>
<tr>
	<td>周内日期</td>	
	<td>1-7 或者 SUN-SAT</td>	
	<td>, - * / L C #</td>		
</tr>
<tr>
	<td>年(可选)</td>	
	<td>留空 ,1970-2099</td>	
	<td>, - * /</td>		
</tr>


</table>


