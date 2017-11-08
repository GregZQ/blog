function addSay(){
	if (sayTest()){
		var options={
			url:"../say/addsay",
			type:"post",
			success:function(data){
				alert(data);
			}
		}
	$("#jvForm").ajaxSubmit(options);
	}else{
		alert("内容不能为空");
	}
	
}

function sayTest(){
	if ($("#mcon").val()==""){
		return false;
	}else{
		return true;
	}
}
