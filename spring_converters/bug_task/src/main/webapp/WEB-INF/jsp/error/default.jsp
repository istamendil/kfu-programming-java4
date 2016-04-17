<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:mainLayout title="abc">
    <h1>Exception</h1>
    <h2>Failed URL: ${url}</h2>
    <h3>Exception:  ${exception.message}</h3>
    <c:forEach items="${exception.stackTrace}" var="ste">
      ${ste}<br>
    </c:forEach>
</t:mainLayout>