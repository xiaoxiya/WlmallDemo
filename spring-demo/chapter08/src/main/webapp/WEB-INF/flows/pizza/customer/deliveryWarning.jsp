<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Spizza</title>
</head>
<body>
    <h2>Delivery Unavaliable</h2>
    <p>The address is outside of our delivery area. You may still place the order, but you will need to pick it up yourself.</p>
    <a href="${flowExecutionUrl}&_eventId=accept">Accept</a> |
    <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
</body>
</html>
