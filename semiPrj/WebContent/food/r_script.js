$(document).ready(function(){
			$("form").submit(function(){
				if($("#r_pw").val()==""){
					alert("비밀번호를 입력 하세요?");
					$("#r_pw").focus();
					return false;
				}
				if($("#r_title").val()==""){
					alert("제목을 입력 하세요?");
					$("#r_title").focus();
					return false;
				}
				if($("#r_content").val()==""){
					alert("내용을 입력 하세요?");
					$("#r_content").focus();
					return false;
				}				
			});			
});	