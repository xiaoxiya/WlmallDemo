<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:from="http://www.springframework.org/tags/form">
<jsp:output omit-xml-declaration="yes"/>
<jsp:directive.page contentType="text/html; charset=UTF-8"/>
<head>
    <title>Spizza</title>
</head>
<body>
    <h2>Welcome to Spizza!!!</h2>
<from:form>
    <%--流程执行的key--%>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <input type="text" name="phoneNumber"/><br/>
        <%--触发phoneEntered事件--%>
    <input type="submit" name="_eventId_phoneEntered" value="LookUp Customer"/>
</from:form>

</body>
</html>
