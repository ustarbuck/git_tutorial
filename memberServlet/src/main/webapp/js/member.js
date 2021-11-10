//JavaScript
function checkWrite(){
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innerText = "";
	document.getElementById("repwdDiv").innerText= "";
	
	if(document.writeForm.name.value == "") 
		document.getElementById("nameDiv").innerText = "이름을 입력해주세요";
	else if(document.writeForm.id.value == "")
		document.getElementById("idDiv").innerText = "아이디를 입력해주세요";
	else if(document.writeForm.pwd.value == "")
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력해주세요";
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		document.getElementById("repwdDiv").innerText = "비밀번호가 맞지 않습니다";
	else
		document.writeForm.submit();
}

//jQuery
$(function(){
	$('#writeBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
      	$('#pwdDiv').empty();
      	$('#repwdDiv').empty();

		//id 속성
		/*if($('#name').val() == '') $('#nameDiv').html('이름 입력'); */
		
		//name 속성
		if($('input[name="name"]').val() == '') {
			$('#nameDiv').html('이름 입력');
			$('#name').focus();
		}else if($('input[name="id"]').val()=='')
			$('#idDiv').html('아이디 입력');
		else if($('input[name="pwd"]').val()=='')
			$('#pwdDiv').html('비밀번호 입력');
		else if($('input[name="pwd"]').val() != $('input[name="repwd"]').val())
			$('#repwdDiv').html('비밀번호 틀림');
		else 
			$('form[name="writeForm"]').submit();
	});
});