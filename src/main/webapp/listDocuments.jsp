<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

Database : <br>
<br>

<form action="index.html" method="get">
    <input type="submit" VALUE="Back to index">
</form>
<br>

<div id="message">
    <c:choose>
        <c:when test="${not empty listOutput}">

            <pre><c:out value="${listOutput}"/></pre>

            <br>
        </c:when>
        <c:otherwise>
            Database is empty
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
