<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<c:forEach items="${list }" var="list">
		아이디 : ${list.mid }<br><br>
		비밀번호 : ${list.mpw }<br><br>
		이름 : ${list.mname }<br><br>
		이메일 : ${list.memail }<br><br>
		가입일 : ${list.mdate }<br><br>
		<hr>
	</c:forEach>
</body>
</html>