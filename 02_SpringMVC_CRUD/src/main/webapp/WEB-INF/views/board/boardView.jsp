<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글상세조회</h1>
	<hr>
	<c:if test="${not empty sessionScope.m && sessionScope.m.memberId eq bvd.b.boardWriter }">
		<a href="/updateBoardFrm.do">수정</a>
		<a href="/deleteBoard.do">삭제</a>
		<hr>
	</c:if>
	<table style="width: 600px" border=5>
		<tr>
			<th style="width: 20%">제목</th>
			<td colspan="3" style="width: 80%">${bvd.b.boardTitle }</td>
		</tr>
		<tr>
			<th style="width: 15%">작성자</th>
			<td style="width: 35%">${bvd.b.boardWriter }</td>
			<th style="width: 15%">작성일</th>
			<td style="width: 35%">${bvd.b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:forEach items="bvd" var="fileList">
				<td><img src="/resources/upload/board/${fileList.filepath }"></td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="4">${bvd.b.boardContent }</td>
		</tr>
	</table>
	<hr>
	<a href="/boardList.do">게시판으로 이동</a>
</body>
</html>