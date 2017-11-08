<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>张麒个人博客 -一个准java程序猿</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/list.css">
	<link rel="stylesheet" type="text/css" href="css/title.css" />
	<link rel="stylesheet" type="text/css" href="css/says.css" />
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"> 
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/message.js"></script>
	
</head>
<body>

<!-- 头部导航 -->
<div class="head">
	<h1><a href="#" class="logo" title="张麒个人博客">张麒个人博客</a></h1>
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
			<li><a href="#">[首页]</a></li>
			<li><a href="#" class="dq">留言板</a></li>
		</ul>
	</div>
</div>
<!-- 内容开始 -->
<div class="content cf">

	<!-- 内容左边 -->
	<div class="content_left">
		<div>
			<h4 style="color:black">如果你有闲暇时间的话，就在这留下你的足迹吧~</h4>
			<form action="${pageContext.request.contextPath }/message/add"  class="bs-example bs-example-form" method="post" role="form">
				<div class="form-group">
				    <textarea class="form-control" name="mcon" id="mcon" rows="3">不要超过250个字呀~~</textarea>
				 
				</div>
				<div class="input-group" style="padding-right: 300px;">
		            <span class="input-group-addon">请输入名字</span>
		            <input type="text" id="mname" name="mname" class="form-control" placeholder="必填">
	        	</div>
	        	<br>
		        <div class="input-group" style="padding-right: 300px;">
		        	<span class="input-group-addon">请输入网站</span>
		            <input type="text" id="murl" name="murl" class="form-control" placeholder="必填">
		        </div>
		        <br>
		        <div class="input-group" style="padding-right: 300px;">
		        	<span class="input-group-addon">请输入邮箱</span>
		            <input type="text" id="mmail" name="mmail" class="form-control" placeholder="必填">
		        </div>
		        <br />
		        <div class="input-group"  style="padding-right: 300px;">
		            <input type="submit" type="button" onclick="return addMessage();" class="btn btn-success"value="提交">
		        </div>
	        </form>
	          <hr/>
	        <div class="liuyan">
	        	<h2>留言：${pageBean.allCount }条</h2>
	        	<c:forEach items="${pageBean.list }" var="message" varStatus="status">
					<div class="liuyan_show">
		        		<div class="say_head">
		        			<em>${status.index+1 }楼：<b><a href="http://${message.murl }">${message.mname }</a></b></em>
		        		</div>
		        		<div class="say_con">
		        			${message.mcon }
		        		</div>
		        		<div class="say_end"><em>评论时间:<b><fmt:formatDate value="${message.mtime }" pattern="yyyy-MM-dd"/></b></em></div>	
		        	</div>
	        	</c:forEach>
	       <div class="paging">
			    <c:if test="${paegBean.currentPage>1 }">
				<a href="${pageContext.request.contextPath }/message?currentPage=${pageBean.currentPage-1}">上一页</a>
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
				<a href="${pageContext.request.contextPath }/message?currentPage=${pageBean.currentPage-1}">${i }</a>
				</c:otherwise>
				</c:choose>	
			</c:forEach>
			<c:if test="${pageBean.currentPage<pageBean.totalPage }">
				<a href="${pageContext.request.contextPath }/message?currentPage=${pageBean.currentPage+1}">下一页</a>
			</c:if>
		  </div>
	        </div>
		</div>
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