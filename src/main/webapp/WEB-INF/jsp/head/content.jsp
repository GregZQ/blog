<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客 -一个java开发者的记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/title.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/content.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
	
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
<div class="mb_bg cf">
	<div class="mb_bg_center">
		<ul>
			<li><a href="${pageContext.request.contextPath }/">[首页]</a></li>
			<li><a href="javascript:void(0)" class="dq">文章内容</a></li>
		</ul>
	</div>
</div>
<!-- 内容开始 -->
<div class="content cf">

	<!-- 内容左边 -->
	<div class="content_left">
		<div class="con_head">
			<h2>${title.tname }</h2>
			<h5>
				<em>发布时间：<fmt:formatDate value="${title.ttime }" pattern="yyyy年MM月dd日"/></em>
				<em>浏览量：${titleCount }</em>
			</h5>
		</div>
		<div class="con_body">
			${con.con}
		  <nav>
		    <c:choose>
		      <c:when test="${title0==null }">
		  		<a href="javascrip:void(0)">上一篇：没有了~</a>
		  	  </c:when>
		  	  <c:otherwise>
		  	    <a href="${pageContext.request.contextPath }/title/${title0.tid}.html">上一篇：${title0.tname }</a>
		  	  </c:otherwise>	
		  	</c:choose>
		    <c:choose>
		       <c:when test="${title1==null }">
		  		<a href="javascrip:void(0)">下一篇：没有了~</a>
		  	   </c:when>
		  	   <c:otherwise>
		  	   	<a href="${pageContext.request.contextPath }/title/${title1.tid}.html">下一篇：${title1.tname }</a>
		  	   </c:otherwise>
		  	</c:choose>
		  </nav>
		</div>
		<div id="uyan_frame"></div>
		<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js?uid=2144018"></script>
	</div>
	<!-- 右边内容 -->
	<div class="content_right">
		<iframe id="fancybox-frame" name="fancybox-frame1506524323211" frameborder="0" scrolling="no" hspace="0"  src="http://i.tianqi.com/index.php?c=code&a=getcode&id=12&h=50&w=420">
		</iframe>

		<div class="list list_ph">
			<h5>排行榜</h5>
			<ul>
			  <c:forEach items="${countList }" var="title" varStatus="i">
				<c:choose>
					<c:when test="${i.index<=2 }">
						<c:if test="${i.index==0 }">
						<li><b class="ph1">1</b><a href="${pageContext.request.contextPath }/title/${title.tid}.html">${title.tname }</a></li>
						</c:if>
						<c:if test="${i.index==1 }">
						<li><b class="ph2">2</b><a href="${pageContext.request.contextPath }/title/${title.tid}.html">${title.tname }</a></li>
						</c:if>
						<c:if test="${i.index==2 }">
						<li><b class="ph3">3</b><a href="${pageContext.request.contextPath }/title/${title.tid}.html">${title.tname }</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li><b>${i.index+1 }</b><a href="${pageContext.request.contextPath }/title/${title.tid}.html">${title.tname }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
				
			</ul>
		</div>

		<div class="list list_ph">
			<h5>标签管理</h5>
			<ul class="zjfk cf">
				<c:forEach items="${tagList }" var="tag">	
					<li><a href="${pageContext.request.contextPath }/title/tag/${tag.tid}.html?currentPage=1">${tag.tcon }(${tag.tcount })</a></li>
				</c:forEach>	
			</ul>
		</div>
		<div class="list">
			<h5>Time</h5>
			<div class="bshare-custom icon-medium cf" style="text-align: center">
				<embed src="http://www.blogclock.cn/swf/S1000746cf11489-9.swf" Width="200px" Height="200px" type="application/x-shockwave-flash" quality="high" wmode="transparent">
				</embed>
			</div>
			<h6>扫描二维码关注<b>张麒博客</b></h6>
			<p class="erweima"><img src="../images/erweima.png" alt="" /></p>
			<script type="text/javascript" charset="utf-8" src="js/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="js/bshareC0.js"></script>
		</div>
	</div>

</div>

<div class="bottom_footer">
		<ul>
			<li><img src="../images/logo2.png" alt="" /></li>
		</ul>
</div>
</body>
</html>