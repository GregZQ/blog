<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客 -一个java开发者的记录</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
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
<!-- banner开始 -->
<div class="banner">
	<div class="banner_c">
		<span class="v_span"><img src="images/tx.jpg" alt="" /></span>
		<div class="banner_c_text">
			<p class="text_p1">春风化雨暖透我的心</p>
			<p class="text_p2">一生眷顾无言地送赠,是你</p>
			<p class="text_p3">多么温馨的目光</p>
			<p class="text_p4">叮嘱我跌倒不应放弃</p>
		</div>
	</div>
</div>
<!-- 内容开始 -->
<div class="content cf">
	<div class="content_bg cf">
		<ul>
			<li class="bt-l"></li><li class="bt-c"></li><li class="bt-r"></li>
		</ul>
	</div>
	<!-- 内容左边 -->
	<div class="content_left">
	  <c:forEach items="${titleList }" var="title">
		<div class="content_left_b">
			<h6>  
			 <a href="${pageContext.request.contextPath }/title/${title.tid}">	
			  <c:choose>
			    <c:when test="${title.tstatus==true }">
				 	【原创】
				 </c:when>
				 <c:otherwise>
				 	【转载】
				 </c:otherwise>
			 </c:choose>
			    ${title.tname }
			 </a>
			</h6>
		 
			<dl class="cf">
				<dt><a href="${pageContext.request.contextPath }/title/${title.tid}"><img src="http://47.94.18.185/pic/blog/titleimage/${title.tpic }" alt="" /></a></dt>
				
				<dd>
					<p style="color: black;">
						${title.tab }
					</p>	
					<a href="${pageContext.request.contextPath }/title/${title.tid}">阅读更多>></a>
				</dd>
			</dl>
			<div class="footer"><em>发布时间：<fmt:formatDate value="${title.ttime }"  pattern="yyyy-MM-dd"/></em><em>分类：<b>[${title.tag.tcon }]</b></em></div>
		</div>
	  </c:forEach>
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
						<li><b class="ph1">1</b><a href="${pageContext.request.contextPath }/title/${title.tid}">${title.tname }</a></li>
						</c:if>
						<c:if test="${i.index==1 }">
						<li><b class="ph2">2</b><a href="${pageContext.request.contextPath }/title/${title.tid}">${title.tname }</a></li>
						</c:if>
						<c:if test="${i.index==2 }">
						<li><b class="ph3">3</b><a href="${pageContext.request.contextPath }/title/${title.tid}">${title.tname }</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li><b>${i.index+1 }</b><a href="${pageContext.request.contextPath }/title/${title.tid}">${title.tname }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
				
			</ul>
		</div>

		<div class="list list_ph">
			<h5>标签管理</h5>
			<ul class="zjfk cf">
				<c:forEach items="${tagList }" var="tag">	
					<li><a href="${pageContext.request.contextPath }/title/tag?tid=${tag.tid}">${tag.tcon }(${tag.tcount })</a></li>
				</c:forEach>	
			</ul>
		</div>
		<div class="list list_ph">
			<h5>网站信息</h5>
			<div>
				<ul>
					<!-- <li>网站总访问量：${applicationScope.AllCount}</li> -->
					<li>日访问量：${applicationScope.DayCount}</li>
				</ul>
			</div>
		</div>
		<div class="list">
			<h5>加分享</h5>
			<div class="bshare-custom icon-medium cf">
				<a title="分享到" href="http://www.bShare.cn/" id="bshare-shareto" class="bshare-more"></a>
				<a title="分享到QQ空间" class="bshare-qzone"></a>
				<a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
				<a title="分享到人人网" class="bshare-renren"></a>
				<a title="分享到腾讯微博" class="bshare-qqmb"></a>
				<a title="分享到网易微博" class="bshare-neteasemb"></a>
				<a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a>
				<span class="BSHARE_COUNT bshare-share-count">0</span>
			</div>
			<h6>扫描二维码，一起做盆友吧~<b></b></h6>
			<p class="erweima"><img src="images/erweima.png" alt="" /></p>
			<script type="text/javascript" charset="utf-8" src="js/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="js/bshareC0.js"></script>
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