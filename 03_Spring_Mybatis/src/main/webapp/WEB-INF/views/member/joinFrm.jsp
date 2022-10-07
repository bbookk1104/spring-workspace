<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="join.do">
		<fieldset>
			<legend>가입정보</legend>
			아이디 : <input type="text" name="memberId" placeholder="아이디 입력"><br>
			비밀번호 : <input type="password" name="memberPw" placeholder="비밀번호 입력"><br>
			이름 : <input type="text" name="memberName" placeholder="이름 입력"><br>
			전화번호 : <input type="text" name="phone" placeholder="010-1234-5678"><br>
			이메일 : <input type="text" name="email" placeholder="email@mail.com"><br>
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
	<h3><a href="/">메인페이지</a></h3>
</body>
</html>