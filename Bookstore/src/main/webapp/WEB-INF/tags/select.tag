<%@tag description="Extended select tag to allow for sophisticated errors and Bootstrap theming" pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="cssClass"    required="false" type="java.lang.String"%>
<%@attribute name="label"       required="false" type="java.lang.String"%>
<%@attribute name="nulledLabel" required="false" type="java.lang.String"%>
<%@attribute name="nulledValue" required="false" type="java.lang.String"%>
<%@attribute name="options"     required="true"  type="java.util.Collection"%>
<%@attribute name="path"        required="true"  type="java.lang.String"%>
<%@attribute name="required"    required="false" type="java.lang.Boolean"%>

<%--
  Spring form tags: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-form.tld.html
  Spring tags (including bind and its' status variable): http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring.tld.html
--%>

<c:if test="${empty label}">
  <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<c:if test="${empty nulledLabel}">
  <c:set var="nulledLabel" value="Please Select" />
</c:if>
<c:if test="${empty nulledValue}">
  <c:set var="nulledValue" value="NONE" />
</c:if>

<spring:bind path="${path}">
  <div class="form-group${status.error ? ' has-error' : '' }">
    <label class="control-label col-sm-3" for="${path}">${label}<c:if test="${required}"> <span class="required">*</span></c:if></label>
      <div class="controls col-sm-9">
      <form:select path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}">
        <form:option  value="${nulledValue}" label="${nulledLabel}" />
        <c:forEach items="${options}" var="option">
          <c:choose>
            <c:when test="${option.id == status.value}">
              <option value="${option.id}" selected>${option}</option>
            </c:when>
            <c:otherwise>
              <option value="${option.id}" >${option}</option>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </form:select>
      <c:if test="${status.error}">
        <span class="help-block">${status.errorMessage}</span>
      </c:if>
    </div>
  </div>
</spring:bind>