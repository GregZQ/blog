
function tagchange(id){
	
	var name=prompt("请输入新标签名称");
	if (name==""||name.trim()==""){
		alert("OK");
		return false;
	}else{
		$.ajax({
			url:"../tag/update",
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

function  tagtest(id){	
	if (!$("#"+id).text()=="0"){
		alert("请先删除全部 文章");
		return true;
	}else{
		return true;
	}
	
}
