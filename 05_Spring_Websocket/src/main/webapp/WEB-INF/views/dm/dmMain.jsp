<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<h1>내 쪽지함</h1>
	<hr>
	<h3>쪽지보내기</h3>
	<p>받는사람, 내용 입력해서 전송하는 경우 ajax로 dm테이블에 insert</p>	
		<fieldset>
			<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
			<input type="text" name="receiver" id="receiver" placeholder="받는사람"><br>
			<textarea name="dmContent" placeholder="내용을 입력하세요."></textarea><br>
			<input type="button" value="쪽지보내기">
		</fieldset>
	<hr>
	<h3>받은 쪽지함</h3>
	<table border="1" class="receiveDmTbl">
		<tr>
			<th>보낸사람</th>
			<th>내용</th>
			<th>시간</th>
			<th>읽음 여부</th>
		</tr>
	</table>
	<hr>
	<h3>보낸 쪽지함</h3>
	<table border="1" class="sendDmTbl">
		<tr>
			<th>받은 사람</th>
			<th>내용</th>
			<th>시간</th>
			<th>읽음 여부</th>
		</tr>
	</table>
</body>
<script>
	$("[type=button]").on("click",function(){
		const sender = $("[name=sender]").val();
		const receiver = $("#receiver").val();
		const dmContent = $("[name=dmContent]").val();
		$.ajax({
			url: "/sendDm.do",
			data: {sender:sender, receiver:receiver, dmContent:dmContent},
			success: function(data){
				console.log(data);
			}
		});
	});
</script>
</html>