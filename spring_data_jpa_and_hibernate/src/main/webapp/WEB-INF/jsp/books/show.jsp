<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Show">
  <div class="book-page">
  <c:choose>
    <c:when test="${not empty book}">
      <h1 class="book-name">${book.name}</h1>
      <div class="book-field">
        <span class="field-name">Year:</span>
        <span class="field-value">${book.published}</span>
      </div>
      <div class="book-field">
        <span class="field-name">ISBN:</span>
        <span class="field-value">${book.name}</span>
      </div>
      <div class="book-field">
        <span class="field-name">Link:</span>
        <span class="field-value"><a href="${book.url}" target="_blank">${book.url}</a></span>
      </div>
      <div class="book-description">${book.description}</div>
    </c:when>
    <c:otherwise>
      <h3>No books to show</h3>
    </c:otherwise>
  </c:choose>
  </div>
</t:mainLayout>