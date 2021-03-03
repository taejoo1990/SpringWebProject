<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test2</h1>
<h3>data1 : ${requestScope.data1 }</h3>
<h3>data2 : ${requestScope.data2 }</h3>
</body>
</html>

<!-- requestScope는 요청 정보가 발생되어 그 응답결과가 브라우져로 전달될 때 까지 생명주기를 가지고 있음. -->