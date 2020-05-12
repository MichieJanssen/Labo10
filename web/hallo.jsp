<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pagina met naam</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="Hallo"/>
    </jsp:include>
    <header>
            <p>Hallo ${naam}</p>
                 <c:if test="${naamLeeg=='yes'}">
                    <form method="post" action="Servlet?command=setNaamCookie">
                        <p>Naam veranderen?</p>
                        <p>
                            <label for="naam">Naam</label>
                            <input type="text" id="naam" name="naam" placeholder="naam">
                        </p>
                        <p><input type="submit" value="Verander Naam" id="submit"></p>
                    </form>
                </c:if>
                <c:if test="${naamLeeg=='no'}">
                    <form method="post" action="Servlet?command=vergeet">
                        <p><input type="submit" value="Vergeet Naam" id="submit"></p>
                </c:if>
    </header>
    <main>
    </main>
</div>

</body>
</html>