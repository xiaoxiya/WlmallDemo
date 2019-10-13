<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<% %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1><s:message code="spitter.welcome" text="Welcome"/></h1>

    <s:url value="/spitter/register" var="registerUrl" />

    <a href="<s:url value="/spittles"/> " > Spittles</a>
    <a href="${registerUrl}">Register</a>
</body>
</html>