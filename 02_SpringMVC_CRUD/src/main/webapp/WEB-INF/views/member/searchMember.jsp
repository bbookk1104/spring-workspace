<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>조회결과</h1>
	<ul>
		<li>회원번호 : ${m.memberNo }</li>
		<li>아이디 : ${m.memberId }</li>
		<li>어쩔티비 : ${m.memberPw }</li>
		<li>이름 : ${m.memberName }</li>
		<li>전화번호 : ${m.phone }</li>
		<li>이메일 : ${m.email }</li>
	</ul>
</body>
</html>