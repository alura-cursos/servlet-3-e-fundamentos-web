<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
   <title>Busca de Empresas</title>
  </head>
  <body>

    Resultado da Busca:
	<ul>
	  <c:forEach var="empresa" items="${empresas}">
	     <li>${empresa.id}: ${empresa.nome}</li>
	  </c:forEach>
	</ul>
  </body>
</html>