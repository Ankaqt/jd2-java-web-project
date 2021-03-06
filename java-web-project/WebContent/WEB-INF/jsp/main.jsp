<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/mainPage.css">
<title>Insert title here</title>
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
				<a href="Controller?command=gotoindexpage"><img alt="logo"
					src="css/img/pngwing.png" width="183px" height="143"></a>
			</div>
			<ul class="links">
				<li><a href="#">Home</a></li>
				<li><a href="#">New products</a></li>
				<li><a href="#">Surfboards</a></li>
				<li><a href="#">Surf Accessories</a></li>
				<li><a href="#">Sale</a></li>
				<li><a href="Controller?command=gotoaboutpage">About</a></li>
				<li><a href="#">Contacts</a></li>
				<li><a href="Controller?command=logout">Sign out</a></li>
			</ul>
		</div>
	</div>
	<main>
		<h1 align="center">
			<c:if test="${user != null}">
				<p>Welcome to SURFHOME, ${user.name} - ${user.role}</p>
			</c:if>
		</h1>
		<div style="text-align: center;">
			<h1 class="title">NEWS</h1>
		</div>
		<div class="news">
			<c:forEach var="n" items="${requestScope.news}">
				<h1>
					<span class="title1"><c:out value="${n.title}" /> </span>
				</h1>
				<br />
				<c:out value="${n.date}" />
				<br />
				<c:out value="${n.brief}" />
				<br />
				<a href="Controller?command=shownews&id=<c:out value="${n.id}" /> "
					class="read">Read completely</a>
			</c:forEach>
		</div>
		<h4>
			<c:if test="${sessionScope.user.role eq \"admin\"}">
				<a href="Controller?command=gotoaddnewspage" class="addNews">Add
					news</a>
			</c:if>
		</h4>
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