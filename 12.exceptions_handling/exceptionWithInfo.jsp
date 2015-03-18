<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <h1>Exception</h1>
    <h2>Failed URL: ${url}</h2>
    <h3>Exception:  ${exception.message}</h3>
    <c:forEach items="${exception.stackTrace}" var="ste">
      ${ste}<br>
    </c:forEach>
  </body>
</html>
