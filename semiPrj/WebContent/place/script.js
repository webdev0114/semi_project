$(document).ready(function(){
	$("form").submit(function(){
		if($("#p_name").val()==""){
			alert("여행지 이름을 입력하세요.");
			$("#p_name").focus();
			return false;
		}
		if($("#id").val()==""){
			alert("작성자를 입력하세요.");
			$("#id").focus();
			return false;
		}
		if($("#p_pw").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#p_pw").focus();
			return false;
		}
		if($("#p_content").val()==""){
			alert("여행지 소개를 입력하세요.");
			$("#p_content").focus();
			return false;
		}
		if($("#p_addr").val()==""){
			alert("여행지 주소를 입력하세요.");
			$("#p_addr").focus();
			return false;
		}
	});
});