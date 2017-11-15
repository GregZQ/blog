<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客 -一个java开发者的记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/list.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}js/index.js"></script>

</head>
<body>

<!-- 头部导航 -->
<div class="head">
	<h1><a href="${pageContext.request.contextPath }" class="logo" title="张麒个人博客">张麒个人博客</a></h1>
	<ul id="nav">
		<li><a href="${pageContext.request.contextPath }/"><span class="nav1">首页</span><span class="nav2">首页</span></a></li>
		<li><a href="${pageContext.request.contextPath }/me"><span class="nav1">关于</span><span class="nav2">关于</span></a></li>
		<li><a href="${pageContext.request.contextPath }/say"><span class="nav1">人生感悟</span><span class="nav2">人生感悟</span></a></li>
		<li><a href="${pageContext.request.contextPath }/title"><span class="nav1">学习总结</span><span class="nav2">学习总结</span></a></li>
		<li><a href="${pageContext.request.contextPath }/message"><span class="nav1">留言版</span><span class="nav2">留言版</span></a></li>
	</ul>
</div>
<!--引导-->


<div class="mb_bg cf">
	<div class="mb_bg_center">
		<ul>
			<li><a href="${pageContext.request.contextPath }/">[首页]</a></li>
			<li><a href="javascript:void(0)" class="dq">全部文章</a>
			</li>
		</ul>
	</div>
</div>

<!-- 内容开始 -->
<div class="content cf">

	<!-- 内容左边 -->
	<div class="content_left">
	  <c:forEach items="${pageBean.list }" var="title">
		<div class="content_left_b">
		  	
				<h6>
				   <a href="${pageContext.request.contextPath }/title/${title.tid}.html">
				  <c:choose>
					   <c:when test="${title.ttype eq true }">【原创】 </c:when>
					   <c:otherwise>【转载】</c:otherwise>
				  </c:choose> 
					${title.tname }	
				 </a>
				</h6>
			<dl class="cf">
				<dt><a href="${pageContext.request.contextPath }/title/${title.tid}.html"><img src="http://47.94.18.185/pic/blog/titleimage/${title.tpic }" alt="" /></a></dt>
				<a href="${pageContext.request.contextPath }/title/${title.tid}.html">
				<dd>
					<p>${title.tab}</p>
				</dd>
				</a>
			</dl>
			<div class="end"><em>文章类别:<b>${title.tag.tcon }</b></em></div>
			<span class="v_span"><b>发布时间：</b><fmt:formatDate value="${title.ttime }" pattern="yyyy-MM-dd" /></span>
		</div>
	  </c:forEach>	
		<div class="paging">
		   <c:if test="${pageBean.currentPage>1 }">
			<a href="${pageContext.request.contextPath }/title?currentPage=${pageBean.currentPage-1}">上一页</a>
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
				<a href="${pageContext.request.contextPath }/title?currentPage=${i}">${i }</a>
				</c:otherwise>
				</c:choose>	
			</c:forEach>
			<c:if test="${pageBean.currentPage<pageBean.totalPage }">
				<a href="${pageContext.request.contextPath }/title?currentPage=${pageBean.currentPage+1}">下一页</a>
			</c:if>
		</div>

	</div>
</div>

<div class="bottom_footer">
		<ul>
			<li><img src="images/logo2.png" alt="" /></li>
		</ul>
</div>

    