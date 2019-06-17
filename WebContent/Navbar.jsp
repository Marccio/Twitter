<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="twitter.model.Usuario"%>

<head>
<meta charset="ISO-8859-1">
<title>Twistter</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="index.css">

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark sticky-top" id="navBar" style="background-color: #1DA1F2;">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><h1>Twistter</h1></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<%
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				if (usuario == null) {
			%>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="login.html">Login</a></li>
					<li class="nav-item active"><a class="nav-link" href="register.html">Cadastre-se</a></li>
				</ul>
</div>
			<%
				} else {
			%>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item active" Style="text-aliggn:left;"><a class="nav-link">Logado como ${usuario.nome}     </a></li>
					<li class="nav-item active"  ><a class="nav-link" href="#">Seguidores </a></li>
					<li class="nav-item active"  ><a class="nav-link" href="#">Seguindo </a></li>
					<form class="form-inline">
				    <div class="input-group">
				      <div class="input-group-prepend"><!-- Fazer uma query para buscar a pessoa e se ela existir no banco seguir ela -->
				        <span class="input-group-text" id="basic-addon1">@</span>
				      </div>
				      <input type="text" class="form-control" placeholder="Usuário" aria-label="Usuário" aria-describedby="basic-addon1">
						<a class="btn btn-light" href="#" role="button">Seguir</a>
				    </div>
				  </form>
					<li class="nav-item active"><a class="nav-link" href="logout.do">Sair</a></li>

				</ul>
			</div>

			<%
				}
			%>
		</div>
	</nav>
	
</body>
