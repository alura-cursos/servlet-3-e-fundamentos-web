<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
	Usu&aacute;rio logado: ${usuarioLogado.email}
</c:if>
<form action="adicionaEmpresa" method="POST">
	Nome: <input name="nome" type="text">
		  <input name="botao" type="submit">
</form>

<form action="login" method="post">
	E-mail: <input type="email" name="email" /> 
	Senha: <input type="password" name="senha" />
	<input type="submit" value="Enviar"> 
</form>
<form action="logout" method="post">
	<input type="submit" value="Logout" />
</form>
</body>
</html>