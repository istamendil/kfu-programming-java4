<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="Registration">
  <%--
    Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
  --%>
  <form:form class="form-horizontal" method="POST" commandName="user">
    <t:input label="E-mail" path="username" required="true"/>
    <t:input label="Name" path="fullName" required="true"/>
    <t:password label="Password" path="password" required="true"/>
    <t:password label="Password Repeat" path="passwordRepeat" required="true"/>

    <button type="submit" class="btn btn-success">Register</button>
  </form:form>
</t:mainLayout>