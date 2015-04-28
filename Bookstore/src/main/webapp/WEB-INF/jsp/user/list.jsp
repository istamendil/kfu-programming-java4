<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="All users">
  <c:choose>
    <c:when test="${not empty users}">
      <table class="table table-hover table-striped">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>E-mail</th>
          <th>Roles</th>
          <th></th>
        </tr>
        <c:forEach var="user" items="${users}" varStatus="counter">
          <tr>
            <td>${user.id}</td>
            <td>${user.fullName}</td>
            <td>${user.username}</td>
            <td>
              <c:forEach var="authority" items="${user.authorities}" varStatus="authoritiesLoop">
                ${authority}<c:if test="${!authoritiesLoop.last}">, </c:if>
              </c:forEach>
            </td>
            <td><a href="${spring:mvcUrl("UC#edit").arg(0, user.id).build()}" class="text-success"><i class="glyphicon glyphicon-edit"></i></a></td>
          </tr>
        </c:forEach>
      </table>
    </c:when>
    <c:otherwise>
      <h3>No users to show</h3>
    </c:otherwise>
  </c:choose>
</t:mainLayout>