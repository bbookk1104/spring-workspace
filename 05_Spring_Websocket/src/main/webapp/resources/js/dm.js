/**
 * 
 */
function sendDmModal(){
	$.ajax({
		url: "/selectAllMemberId.do",
		success: function(list){
			$("select[name=receiver]").empty();
			for(let i=0; i<list.length; i++){
				const option = $("<option>");
				option.val(list[i]);
				option.text(list[i]);
				$("select[name=receiver]").append(option);
			}
			$("#sendDm-modal").css("display","flex"); //show()쓰면 display:block
		}
	});
}
function closeModal(){
	$("#sendDm-modal").hide();
	$("textarea[name=dmContent]").val("");
}
function dmSend(){
	const sender = $("[name=sender]").val();
	const receiver = $("select[name=receiver]").val();
	const dmContent = $("[name=dmContent]").val();
	$.ajax({
		url: "/sendDm.do",
		data: {sender:sender, receiver:receiver, dmContent:dmContent},
		success: function(data){
			getSendDm();
			if(data == "1"){
				closeModal();
			}else{
				alert("쪽지보내기 실패");	
			}
		}
	});
}