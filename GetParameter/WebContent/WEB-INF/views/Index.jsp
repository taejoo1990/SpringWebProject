<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Spring MVC</h1>

	<!-- Get방식의 요청 -->
	<a href="test1?data1=200&data2=200&data3=300&data3=400">test1_get</a><br /><hr /><br />

	<!-- Post방식의 요청 -->
	<form action="test2" method="post">
	data1 : <input type="text" name="data1" /><br />
	data2 : <input type="text" name="data2" /><br />
	data3 : 
			100<input type="checkbox" name="data3" value="100"/>
		    200<input type="checkbox" name="data3" value="200"/>
	 		300<input type="checkbox" name="data3" value="300"/>
	 		400<input type="checkbox" name="data3" value="400"/>
	
	<input type="submit" value="test2_post" />
	</form>
	
	
	<!-- WebServelet -->
	<hr />
	<a href="test3?data1=100&data2=200&data3=300&data3=400">test3_get</a>
	
	<!-- 데이터를 순서대로 처리함 -->
	<hr />
	<a href="test4/100/200/300">test4</a><br />
	
	<hr />
	<a href="test5?data1=100&data2=200&data3=300&data3=400">test5_get</a><br />
	
	<hr />
	<a href="test6?data1=100&data2=200&data3=300&data3=400">test6_get</a><br />
	
	<hr />
	<a href="test7?data1=100">test7_get</a><br />
	
</body>
</html>