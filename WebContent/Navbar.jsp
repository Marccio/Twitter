<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="twitter.model.Usuario"%>
<%@ page import="twitter.service.UsuarioService"%>
<%@ page import="java.util.ArrayList"%>

<head>
<meta charset="ISO-8859-1">
<title>Twistter</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="index.css">

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark sticky-top" id="navBar"
		style="background-color: #1DA1F2;">
		<div class="container-fluid">
			<a class="navbar-brand" href="login.jsp"><h1>Twistter</h1></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<%
				Usuario user = (Usuario) session.getAttribute("usuario");
				//System.out.print(usuario.getEmail());
				if (user == null) {
			%>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item active" Style="text-aliggn: left;"><a
						class="nav-link">Logado como ${user.nome} </a></li>
					<li class="nav-item active"><a class="nav-link" href="#"
						data-toggle="modal" data-target="#modalSeguidores">Seguidores
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="login.jsp">Sair</a></li>

				</ul>
			</div>
			<%
				}
			%>
		</div>
	</nav>
	<div class="modal fade" id="modalSeguidores">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="logo mb-3">Seguidores</h1>
					<button type="button" class="close" data-dismiss="modal">
						<span> &times; </span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container-center">
						<div class="row">
							<div class="center" id="first">
								<div class="table-responsive-sm mt-5 center">
									<table class="table">
										<thead>
											<tr>
												<th scope="col">Nick</th>
											</tr>
										</thead>
										<tbody>
											<%	
						try {
						UsuarioService userService = new UsuarioService();
						
						ArrayList<Usuario> listaUsuario = userService.listarMeusSeguidores(user.getNickname());
	
						for (Usuario usuario : listaUsuario) {
					%>

											<tr>
												<th scope="row"><%=usuario.getId()%></th>
												<td><%=usuario.getNickname()%></td>

											</tr>
						<% } 
						} catch(Exception e){
							
						}%>
										</tbody>
					
									</table>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
