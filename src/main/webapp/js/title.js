$(".a_delete").on("click",function (event) {
    var id=this.id;
    //使a自带的方法失效
	event.preventDefault();
	if (confirm("您确定删除吗")){
		$.ajax({
			type:"DELETE",
			url:"/title/"+id,
			success:function(data){
				alert(data);
				location.reload();
			}
		});
	}
});


/**
 * 添加文章
 * 1为直接发表
 * 0为保存为草稿
 */
function addTitle(id){
	var con=editor.txt.html();
	if (verification()){
		var options={
			url:"/title",
			type:"POST",
			data:{con:con,flag:id},
			success:function(data){
				alert(data);
			}
		}
		$("#jvForm").ajaxSubmit(options);
	}
}
//1为发布 0位存草稿
function  updateTitle(tag,tid){
    var formData = new FormData(document.getElementById("jvForm"));
    var con=editor.txt.html();
    formData.append("_method","PUT");
    formData.append("con",con);
    formData.append("flag",tag);
    $.ajax({
            url: "/title/" + tid,
            type: "post",
            data:formData,
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data);
            }
        }
    );
}
