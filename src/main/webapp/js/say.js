function addSay(){
	if (sayTest()){
		var options={
			url:"/say",
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
$(".a_delete").on("click",function (event) {
    var id=this.id;
    //使a自带的方法失效
    event.preventDefault();
    if (confirm("您确定删除吗")){
        $.ajax({
            type:"DELETE",
            url:"/say/"+id,
            success:function(data){
                alert(data);
                location.reload();
            }
        });
    }
});
function sayTest(){
	if ($("#mcon").val()==""){
		return false;
	}else{
		return true;
	}
}
