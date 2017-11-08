function  addMessage(){
	
	var mname=$("#mname").val();
	var murl=$("#murl").val();
	var mcon=$("#mcon").val();
	var mmail=$("#mmail").val();
	if (mname.trim()==""||murl.trim()==""||
		mcon.trim()==""||mmail.trim()==""){
		alert("必填内容不能为空~~");
		return false;
	}else{
		var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		if (!re.test(mmail)){
			alert("邮箱格式不正确");
			return false;
		}
		return true;
	}
}
