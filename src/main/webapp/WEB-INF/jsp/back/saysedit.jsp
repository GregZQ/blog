<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/say.js"></script>
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
			<li><a href="#" class="dq">写闲话</a></li>
		</ul>
	</div>
</div>

<!-- 内容开始 -->
<div class="content cf">
		<form class="form-horizontal" id="jvForm" role="form" enctype="multipart/form-data" method="post">
 			  <div class="form-group">
			    <label for="inputPassword" class="col-sm-2 control-label">内容</label>
			    <div class="col-sm-6">
			      	<textarea class="form-control" id="mcon" name="mcon" rows="6"></textarea>
			    </div>
 			 </div>
 			  <div class="form-group btn-group">
			    <button type="button" class="btn btn-default" onclick="addSay();">添加</button>
 			 </div>
  		</form>
</div>

<div class="bottom_footer">
		<ul>
			<li><img src="images/logo2.png" alt="" /></li>
		</ul>
</div>
</body>
</html>