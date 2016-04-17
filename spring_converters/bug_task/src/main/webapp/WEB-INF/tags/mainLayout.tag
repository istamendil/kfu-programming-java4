<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>
  
<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>

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
      Bookstore<c:if test="${not empty title}" > :: ${title}</c:if>
      </title>

      <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>
      <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
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