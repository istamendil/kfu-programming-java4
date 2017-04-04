<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <a href='${s:mvcUrl("DC#change").arg(0, "ru_RU").build()}'>Рус</a> <a href='${s:mvcUrl("DC#change").arg(0, "en_US").build()}'>Eng</a>
    <h3><s:message code="test"/></h3>
    <h3><s:message code="param.message" arguments="3.14 2.71" argumentSeparator=" "/></h3>
    <h3>${message0}</h3>
    <h3>${message1}</h3>
  </body>
</html>
