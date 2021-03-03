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
<h1>회원정보페이지</h1>
<form:form modelAttribute="dataBeans" action="result">
이름 : <form:input path="name"/><br />
id : <form:input path="id"/><br />
pw : <form:password path="pw" showPassword="true" /><br />
우편번호 : <form:input path="addrNum"/><br />
주소1 : <form:input path="addr1"/><br />
주소2 : <form:input path="addr2"/><br />
<button type="submit">확인</button>
</form:form>

</body>
</html>