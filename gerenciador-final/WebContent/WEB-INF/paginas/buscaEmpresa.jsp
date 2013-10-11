<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Resultado da busca:

<ul>
<c:forEach var="empresa" items="${empresas }">
	<li>${empresa.id }: ${empresa.nome }</li>
</c:forEach>
</ul>

</body></html>