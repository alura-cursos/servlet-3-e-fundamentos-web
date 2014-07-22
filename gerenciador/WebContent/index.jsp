<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
	Usu&aacute;rio logado: ${usuarioLogado.email}
</c:if>
<form action="fazTudo" method="POST">
	<input type="hidden" name="tarefa" value="NovaEmpresa"> 
	Nome: <input name="nome" type="text">
		  <input name="botao" type="submit">
</form>

<form action="fazTudo" method="post">
	<input type="hidden" name="tarefa" value="Login">
	E-mail: <input type="email" name="email" /> 
	Senha: <input type="password" name="senha" />
	<input type="submit" value="Enviar"> 
</form>
<form action="fazTudo" method="post">
<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Logout" />
</form>
</body>
</html>