<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Pagina met naam</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
  <jsp:include page="header.jsp">
    <jsp:param name="page" value="Home"/>
  </jsp:include>
  <header>
    <h1>Show a Quote - Home</h1>

  </header>
  <main>
    <p>Lorizzle ipsizzle dolor sit pizzle, boofron adipiscing elit. Nullizzle sapien velizzle, aliquet volutpizzle,
      suscipit gizzle, pimpin' vizzle, arcu. Check it out egizzle tortor. Yippiyo erizzle. Shiznit izzle check it
      out dapibus crackalackin tempizzle you son of a bizzle. Maurizzle pellentesque nibh et my shizz. Vestibulum
      izzle tortizzle. We gonna chung you son of a bizzle izzle nisi. In owned black platea dictumst. Donec
      rizzle. Away dope shizzlin dizzle, pretium cool, mattis shizzle my nizzle crocodizzle, eleifend vitae, nunc.
      Go to hizzle suscipizzle. Daahng dawg semper velit sizzle bling bling.</p>

    <form method="post" action="Servlet?command=setCookie">
      <p>Do you want to see a quote?</p>
      <p>

        <input type="radio" value="yes" name="quote" id="quoteYes"
        ${quote == 'yes'? "checked" : ""}>
        <label for="quoteYes">Yes</label>
        <input type="radio" value="no" name="quote" id="quoteNo"
        ${quote == 'no'? "checked" : ""}>
        <label for="quoteNo">No</label>
      </p>
      <p><input type="submit" value="Send" id="submit"></p>
    </form>

    <c:if test="${quote == 'yes'}">
      <blockquote cite="Jim Hightower">
        Even a dead fish can go with the flow.
      </blockquote>
    </c:if>

  </main>
</div>

</body>
</html>