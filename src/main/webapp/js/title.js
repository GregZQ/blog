$(".a_delete").on("click",function (event) {
	event.preventDefault();//使a自带的方法失效
	if (confirm("您确定删除吗")){
		$.ajax({
			type:"DELETE",
			url:"";//未完成，文件的删除
		});
	}
});
/**
 * 添加文章
 * 添加为1
 */
function addTitle(){
	var con=editor.txt.html();
	if (verification()){
		var options={
			url:"../title",
			type:"POST",
			data:{con:con,flag:"1"},
			success:function(data){
				alert(data);
			}
		}
		$("#jvForm").ajaxSubmit(options);
	}
}
/**
 * 保存为草稿,保存为0
 */
function  saveTitle(){
	var con=editor.txt.html();
	if (verification()){
		var options={
			url:"../title",
			type:"post",
			data:{con:con,flag:"0"},
			success:function(data){
				alert(data);
			}
		}
		$("#jvForm").ajaxSubmit(options);
	}
}

/**
更新文章并发布文章
*
*/
function  updateTitle(status){
	var con=editor.txt.html();
	if (verification()){
		var options={
			url:"../title/update",
			type:"post",
			data:{con:con,
				 flag:status
				},
			success:function(data){
				alert(data);
			}
		}
		$("#jvForm").ajaxSubmit(options);
	}
}