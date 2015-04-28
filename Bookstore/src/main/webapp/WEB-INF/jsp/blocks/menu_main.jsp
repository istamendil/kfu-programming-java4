<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${spring:mvcUrl('BC#list').build()}">Home</a></li>
        <li><a href="${spring:mvcUrl('BC#add').build()}">New Book</a></li>
        <li><a href="${spring:mvcUrl('UC#list').build()}">Users list</a></li>
        <security:authorize access="isAuthenticated()">
          <li><a href="${spring:mvcUrl('SC#profile').build()}">Profile</a></li>
          <li><a href="<spring:url value="/logout" />">Log out</a></li>
        </security:authorize>
        <security:authorize access="isAnonymous()">
          <li><a href="${spring:mvcUrl('SC#register').build()}">Register</a></li>
          <li><a href="<spring:url value="/login"/>">Log in</a></li>
        </security:authorize>
        <li><a href="<c:url value='/about' />">About</a></li>
      </ul>
    </div>
  </div>
</nav>