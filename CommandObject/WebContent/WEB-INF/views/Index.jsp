<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test1" method="post">
	data1 : <input type="text" name="data1" /><br />
	data2 : <input type="text" name="data2" /><br />
	<button type="submit">확인</button>
	<input type="reset" value="다시작성" />
	</form>
	<br /><hr />
	
	<form action="test2" method="post">
	ID : <input type="text" name="data1" /><br />
	Password : <input type="password" name="data2" /><br />
	<button type="submit">확인</button>
	<input type="reset" value="다시작성" />
	</form>

</body>
</html>