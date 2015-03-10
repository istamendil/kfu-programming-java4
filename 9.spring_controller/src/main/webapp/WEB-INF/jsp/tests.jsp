<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
      <a href="${s:mvcUrl('DC#index').build()}">Страница по-умолчанию</a>,
      <a href="${s:mvcUrl('DC#simple').build()}">Простое действие</a>,
      <a href="${s:mvcUrl('DC#simpleMultiple').build()}">Простое действие, доступное по нескольким адресам</a>,
      <a href="${s:mvcUrl('DC#responseBody').build()}">Возвращение ответа контроллером</a>,
      <a href="${s:mvcUrl('DC#writer').build()}">Использование java.io.Writer</a>,
      <a href="${s:mvcUrl('DC#responseStatus').build()}">Задание статусного кода ответа</a>,
      <a href="${s:mvcUrl('DC#requestMappingBunch').build()}">Дополнительные опции спецификации обрабатываемого запроса</a>,
      <a href="${s:mvcUrl('DC#requestParam').arg(0, 'someValue').build()}">Получение отправленных данных</a>,
      <a href="${s:mvcUrl('DC#requestParamBanch').arg(0, 'someValue').build()}">Дополнительные опции получения отправленных данных</a>,
      <a href="${s:mvcUrl('DC#pathVariable').arg(0, 'someValue').build()}">Получение переменной из пути в адресе</a>,
      <a href="${s:mvcUrl('DC#pathVariableBunch').arg(0, 'someValue').arg(1, 'someValue2').build()}">Дополнительные опции получения переменной из пути в адресе</a>,
      <a href="${s:mvcUrl('DC#requestHeader').build()}">Чтение заголовка запроса</a>
      
      <div style="border:3px double black;margin:100px; padding:30px">
        ${viewVariable}
      </div>
      
    </body>
</html>
