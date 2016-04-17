<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="New book">
  <%--
    Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
  --%>
  <form:form class="form-horizontal" method="POST" commandName="book">
    <form:errors path="" />
    <t:input label="Name" required="true" path="name"/>
    <t:select label="Publishing House" required="true" path="publishingHouse" options="${publishingHouses}"/>
    <t:input label="Published" required="true" path="year"/>
    <t:input label="Pages" required="true" path="pages"/>
    <t:input label="ISBN" required="true" path="isbn"/>
    <t:input label="Link" required="false" path="url"/>
    <t:textarea label="Description" required="false" path="description"/>

    <button type="submit" class="btn btn-success">Save</button>
  </form:form>
</t:mainLayout>