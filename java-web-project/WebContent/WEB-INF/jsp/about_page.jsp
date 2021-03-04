<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,by.htp.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/signInPage.css">
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
				<a href="Controller?command=gotoindexpage"><img
					alt="Surfhome logo"
					src="css/img/pngwing.png"
					width="183px" height="143"></a>
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
			<img alt=""
				src="css/img/photo3.jpg"
				width="1481.5px" height="600">
			<h2>
				<span>ABOUT US</span>
			</h2>
		</div>
		<div class="info">
			<h1 class="title">THE OCEAN AWAITS</h1>
			Welcome to <strong>SURFHOME</strong>, Australia’s largest surfboard
			and stand up paddleboard retailer.
			<p>From the moment you paddle out, to your very first wave, there
				is something so satisfying about connecting with the ocean. Whether
				it's supping or surfing with family or friends, it's all about
				experiencing the fun and adventure found out on the water.</p>
			<p>Drawn to the waves and the water's edge of the eastern coast
				line of Australia, we are lucky enough to call this place home. We
				are a family of friends who are as diverse as the boards we design
				and through this we have created a surf community and culture that
				encompasses everyone.</p>
			<p>Our philosophy revolves around encouraging others and
				providing accessibility to first timers whilst supporting those who
				have been in the water their entire life. So whether you rise each
				morning to surf your local break or wait until the weekend to
				explore the waterways, we understand you: we know the importance of
				a life filled with meaningful moments. After all, that's what life
				is all about….</p>
			<p>If you’re looking for Australia’s biggest range of surfboards
				and stand up paddleboards you’ve come to the right place. We stock
				over 5000 boards and have something for everyone. We sell
				shortboards, longboards, high performance boards, softboards, mini
				mals, fish and retro shaped boards. We are proud to be home to the
				country’s most popular range of stand up paddleboards and also stock
				a huge assortment of surfing accessories.</p>
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
				<a href="/"><img
					src="css/img/pngwing.png"
					width="100px" height="80" alt="Surfhome logo"></a>
				<p>© 2021 SURFHOME| All Rights Reserved</p>
			</div>
		</div>
	</footer>
</body>
</html>