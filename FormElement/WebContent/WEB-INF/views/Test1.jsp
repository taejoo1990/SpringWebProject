<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Test</h1>
	<form:form modelAttribute="DataBean" action="result" >
	<form:hidden path="a1"/><br />
	<form:input path="a2"/><br />
	<form:password path="a3"/><br />
	<form:textarea path="a4"/><br />
	<button disabled="true">확인</button>
	</form:form>

</body>
</html>