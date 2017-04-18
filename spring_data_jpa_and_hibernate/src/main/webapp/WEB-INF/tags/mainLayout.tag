<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>
<%@attribute name="title" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty messageType}" >
  <c:choose>
    <c:when test="${messageType == 'success'}">
      <c:set var="messageClass" value="text-success"/>
    </c:when>
    <c:when test="${messageType == 'fail'}">
      <c:set var="messageClass" value="text-danger"/>
    </c:when>
  </c:choose>
</c:if>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      Spring JPA Example
      <c:if test="${not empty title}" >:: ${title}</c:if>
      </title>

    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
  </head>
  <body>
    <jsp:include page="/WEB-INF/jsp/blocks/menu_main.jsp"/>
    <div class="container">
      <c:if test="${not empty message}">
        <div class="global-message ${empty messageClass ? '' :  messageClass}">${message}</div>
      </c:if>
      <jsp:doBody/>
    </div>
  </body>
</html>