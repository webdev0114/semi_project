$(document).ready(function(){
			$("form").submit(function(){
				
				if($("#q_title").val()==""){
					alert("제목을 입력 하세요.");
					$("#q_title").focus();
					return false;
				}

				if($("#q_pw").val()==""){
					alert("비밀번호를 입력 하세요.");
					$("#q_pw").focus();
					return false;
				}
				
				if($("#q_content").val()==""){
					alert("내용을 입력 하세요.");
					$("#q_content").focus();
					return false;
				}				
			});			
});	