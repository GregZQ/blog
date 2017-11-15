$(".a_update").on("click",function (event) {
    var id=this.id;
    id=id.substring(1);
    //使a自带的方法失效
    event.preventDefault();
    var name=prompt("请输入新标签名称");
    if (name==""||name.trim()==""){
    	alert("名称不能为空");
	}
    else {
			$.ajax({
				type: "POST",
				url: "/tag/" + id,
				data:{
					  "tcon":name,
				      "_method":"PUT"
				},
				success:function (data) {
					alert(data);
					location.reload();
				}
		   });
    }
});
function tagchange(id){

	var name=prompt("请输入新标签名称");
	if (name==""||name.trim()==""){
		return false;
	}else{
		$.ajax({
			url:"/tag/",
			type:"post",
			data:{
			tid:id,
			tcon:name
			},
			success:function(){
				window.location.reload(); 
			}
		});
	}
}
$(".a_delete").on("click",function (event) {
    var id=this.id;
    id=id.substring(1);
    //使a自带的方法失效
    event.preventDefault();
    var value=document.getElementById(id).innerHTML;
    if (value=='0') {
        if (confirm("您确定删除吗")) {
            $.ajax({
                type: "DELETE",
                url: "/tag/" + id,
                success: function (data) {
                    alert(data);
                    location.reload();
                }
            });
        }
    }else{
    	alert("请先删除全部文章");
	}
});
