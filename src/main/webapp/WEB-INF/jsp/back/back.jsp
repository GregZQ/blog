<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客</title>
	<link rel="stylesheet" type="text/css" href="../css/list.css">
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>

</head>
<body>

<!-- 头部导航 -->
<div class="head">
	<h1><a href="#" class="logo" title="张麒个人博客">张麒个人博客</a></h1>
	<ul id="nav">
	
	   	     <li> <a href="${pageContext.request.contextPath }/"><span class="nav1">首页</span><span class="nav2">首页</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/titleedit"><span class="nav1">写文章</span><span class="nav2">写文章</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/sayedit"><span class="nav1">写闲话</span><span class="nav2">写闲话</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/back"><span class="nav1">文章管理</span><span class="nav2">文章管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/message"><span class="nav1">留言管理</span><span class="nav2">留言管理</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/mysay"><span class="nav1">闲言碎语</span><span class="nav2">闲言碎语</span></a></li>
		<li><a href="${pageContext.request.contextPath }/back/tagedit"><span class="nav1">类别管理</span><span class="nav2">类别管理</span></a></li>

	</ul>
</div>
<!--引导-->


<div class="mb_bg cf">
	<div class="mb_bg_center">
		<ul>
			<li><a href="#">[首页]</a></li>
			<c:if test="${status==1 || status==null }">
				<li><a href="${pageContext.request.contextPath }/back/back?status=1" class="dq">文章管理</a></li>
				<li><a href="${pageContext.request.contextPath }/back/back?status=0">草稿箱</a></li>
			</c:if>
			<c:if test="${status==0 }">
				<li><a href="${pageContext.request.contextPath }/back/back?status=1">文章管理</a></li>
				<li><a href="${pageContext.request.contextPath }/back/back?status=0" class="dq">草稿箱</a></li>
			</c:if>
			
		</ul>
	</div>
</div>

<!-- 内容开始 -->
<div class="content cf">
		<label>标签：</label>
		<form action="${pageContext.request.contextPath }/back/back" method="post">
		<select name="tag">
			<option value="0">全部</option>
			<c:forEach items="${tagList }" var="tagg">
				<c:choose>
				   <c:when test="${tagg.tid==tag }">
						<option value="${tagg.tid }" selected="selected">${tagg.tcon }</option>
					</c:when>
					<c:otherwise>
					    <option value="${tagg.tid }">${tagg.tcon }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<label>类型：</label>
		<select name='type'>
		   		
			<option value="1">原创</option>
			<c:if test="${type==0 }">
			<option value="0" selected="selected">转载</option>
			</c:if>
			<c:if test="${type!=0 }">
			<option value="0">转载</option>
			</c:if>
			
		</select>
		<input type="hidden" name="status" value="${status }"/>
		<input type="submit" value="提交" />
		</form>
		<table class="table table-striped">
					  <thead>
					    <tr>
					      <th>文章名称</th>
					      <th>阅读量</th>
					      <th>评论权限</th>
					      <th>操作</th>
					    </tr>
					  </thead>
					  <tbody>
					      <c:forEach items="${pageBean.list }"  var="page">
							    <tr>
							      <td>${page.tname }</td>
							      <td>${page.tcount }</td>
							      <td>禁止评论</td>
								  <td>
								  	<a href="${pageContext.request.contextPath }/title/delete?tid=${page.tid}">删除</a>
								  	<a href="${pageContext.request.contextPath }/title/updatepage?tid=${page.tid}">编辑</a>
								  	<a href="">置顶</a>
								  </td>
							    </tr>
						    </c:forEach>
					  </tbody>
		</table>
		<div class="paging">
		   <c:if test="${paegBean.currentPage>1 }">
			<a href="${pageContext.request.contextPath }/back/back?currentPage=${pageBean.currentPage-1}&status=${status}&type=${type }&tag=${tag}">上一页</a>
			</c:if>
			<c:choose>
				<c:when test="${pageBean.totalPage<10}">
					<c:set var="begin"  value="1"/>
					<c:set var="end" value="${pageBean.totalPage }"></c:set>
				</c:when>
				<c:otherwise>
				    <c:set var="begin" value="${pageBean.currentPage-4 }"/>
				    <c:set var="end" value="${pageBean.currentPage+5 }"/>
				    <c:if test="${begin<1 }">
				    	<c:set var="begin" value="1"/>
				    	<c:set var="end" value="10"/>
				    </c:if>
				    <c:if test="${pageBean.totalPage<end }">
				    	<c:set var="begin" value="${pageBean.totalPage-9 }"></c:set>
				    	<c:set var="end" value="${pageBean.totalPage }"></c:set>
				    </c:if>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${begin }" end="${end }" step="1">
				 <c:choose>
				  <c:when test="${pageBean.currentPage==i }">
				<a href="javascript:void(0)" class="current">${i }</a>
				</c:when>
				<c:otherwise>
				<a href="${pageContext.request.contextPath }/back/back?currentPage=${i}&status=${status}&type=${type }&tag=${tag}">${i }</a>
				</c:otherwise>
				</c:choose>	
			</c:forEach>
			  <c:if test="${pageBean.currentPage<pageBean.totalPage }">
				<a href="${pageContext.request.contextPath }/back/back?currentPage=${pageBean.currentPage+1}&status=${status}&type=${type }&tag=${tag}">下一页</a>
			</c:if>
		</div>
	</div>
</div>

<div class="bottom_footer">
		<ul>
			<li><img src="images/logo2.png" alt="" /></li>
		</ul>
</div>
</body>
</html>