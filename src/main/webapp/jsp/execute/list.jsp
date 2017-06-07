<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:forEach items="${shfilePos}" var="sh">
        <c:out value="${sh.id}"></c:out>
        <c:out value="${sh.shFile}"></c:out>
        <c:out value="${sh.bz}"></c:out>
    </c:forEach>
</body>
</html>