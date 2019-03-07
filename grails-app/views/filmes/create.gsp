%{--<%@ page import="filmes.Filmes" %>--}%
<!doctype html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Biblioteca</title>
</head>

<body>
<div id="center">
	<g:form method="post" action="${instance?.id ? 'update' : 'save'}">

		<p>Nome do filme</p>
		<g:textField name="nome" class="form-control" value="${instance?.nome}"/>

		<p>Ano</p>
		<g:textField name="ano" value="${instance?.ano}"/>

		<g:submitButton name="save" action="save">Save</g:submitButton>
	</g:form>
</div>
</body>
<style>
div#center{
	margin-left: 250px;
	border: 1;
}

body {
	margin: auto;
	width: 50%;
	border: 5px solid black;
	padding: 10px;
}
</style>
</html>