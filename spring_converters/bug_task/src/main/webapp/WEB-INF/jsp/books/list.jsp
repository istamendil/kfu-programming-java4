<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="All books">
  <div class="text-info">Books in DB: ${fn:length(books)}</div>
  <div class="books-list">
  <c:choose>
    <c:when test="${not empty books}">
      <c:forEach var="book" items="${books}" varStatus="counter">
        <div class="book-card">
          <div class="book-header">
            <h3 class="book-name"><a href="${spring:mvcUrl("BC#show").arg(0, book.id).build()}">${book.name}</a></h3>
            <span class="book-url"><a href="${book.url}" target="_blank"><i class="glyphicon glyphicon-new-window"></i></a></span>
            <span class="book-info">${book.year}, ${book.publishingHouse.name}</span>
            <div class="book-action-icon"><a href="${spring:mvcUrl("BC#delete").arg(0, book.id).build()}" class="delete"><i class="glyphicon glyphicon-remove"></i></a></div>
            <div class="book-action-icon"><a href="${spring:mvcUrl("BC#edit").arg(0, book.id).build()}" class="edit"><i class="glyphicon glyphicon-edit"></i></a></div>
            <div class="clearfix"></div>
          </div>
          <div class="book-description">${book.description}</div>
        </div>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <h3>No books to show</h3>
    </c:otherwise>
  </c:choose>
  </div>
</t:mainLayout>