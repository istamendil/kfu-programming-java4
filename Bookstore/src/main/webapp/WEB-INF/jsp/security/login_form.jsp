<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="Log in">
  <%--
    Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
  --%>
  <c:if test="${error != null}">
    <div class="text-danger">
      Wrong email-password.
    </div>
  </c:if>
  <form:form class="form-horizontal" method="POST" commandName="loginForm">
    <t:input label="E-mail" path="username" required="true"/>
    <t:password label="Password" path="password" required="true"/>

    <button type="submit" class="btn btn-success">Log in</button>
  </form:form>
</t:mainLayout>