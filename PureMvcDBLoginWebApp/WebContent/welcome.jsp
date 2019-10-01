<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@ include file="header.html" %>



<c:set var="uname" value="${param.username }" scope="session"></c:set> 
<c:url var="productUrlEnc" value="product.jsp"></c:url>
<%@ include file="header.html" %>
<p>Dear ${param.username } Welcome to Online Shopping of Zensar</p>
<p>Your Session Timeout period is ${pageContext.session.maxInactiveInterval} seconds</p>
<p> TO view and purchase products<a href="${ productUrlEnc }">Click Here</a></p>


<%@ include file="footer.html" %>
</body>
</html>