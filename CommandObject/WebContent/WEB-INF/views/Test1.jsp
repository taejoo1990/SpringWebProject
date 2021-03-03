<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Test1</h1>
	<!-- @modelAtribute를 가지고 오는 방법. 객체의 첫 글자를 소문자로 바꾸어야 한다. -->
	${requestScope.dataBean.data1}
	${requestScope.dataBean.data2}
</body>
</html>