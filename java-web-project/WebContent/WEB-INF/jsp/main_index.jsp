<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,by.htp.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/signInPage.css">
<title>Insert title here</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
</head>
<body>
	<div class="wrap">
		<div class="nav">
			<div class="header">
				<div class="select-style">
					<select>
						<option>EN</option>
						<option>RU</option>
					</select>
				</div>
				<a href="Controller?command=gotoindexpage"><img
					alt="Surfhome logo" src="css/img/pngwing.png" width="183px"
					height="143"></a>
			</div>
			<ul class="links">
				<li><a href="#">Home</a></li>
				<li><a href="#">New products</a></li>
				<li><a href="#">Surfboards</a></li>
				<li><a href="#">Surf Accessories</a></li>
				<li><a href="#">Sale</a></li>
				<li><a href="Controller?command=gotoaboutpage">About</a></li>
				<li><a href="#">Contacts</a></li>
				<li><a href="Controller?command=gotosigninpage">Sign in</a></li>
			</ul>
		</div>
	</div>
	<main>
		<div class="image">
			<img alt="" src="css/img/photo2.jpg" width="1481.5px" height="600">
			<h2>
				<span>If you're having a bad day, catch a wave</span>
			</h2>
		</div>
		<div style="text-align: center;">
			<h1 class="title">SURFHOME|SURFBOARDS</h1>
		</div>
		<div class="text" style="text-align: center;">With some of the
			most well known brands in the surf industry, covering a full range of
			categories and models, SURFHOME has a surfboard to suit your specific
			level of ability. So whether you’re a first-time novice, traveller,
			everyday intermediate, or an elite level surfer, we have a brand and
			board to suit you, and your budget too.</div>
		<hr>
		<br />
		<div style="text-align: center;">
			<h1 class="title">THE SURFERS CORNER</h1>
		</div>
		<div class="news">
			<c:forEach var="n" items="${requestScope.news}">
				<h1>
					<span class="title1"><c:out value="${n.title}" /></span>
				</h1>
				<br />
				<c:out value="${n.date}" />
				<br />
				<c:out value="${n.brief}" />
			</c:forEach>
		</div>
	</main>
	<footer>
		<div class="footer">
			<div class="feed">
				<h3>INF</h3>
				<p>How does surfing keep you healthy? Surfing is a particularly
					good way to keep fit because it is such a complete sport. When you
					surf, you work out all of your major muscle groups.</p>
			</div>
			<div class="sitemap">
				<h3>SITEMAP</h3>
				<div>
					<a href="/home/">Home</a> <a href="/about/">About</a> <a
						href="/services/">Products</a>
				</div>
				<div>
					<a href="/partners/">Partners</a> <a href="/customers/">Support</a>
					<a href="/contact/">Contact</a>
				</div>
			</div>
			<div class="social">
				<h3>SOCIAL NETWORKS</h3>
			</div>
			<div class="footer-logo">
				<a href="/"><img src="css/img/pngwing.png" width="100px"
					height="80" alt="Surfhome logo"></a>
				<p>© 2021 SURFHOME| All Rights Reserved</p>
			</div>
		</div>
	</footer>
</body>
</html>