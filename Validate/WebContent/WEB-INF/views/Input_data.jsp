<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jstl/core" %>    
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="input_pro" method="post" accept-charset="UTF-8">
	data1 : <input type="text" name="data1" /><br />
	<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data1')}">
			${errors.getfieldError("data1").defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	data2 : <input type="text" name="data2" /><br />
		<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data2')}">
			${errors.getfieldError("data2").defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	<input type="submit" value="확인" />
</form>

</body>
</html>