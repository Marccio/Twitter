<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Navbar.jsp" %>
<%@ page import="twitter.model.Postagem" %>
<%@ page import="twitter.dao.PostagemDao" %>
<%@ page import="twitter.service.PostagemService" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<meta charset="ISO-8859-1">
<title>Twistter</title>
</head>
<body>
	<%
		PostagemService pService = new PostagemService();
		ArrayList<Integer> lista = pService.listarIds();
	%>
<div class="span8">
	<% int id = (int) lista.get(1);
	Postagem postagem = pService.consultar(id);
	%>
	
    <p><%=postagem.getTexto() %></p>
    <div>
        <span class="badge badge-success"></span><div class="pull-right"><span class="label"><%=postagem.getUsuario() %></span></div>
    </div> 
    <hr>
    
</div>
</body>
</html>

