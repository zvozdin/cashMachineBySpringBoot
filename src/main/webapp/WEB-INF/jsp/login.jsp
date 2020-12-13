<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <title><fmt:message key = "label.welcome" /></title>
    <link rel="icon" href="data:,">
</head>
<body>
    <a href="?language=en">English</a> |
    <a href="?language=ua">Українська</a>
    <hr color="green"  width="100%" >    <fmt:message key = "label.welcome" />
	<form method ="POST" action="login" >
	    <c:forEach items="${roles}" var="role">
            <input type="radio" name="role" value="${role}" required />
            <fmt:message key="role.label.${role}" />
            <br>
        </c:forEach>
        <fmt:message key = "login.label.username" />:
        <br>
        <input type="text" name="login" value="" required />
        <br>
        <fmt:message key = "login.label.password" />:
        <br>
        <input type="password" name="password" required />
        <br>
        <br>
        <fmt:message key="login.button.submit" var="buttonValue" />
        <input type="submit" value="${buttonValue}" />
    </form>
</body>
</html>
