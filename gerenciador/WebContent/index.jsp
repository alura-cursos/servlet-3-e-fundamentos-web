<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<c:if test="${not empty usuarioLogado}">
    Voce esta logado como ${usuarioLogado.email}<br />
	</c:if>
	<br />
	<form action="executar?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" /><br /> <input type="submit"
			value="Enviar" />
	</form>
	<br />
	<form action="login" method="post">
		Email: <input type="text" name="email" /><br /> <br /> Senha: <input
			type="password" name="senha" /><br /> <br /> <input type="submit"
			value="Login" />
	</form>
	<br />
	<form action="executar?tarefa=Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>