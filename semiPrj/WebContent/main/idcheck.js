$(document).ready(function(){	
	
	// ID 중복검사
	$("#idcheck").click(function(){
		if($("#id").val()==""){
			alert("ID를 입력하세요");
			$("#id").focus();
			return false;
		}else{
			
			var id = $("#id").val();	
			
			$.ajax({
				type:"post",
				url:"/semiPrj/Idcheck.m",
				data:{"id":id},
				datatype:"text",
				success:function(data){
//					alert(data);
					
					if(data==1){	// 중복 ID
						$("#myid").text("중복 ID");
						$("#id").val("").focus();
					}else{			// 사용 가능한 ID
						$("#myid").text("사용 가능한 ID");
						$("#pw").focus();
					}					
				}
			});			
		}		
	});
	
	// 주민번호 뒷자리로 포커스 이동
	$("#jumin1").keyup(function(){
		
		if($("#jumin1").val().length == 6)
			$("#jumin2").focus();
	});
		
	// 도메인 선택
	$("#email").change(function(){
		if($("#email").val() == ""){	// 직접 입력 선택	
//			$("#domain").attr("readonly", false);
			$("#domain").removeAttr("readonly");
			$("#domain").val("").focus();			
		}else{							// 도메인명 선택
			$("#domain").val($("#email").val());
		    $("#domain").attr("readonly","readonly");
		}
	});	
	
	// 유효성 검사
	$("form").submit(function(){
		
		if($("#id").val() == ""){
			alert("ID를 입력하세요.");
			$("#id").focus();
			return false;
		}		
		if($("#pw").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}		
		if($("#name").val()==""){
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		if($("#jumin1").val()==""){
			alert("주민번호 앞자리를 입력하세요.");
			$("#jumin1").focus();
			return false;
		}
		if($("#jumin1").val().length != 6){
			alert("주민번호 앞자리를 6자리로 입력하세요.");
			$("#jumin1").val("").focus();
			return false;
		}
		if(isNaN($("#jumin1").val())){
			alert("숫자만 입력하세요.");
			$("#jumin1").val("").focus();
			return false;
		}
		if($("#jumin2").val()==""){
			alert("주민번호 뒷자리를 입력하세요.");
			$("#jumin2").focus();
			return false;
		}
		if($("#jumin2").val().length != 7){
			alert("주민번호 뒷자리를 7자리로 입력하세요.");
			$("#jumin2").val("").focus();
			return false;
		}
		if(isNaN($("#jumin2").val())){
			alert("숫자만 입력하세요.");
			$("#jumin2").val("").focus();
			return false;
		}
		if($("#mail").val()==""){
			alert("이메일을 입력하세요.");
			$("#mail").focus();
			return false;
		}
		if($("#tel1").val()==""){
			alert("전화번호 앞자리를 입력하세요.");
			$("#tel1").focus();
			return false;
		}
		if($("#tel1").val().length != 3){
			alert("전화번호 앞자리를 3자리로 입력하세요.");
			$("#tel1").val("").focus();
			return false;
		}
		if(isNaN($("#tel1").val())){
			alert("숫자만 입력하세요.");
			$("#tel1").val("").focus();
			return false;
		}
		if($("#tel2").val()==""){
			alert("전화번호 중간자리를 입력하세요.");
			$("#tel2").focus();
			return false;
		}

		if($("#tel2").val().length != 4){
			alert("전화번호 중간자리를 4자리로 입력하세요.");
			$("#tel2").val("").focus();
			return false;
		}
		if(isNaN($("#tel2").val())){
			alert("숫자만 입력하세요.");
			$("#tel2").val("").focus();
			return false;
		}
		if($("#tel3").val()==""){
			alert("전화번호 끝자리를 입력하세요.");
			$("#tel3").focus();
			return false;
		}

		if($("#tel3").val().length != 4){
			alert("전화번호 끝자리를 4자리로 입력하세요.");
			$("#tel3").val("").focus();
			return false;
		}
		if(isNaN($("#tel3").val())){
			alert("숫자만 입력하세요");
			$("#tel3").val("").focus();
			return false;
		}
		if($("#post").val()==""){
			alert("우편번호를 입력하세요.");
			$("#post").focus();
			return false;
		}
		if($("#addr").val()==""){
			alert("주소를 입력하세요.");
			$("#addr").focus();
			return false;
		}

	}); // submit() end		
	
});  // ready() end