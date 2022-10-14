<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<link rel="stylesheet" href="/resources/css/dmCss.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h1>내 쪽지함</h1>
	<hr>
	<h3>쪽지보내기</h3>
	<p>받는사람, 내용 입력해서 전송하는 경우 ajax로 dm테이블에 insert</p>	
		<!-- 
		<fieldset>
			<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
			<input type="text" name="receiver" id="receiver" placeholder="받는사람"><br>
			<textarea name="dmContent" placeholder="내용을 입력하세요."></textarea><br>
		</fieldset>
		 -->
		<input type="button" value="쪽지보내기" onclick="sendDmModal();">
	<hr>
	<h3>받은 쪽지함</h3>
	<table border="1" class="receiveDmTbl">
		<thead>
		<tr>
			<th>보낸사람</th>
			<th>쪽지내용</th>
			<th>받은시간</th>
			<th>읽음여부</th>
		</tr>
		</thead>
		<tbody id="receiveDmList"></tbody>
	</table>
	<hr>
	<h3>보낸 쪽지함</h3>
	<table border="1" class="sendDmTbl">
		<thead>
		<tr>
			<th>받은사람</th>
			<th>쪽지내용</th>
			<th>보낸시간</th>
			<th>읽음여부</th>
		</tr>
		</thead>
		<tbody id="sendDmList"></tbody>
	</table>
	<!-- 쪽지보내기 모달 -->
	<div id="sendDm-modal" class="modal-wrapper" style="display:none;">
		<div class="modal">
			<div class="modal-header">
				<h2>쪽지보내기</h2>
			</div>
			<hr>
			<div class="modal-content">
				<div class="sendDmFrm">
					<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
					<label>수신자 : </label>
					<select name="receiver"></select>
					<textarea name="dmContent" placeholder="내용을 입력하세요."></textarea>
					<button onclick="dmSend();">전송</button>
					<button onclick="closeModal();">창닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 쪽지상세보기 모달 -->
	<div id="dmDetail" class="modal-wrapper" style="display:none;">
		<div class="modal">
			<div class="modal-header">
				<h2>쪽지내용</h2>
			</div>
			<hr>
			<div class="modal-content">
				<div class="dmFrm">
					<div>
						<span>발신자 : </span>
						<span id="detailSender"></span>
					</div>
					<div>
						<span>날짜 : </span>
						<span id="detailDate"></span>
					</div>
					<div id="detailContent"></div>
					<button onclick="replyDm();">답장</button>
					<button onclick="closeDetail();">창닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	/*
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
	*/
	function getReceiveDm(){
		const receiver = $("[name=sender]").val();
		$.ajax({
			url: "/getMyDmList.do",
			data: {receiver:receiver},
			success: function(list){
				console.log(list);
				const tbody = $("#receiveDmList");
	            tbody.empty();
	            for (let i = 0; i < list.length; i++) {
		            const dm = list[i];
		            const tr = $("<tr>");
					// 보낸사람, 내용, 시간, 읽음 여부
		            const senderTd = $("<td>");
		            senderTd.text(dm.sender);
		            const contentTd = $("<td>");
		            contentTd.text(dm.dmContent);
		            contentTd.attr("onclick","dmDetail("+dm.dmNo+");");
		            console.log(dm.dmContent);
		            const dmDateTd = $("<td>");
		            dmDateTd.text(dm.dmDate);
		            const readTd = $("<td>");
		            if (dm.readCheck == 0) {
		            	readTd.text("읽지않음");
		            } else {
		                readTd.text("읽음");
		            }
		            tr.append(senderTd).append(contentTd).append(dmDateTd).append(readTd);
	                tbody.append(tr);
				}
			}
		});
	}
	function getSendDm(){
		const sender = $("[name=sender]").val();
		$.ajax({
			url: "/getMyDmList.do",
			data: {sender:sender},
			success: function(list){
				console.log(list);
				$("#sendDmList").empty();
				let readCheck;
				for(let i=0; i<list.length; i++){
					const dm = list[i];
					const tr = $("<tr>");
					tr.append($("<td>"+dm.receiver+"</td>"));
					tr.append($("<td>"+dm.dmContent+"</td>"));
					tr.append($("<td>"+dm.dmDate+"</td>"));
					if(dm.readCheck == 0){
						readCheck = "읽지않음";
					}else{
						readCheck = "읽음";
					}
					tr.append($("<td>"+readCheck+"</td>"));
					$("#sendDmList").append(tr);
					/*
					const dm = list[i];
					const tr = $("<tr>");
					const receiverTd = $("<td>");
					const contentTd = $("<td>");
					const dmDateTd = $("<td>");
					const readTd = $("<td>");
					*/
				}
			}
		});
	}
	function dmDetail(dmNo){
		console.log(dmNo);
		$.ajax({
			url : "/dmDetail.do",
			data : {dmNo : dmNo},
			success : function(data) {
				$("#detailSender").text(data.sender);
				$("#detailDate").text(data.dmDate);
				$("#detailContent").text(data.dmContent);
				if(data.readCheck==0){
					getReceiveDm();
				}
				$("#dmDetail").css("display","flex");
			}
		});
	}
	function closeDetail() {
		$("#dmDetail").hide();
	}
	$(function() {
		getReceiveDm();
		getSendDm();
	})
</script>
<script type="text/javascript" src="/resources/js/dm.js"></script>
</html>