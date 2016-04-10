<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:mainLayout title="New">
  <form:form class="form-horizontal" method="POST" commandName="book">
    <t:input label="Name" required="true" path="name"/>
    <t:input label="Published" required="true" path="published"/>
    <t:input label="Pages" required="true" path="pages"/>
    <t:input label="ISBN" required="true" path="isbn"/>
    <t:input label="Link" required="false" path="url"/>
    <t:textarea label="Description" required="false" path="description"/>

    <button type="submit" class="btn btn-success">Save</button>
  </form:form>
</t:mainLayout>