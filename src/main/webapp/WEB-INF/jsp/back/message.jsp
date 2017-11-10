<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒的个人博客</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tag.js"></script>

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
		<li><a href="${pageContext.request.contextPath }/back/says"><span class="nav1">闲言碎语</span><span class="nav2">闲言碎语</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/tag"><span class="nav1">类别管理</span><span class="nav2">类别管理</span></a></li>
	</ul>
</div>
<!--引导-->

<!-- 内容开始 -->
<div class="content cf">

		<table class="table table-striped">
					  <thead>
					    <tr>
					      <th>留言人</th>
					      <th>留言内容</th>
					      <th>留言邮箱</th>
					      <th>留言时间</th>
					      <th>操作</th>
					    </tr>
					  </thead>
					  <tbody>
					     <c:forEach items="${pageBean.list }" var="message">
						    <tr>
						      <td>${message.mname}</td>
						      <td>${message.mname }</td>
						      <td>${message.mmail }</td>
							  <td><fmt:formatDate value="${message.mtime }" pattern="yyyy-MM-dd" /></td>
							  <td><a href="${pageContext.request.contextPath }/message/delete?mid=${message.mid}">删除</a></td>
						    </tr>
						  </c:forEach>     
					  </tbody>
		</table>
		<div class="paging">
		   <c:if test="${pageBean.currentPage>1 }">
			<a href="${pageContext.request.contextPath }/back/message?currentPage=${pageBean.currentPage-1}">上一页</a>
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
						<a href="${pageContext.request.contextPath }/back/message?currentPage=${i}">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageBean.currentPage<pageBean.totalPage }">
				<a href="${pageContext.request.contextPath }/back/message?currentPage=${pageBean.currentPage+1}">下一页</a>
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
</html>