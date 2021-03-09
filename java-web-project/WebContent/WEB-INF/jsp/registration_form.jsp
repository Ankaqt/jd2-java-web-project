<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,by.htp.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="localization_file.jsp"%>
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
				<div class="local">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="changelanguage" /> <input
							type="hidden" name="local" value="fr" /> <input type="submit"
							value="${fr_label}" /><br />
					</form>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="changelanguage" /> <input
							type="hidden" name="local" value="en" /> <input type="submit"
							value="${en_label}" /><br />
					</form>
				</div>
				<a href="Controller?command=gotoindexpage"><img
					alt="Surfhome logo" src="css/img/pngwing.png" width="183px"
					height="143"></a>
			</div>
			<ul class="links">
				<li><a href="#">${home_label}</a></li>
				<li><a href="#">${products_label}</a></li>
				<li><a href="#">${surfboars_label}</a></li>
				<li><a href="#">${surfaccessories_label}</a></li>
				<li><a href="#">${sale_label}</a></li>
				<li><a href="Controller?command=gotoaboutpage">${about_label}</a></li>
				<li><a href="#">${contact_label}</a></li>
				<li><a href="Controller?command=gotosigninpage">${login_label}</a></li>
			</ul>
		</div>
	</div>
	<main>
		<form class="form" action="Controller" method="post">
			<h1>
				<span class="registration">${registration_label}</span>
			</h1>
			<p class="inf">Please fill in this form to create an account</p>

			<input type="hidden" name="command" value="savenewuser" />
			<div class="message">
				<c:forEach var="message" items="${param.message}">
					<c:out value="${message}" />
				</c:forEach>
			</div>
			<p class="float">
				<label for="username">${username_label}</label> <input type="text"
					name="name" value="" placeholder="${username_ph}" required
					oninvalid="this.setCustomValidity('This field is required')"
					oninput="setCustomValidity('')" /> <br />
			</p>
			<p class="float">
				<label for="email">${email_label}</label> <input type="text"
					name="email" value="" placeholder="${email_ph}" required
					oninvalid="this.setCustomValidity('This field is required')"
					oninput="setCustomValidity('')" /> <br />
			</p>
			<p class="float">
				<label for="phone">${phonenumber_label}</label> <input type="text"
					name="phone" value="" placeholder="${phonenumber_ph}" required
					oninvalid="this.setCustomValidity('This field is required')"
					oninput="setCustomValidity('')" /> <br />
			</p>
			<p class="float">
				<label for="password">${password_label}</label> <input type="text"
					name="password" value="" placeholder="${password_ph}" required
					oninvalid="this.setCustomValidity('This field is required')"
					oninput="setCustomValidity('')" /> <br />
			</p>
			<input type="submit" value="${register_button}" /> <br />
			<p class="inf">
				Already have an account? <a href="Controller?command=gotosigninpage"
					class="sign-in">${login_label}</a>
			</p>
		</form>
	</main>
	<footer>
		<div class="footer">
			<div class="feed">
				<h3>${inf_ft}</h3>
				<p>How does surfing keep you healthy? Surfing is a particularly
					good way to keep fit because it is such a complete sport. When you
					surf, you work out all of your major muscle groups.</p>
			</div>
			<div class="sitemap">
				<h3>${sitemap_ft}</h3>
				<div>
					<a href="/home/">${home_ft}</a> <a href="/about/">${about_ft}</a> <a
						href="/services/">${products_ft}</a>
				</div>
				<div>
					<a href="/partners/">${partners_ft}</a> <a href="/support/">${support_ft}</a>
					<a href="/contact/">${contact_ft}</a>
				</div>
			</div>
			<div class="social">
				<h3>${networks_ft}</h3>
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