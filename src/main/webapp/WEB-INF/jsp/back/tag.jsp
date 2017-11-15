<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒的个人博客</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>

<!-- 头部导航 -->
<div class="head">
	<h1><a href="#" class="logo" title="张麒的个人博客">张麒</a></h1>
	<ul id="nav">
		<li> <a href="${pageContext.request.contextPath }/"><span class="nav1">首页</span><span class="nav2">首页</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/edittitle"><span class="nav1">写文章</span><span class="nav2">写文章</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/editsays"><span class="nav1">写闲话</span><span class="nav2">写闲话</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/title/1"><span class="nav1">文章管理</span><span class="nav2">文章管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/message"><span class="nav1">留言管理</span><span class="nav2">留言管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/say"><span class="nav1">闲言碎语</span><span class="nav2">闲言碎语</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/tag"><span class="nav1">类别管理</span><span class="nav2">类别管理</span></a></li>

	</ul>
</div>
<!--引导-->


<div class="mb_bg cf">
	<div class="mb_bg_center">
		<ul>
			<li><a href="#">[首页]</a></li>
			<li><a href="#" class="dq">类别管理</a></li>
		</ul>
	</div>
</div>

<!-- 内容开始 -->
<div class="content cf">
		<form  class="form-inline" action="${pageContext.request.contextPath }/tag" method="post" role="form">
		 <button type="submit"  class="btn btn-default">添加新类别</button>
		 <div class="form-group">
		    <label class="sr-only" for="name">名称</label>
		    <input type="text" class="form-control" name="tcon" id="name" placeholder="请输入名称">
		  </div>
		</form>

		<table class="table table-striped">
					  <thead>
					    <tr>
					      <th>类别名称</th>
					      <th>文章总数</th>
					      <th>操作</th>
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach var="tag" items="${pageBean.list}">
						    <tr>
						      <td>${tag.tcon }</td>
							  <td id="${tag.tid}">${tag.tcount }</td>
							  <td><a href="${pageContext.request.contextPath}/tag/${tag.tid}" id="d${tag.tid}" class="a_delete">删除</a>|<a href="${pageContext.request.contextPath}/tag/${tag.tid}" id="u${tag.tid}" class="a_update">更改名称</a></td>
						    </tr>
						 </c:forEach>   
					  </tbody>
		</table>
		<div class="paging">
		  
		    <c:if test="${pageBean.currentPage>1 }">
			<a href="${pageContext.request.contextPath }/back/tag?currentPage=${pageBean.currentPage-1}">上一页</a>
			</c:if>
			<c:choose>
				<c:when test="${pageBean.totalPage<=10 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${pageBean.totalPage }"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="begin" value="${pageBean.currentPage-4 }"></c:set>
					<c:set var="end" value="${pageBean.currentPage+5 }"></c:set>
					<c:if test="${begin<1 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="10"></c:set>
					</c:if>
					<c:if test="${end>pageBean.totalPage }">
						<c:set var="begin" value="${pageBean.totalPage-9 }"></c:set>
						<c:set var="end" value="${pageBean.totalPage }"></c:set>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${begin }" end="${end }" step="1" >
				<c:choose>
					<c:when test="${i==pageBean.currentPage }">
						<a href="javascript:void(0)" class="current">${i }</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/back/tag?currentPage=${i}">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageBean.currentPage<pageBean.totalPage }">
				<a href="${pageContext.request.contextPath }/back/tag?currentPage=${pageBean.currentPage+1}">下一页</a>
			</c:if>
		</div>

	</div>
</div>

<div class="bottom_footer">
		<ul>
			<li><img src="images/logo2.png" alt=""/></li>
		</ul>
</div>

	


</body>
<script type="text/javascript">
	function del(id){
		if (tagtest(id)){
			if (confirm("您确认删除吗，删除之后不可恢复！！！")){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tag.js"></script>
</html>