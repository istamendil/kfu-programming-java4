<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <c:if test="${not empty message}">
      <h1>${message}</h1>
    </c:if>
    <form:form method="POST" commandName="grabberForm">
      <form:label path="url">URL*</form:label>
      <form:input path="url"/>
      <form:errors path="url" /><br>

      <form:label path="xpath">xPath*</form:label>
      <form:input path="xpath"/>
      <form:errors path="xpath" /><br>

      <input type="submit" value="Parse" />
    </form:form>
    <c:if test="${not empty data}">
      <ol>
        <c:forEach items="${data}" var="item">
          <li><spring:escapeBody>${item}</spring:escapeBody></li>
        </c:forEach>
      </ol>
    </c:if>
  </body>
</html>
