<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div id="message">
    <c:choose>
        <c:when test="${not empty docId}">
            Successfully adde document to database. ID: <c:out value="${docId}"/><br>
            <br>
            Documents in database before adding: <c:out value="${countBefore}"/><br>
            Documents in database after adding : <c:out value="${countAfter}"/>
        </c:when>
        <c:otherwise>
            Failed to add document to database.
        </c:otherwise>
    </c:choose>
</div>
<br>
<br>

<form action="index.html" method="get">
    <input type="submit" VALUE="Back to index">
</form>

</body>
</html>
