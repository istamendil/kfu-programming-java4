<%@tag description="Extended input tag to allow for sophisticated errors and Bootstrap theming" pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>

<%--
  Spring form tags: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-form.tld.html
  Spring tags (including bind and its' status variable): http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring.tld.html
--%>
<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">
    <div class="form-group${status.error ? ' has-error' : '' }">
        <label class="control-label col-sm-3" for="${path}">${label}<c:if test="${required}"> <span class="required">*</span></c:if></label>
        <div class="controls col-sm-9">
            <form:input path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}"/>
            <c:if test="${status.error}">
                <span class="help-block">${status.errorMessage}</span>
            </c:if>
        </div>
    </div>
</spring:bind>