<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<c:if test="${not empty usuarioLogado }">
    	Logado como ${usuarioLogado.email}<br />
    </c:if>
    
	Bem-vindo ao nosso gerenciador de empresas!
	<br />
	<form action="executa?tarefa=NovaEmpresa" method="post" >
		Nome: <input type="text" name="nomeEmp">
		<input type="submit" value="Enviar">
	</form>
	
	<form action="executa?tarefa=Login" method="post">
		Email: <input type="text" name="email">
		</br>
		Senha: <input type="password" name="senha">
		</br>
		<input type="submit" value="Login">
	</form>
    
    <!-- Refatoramento de codigo  -->
	<!-- <form action="logout" method="post"> -->
	<!-- <form action="FazTudo?tarefa=Logout" method="post"> -->
	<form action="executa" method="post">
	    <input type="hidden" name="tarefa" value="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>