<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Test1_get</h1>
<form action="result" method="post">
이름    : <input type="text" name="name" value="${requestScope.DataBeans.name }" /><br />
ID     : <input type="text" name="id" value="${requestScope.DataBeans.id }"/> <br />
비밀번호 : <input type="password" name="pw" value="${requestScope.DataBeans.pw }"/> <br />
우편번호 : <input type="number" name="addrNum" value="${requestScope.DataBeans.addrNum }"/> <br />
주소1   : <input type="text" name="addr1" value="${requestScope.DataBeans.addr1 }"/> <br />
주소2   : <input type="text" name="addr2" value="${requestScope.DataBeans.addr2 }"/> <br />
<button type="submit">확인</button>
<input type="reset" value="재작성" />
</form>

</body>
</html>