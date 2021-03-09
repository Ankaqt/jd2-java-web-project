<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.language" var="language" />
<fmt:message bundle="${loc}" key="local.label.en" var="en_label" />
<fmt:message bundle="${loc}" key="local.label.fr" var="fr_label" />
<fmt:message bundle="${loc}" key="local.label.home" var="home_label" />
<fmt:message bundle="${loc}" key="local.label.products"
	var="products_label" />
<fmt:message bundle="${loc}" key="local.label.surfboars"
	var="surfboars_label" />
<fmt:message bundle="${loc}" key="local.label.surfaccessories"
	var="surfaccessories_label" />
<fmt:message bundle="${loc}" key="local.label.sale" var="sale_label" />
<fmt:message bundle="${loc}" key="local.label.about" var="about_label" />
<fmt:message bundle="${loc}" key="local.label.contacts"
	var="contact_label" />
<fmt:message bundle="${loc}" key="local.label.login" var="login_label" />
<fmt:message bundle="${loc}" key="local.label.logout" var="logout_label" />

<fmt:message bundle="${loc}" key="local.locbutton.login" var="login_button" />
<fmt:message bundle="${loc}" key="local.locbutton.registration" var="registration_button" />
<fmt:message bundle="${loc}" key="local.locbutton.register" var="register_button" />
<fmt:message bundle="${loc}" key="local.locbutton.read" var="read_button" />
<fmt:message bundle="${loc}" key="local.locbutton.add_news" var="add_button" />
<fmt:message bundle="${loc}" key="local.locbutton.save" var="save_button" />
<fmt:message bundle="${loc}" key="local.locbutton.back" var="back_button" />
<fmt:message bundle="${loc}" key="local.locbutton.delete" var="delete_button" />
<fmt:message bundle="${loc}" key="local.locbutton.edit" var="edit_button" />

<fmt:message bundle="${loc}" key="local.label.registration" var="registration_label" />
<fmt:message bundle="${loc}" key="local.label.username" var="username_label" />
<fmt:message bundle="${loc}" key="local.label.phonenumber" var="phonenumber_label" />
<fmt:message bundle="${loc}" key="local.label.password" var="password_label" />
<fmt:message bundle="${loc}" key="local.label.email" var="email_label" />

<fmt:message bundle="${loc}" key="local.placeholder.username_ph" var="username_ph" />
<fmt:message bundle="${loc}" key="local.placeholder.email_ph" var="email_ph" />
<fmt:message bundle="${loc}" key="local.placeholder.phonenumber_ph" var="phonenumber_ph" />
<fmt:message bundle="${loc}" key="local.placeholder.password_ph" var="password_ph" />

<fmt:message bundle="${loc}" key="local.footer.inf" var="inf_ft" />
<fmt:message bundle="${loc}" key="local.footer.sitemap" var="sitemap_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.home_ft" var="home_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.about_ft" var="about_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.products_ft" var="products_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.partners_ft" var="partners_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.support_ft" var="support_ft" />
<fmt:message bundle="${loc}" key="local.footer.label.contact_ft" var="contact_ft" />
<fmt:message bundle="${loc}" key="local.footer.networks" var="networks_ft" />







