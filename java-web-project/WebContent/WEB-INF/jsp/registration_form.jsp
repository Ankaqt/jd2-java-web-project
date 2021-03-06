<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/registrationPage.css">
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
				<li><a href="Controller?command=gotosigninpage">Sign in</a></li>
			</ul>
		</div>
	</div>
	<form class="form" action="Controller" method="post">
		<h1>
			<span class="registration"> Registration</span>
		</h1>
		<p class="inf">Please fill in this form to create an account</p>
		
		<input type="hidden" name="command" value="savenewuser" />
		<div class="message">
			<c:forEach var="message" items="${param.message}">
				<c:out value="${message}" />
			</c:forEach>
		</div>
		<p class="float">
			<label for="username">UserName</label> <input type="text" name="name"
				value="" placeholder="Enter username" required
				oninvalid="this.setCustomValidity('This field is required')"
				oninput="setCustomValidity('')" /> <br />
		</p>
		<p class="float">
			<label for="email">Email</label> <input type="text" name="email"
				value="" placeholder="Enter email" required
				oninvalid="this.setCustomValidity('This field is required')"
				oninput="setCustomValidity('')" /> <br />
		</p>
		<p class="float">
			<label for="phone">Phone number</label> <input type="text"
				name="phone" value="" placeholder="Enter phone number" required
				oninvalid="this.setCustomValidity('This field is required')"
				oninput="setCustomValidity('')" /> <br />
		</p>
		<p class="float">
			<label for="password">Password</label> <input type="text"
				name="password" value="" placeholder="Enter password" required
				oninvalid="this.setCustomValidity('This field is required')"
				oninput="setCustomValidity('')" /> <br />
		</p>
		<input type="submit" value="Register" /> <br />
		<p class="inf">
			Already have an account? <a href="Controller?command=gotosigninpage"
				class="sign-in">Sign in</a>
		</p>
	</form>
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