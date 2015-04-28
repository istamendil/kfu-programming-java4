<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="User">
  <%--
    Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
  --%>
  <form:form class="form-horizontal" method="POST" commandName="user">
    <form:hidden path="id" required="true"/>
    <t:input label="Name" path="fullName" required="true"/>
    <div class="form-group">
      <div class="control-label col-sm-3">Roles:</div>
      <div class="controls col-sm-9">
        <form:checkboxes path="authorities" element="div" items="${authorities}" itemValue="id" itemLabel="authority" />
        <%-- <form:select path="authorities" items="${authorities}" itemValue="id" itemLabel="authority" multiple="true" /> --%>
      </div>
      <form:errors path="authorities" />
      <form:errors path="" />
    </div>

    <button type="submit" class="btn btn-success">Save</button>
  </form:form>
</t:mainLayout>