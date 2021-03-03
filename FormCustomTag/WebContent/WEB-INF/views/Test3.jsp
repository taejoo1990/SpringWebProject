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
<form:form modelAttribute="DataBeans" action="result">
이름 : <form:input path="name"/><br />
id : <form:input path="id"/><br />
<!-- showPassword : 기본값 =false, 패스워드를 보일지.
false값이면 공란, true값이면 암호화되어 표기.  -->
pw : <form:password path="pw" showPassword="false" /><br />
우편번호 : <form:input path="addrNum"/><br />
주소1 : <form:input path="addr1"/><br />
주소2 : <form:input path="addr2"/><br />
<button type="submit">확인</button>
</form:form>

</body>
</html>