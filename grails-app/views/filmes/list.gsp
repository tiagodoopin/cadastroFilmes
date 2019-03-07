%{--
<%@ page import="filmes.Filmes" %>--}%
<!doctype html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Lista de filmes</title>
</head>

<body>
<div id="center">
	<table border="1">
		<thead>
		<tr>
			<th>Nome do filme</th>
			<th>Ano</th>
			<th>açao</th>
		</tr>
		</thead>
		<tbody>
		<g:each in="${instance}">
			<tr>
				<td>${it.nome}</td>
				<td>${it.ano}</td>
				<td>
					<g:link controller="filmes" action="delete" id="${it.id}">
						<button type="button">Deletar</button>
					</g:link>

				</td>
			</tr>
		</g:each>
		</tbody>
	</table>
	<g:link controller="filmes" action="create">
		<button type="button">Novo</button>
	</g:link>
</div>

</body>
<style>
body {
	margin: auto;
	width: 50%;
	border: 5px solid black;
	padding: 10px;
}
div#center{
	margin-left: 200px;
}
</style>
</html>