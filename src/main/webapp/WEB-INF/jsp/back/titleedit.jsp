<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/title.js"></script>
</head>
<body>

<!-- 头部导航 -->
<div class="head">
	<h1><a href="#" class="logo" title="张麒个人博客">张麒个人博客</a></h1>
	<ul id="nav">
		<li> <a href="${pageContext.request.contextPath }/"><span class="nav1">首页</span><span class="nav2">首页</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/edittitle"><span class="nav1">写文章</span><span class="nav2">写文章</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/editsays"><span class="nav1">写闲话</span><span class="nav2">写闲话</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/title/1"><span class="nav1">文章管理</span><span class="nav2">文章管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/message"><span class="nav1">留言管理</span><span class="nav2">留言管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/says"><span class="nav1">闲言碎语</span><span class="nav2">闲言碎语</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/tag"><span class="nav1">类别管理</span><span class="nav2">类别管理</span></a></li>
	</ul>
</div>
<!--引导-->


<div class="mb_bg cf">
	<div class="mb_bg_center">
		<ul>
			<li><a href="#">[首页]</a></li>
			<li><a href="#" class="dq">写文章</a></li>
		</ul>
	</div>
</div>

<!-- 内容开始 -->
<div class="content cf">
		<form class="form-horizontal" id="jvForm" role="form" enctype="multipart/form-data" method="post">
  			 <c:if test="${!empty title}">
				 <input type="hidden" name="tid" value="${title.tid}"/>
			 </c:if>
  			   <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">文章名称</label>
			    <div class="col-sm-4">
			      <input class="form-control" type="text" id="tname" name="tname" placeholder="请输入文章名称" value="${empty title ? "":title.tname}">
			    </div>
 			 </div>
 			 <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">类型</label>
			    <div class="col-sm-2">
			       <select name="ttype" id='ttype' class="form-control">
				     <c:choose>
						 <c:when test="${empty title}">
						 <option value="1">原创</option>
						<option value="0">转载</option>
						 </c:when>
						 <c:otherwise>
							 <option value="1" <c:if test="${title.ttype==true}">selected="select"</c:if>>原创</option>
						     <option value="0" <c:if test="${title.ttype==false}">selected="select"</c:if>>转载</option>
						 </c:otherwise>
					 </c:choose>
			       </select>
			    </div>
 			 </div>
 			  <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">所属标签</label>
			    <div class="col-sm-2">

					<select  id="ttag" name="ttag" class="form-control">
			       	  <c:choose>
						  <c:when test="${empty title}">
							<c:forEach var="tag" items="${tagList }">
								<option value="${tag.tid }">${tag.tcon }</option>
						   </c:forEach>
						  </c:when>
						  <c:otherwise>
							  <c:forEach var="tag" items="${tagList }">
								  <option value="${tag.tid }" <c:if test="${tag.tid eq title.ttag}">selected="select"</c:if>>
										  ${tag.tcon }
								  </option>
							  </c:forEach>
						  </c:otherwise>
					  </c:choose>
			       </select>
			    </div>
 			 </div>
 			  <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">文章摘要</label>
			    <div class="col-sm-8">
			      	<textarea class="form-control" id="tab" name="tab" rows="3">
						${empty title?"":title.tab}
					</textarea>
			    </div>
 			 </div>
 			  <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">首页配图</label>
			    <div class="col-sm-8">
			    	<div class="head_ch">
			    	<img src="http://47.94.18.185/pic/blog/titleimage/${empty title ? 'default.png':title.tpic}" name="tpic" width="100px" height="100px"/>
			      	</div>
			      	<input type="file" id="tpic" name="uploadFile" />
			    </div>
 			 </div> 

 			 <div class="form-group">
 			 	<div id="editor" name="con">
					 <p>
						 ${empty title ? "" : tcon.con}
					 </p>
 			 	</div>
 			 </div>
 			  <div class="form-group btn-group">
				  <c:if test="${update eq 0}">
			    <button type="button" class="btn btn-default" onclick="addTitle();">添加</button>
			    <button type="button" class="btn btn-default" onclick="saveTitle();">存草稿</button>
				  </c:if>
			</div>
  		</form>
</div>

<div class="bottom_footer">
		<ul>
			<li><img src="images/logo2.png" alt="" /></li>
		</ul>
</div>
<script>

		var E = window.wangEditor;
		var editor = new E('#editor');
		editor.create();
function verification(){
	var tname=$("#tname").val();
	var ttype=$("#ttype").val();
	var ttag=$("#ttag").val();
	var tab=$("#tab").val();
	var tpic=$("#tpic").val();
	var con=editor.txt.text();
	if (tname==""||ttype==""||ttag==""
		||tab==""||tpic==""||con==""){
			alert("内容有缺漏");
			return false;
	}
	 return true;
}
document.getElementById('tpic').addEventListener('change',function(e){  
    
    var files = this.files;  
    var img = new Image();  
    var reader = new FileReader();  
    reader.readAsDataURL(files[0]);  
    reader.onload = function(e){  
        var mb = (e.total/1024)/1024;  
        if(mb>= 2){  
            alert('文件大小大于2M');  
            return;  
        } else{
        	var  value=document.getElementById("tpic").value;
            value=value.substr(value.lastIndexOf(".")+1);
        	if (value!="jpg"&&value!="png"){
        		alert("上传文件格式不正确");
        		return;
        	}
		}
		img.src = this.result;
        img.style.width = "100px";  
        img.style.height= "100px";  

        document.getElementsByClassName('head_ch')[0].innerHTML = '';  
        document.getElementsByClassName('head_ch')[0].appendChild(img);  
    }  
}); 
</script>
</body>
</html>
