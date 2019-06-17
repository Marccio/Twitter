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
		for(int i=1; i<lista.size();i++){
	%>
<div>
	<%
	int id = (int) lista.get(i);
	Postagem postagem = pService.consultar(id);
	%>
	
    <p><%=postagem.getTexto() %></p>
    <div>
        <span class="badge badge-success"><%=postagem.getDataEhora() %></span><div class="pull-right"><span class="label"><%=postagem.getUsuario().getNickname()%></span></div>
    </div> 
    <br>
    <%} %>
</div>
</body>
</html>

<div class="container">
<div class="col-md-12">
    <h1>Alice in Wonderland, part dos</h1>
    <p>'You ought to be ashamed of yourself for asking such a simple question,' added the Gryphon; and then they both sat silent and looked at poor Alice, who felt ready to sink into the earth. At last the Gryphon said to the Mock Turtle, 'Drive on, old fellow! Don't be all day about it!' and he went on in these words:
    'Yes, we went to school in the sea, though you mayn't believe it—'
    'I never said I didn't!' interrupted Alice.
    'You did,' said the Mock Turtle.</p>
    <div>
<span class="badge">Posted 2012-08-02 20:47:04</span><div class="pull-right"><span class="label label-default">alice</span> <span class="label label-primary">story</span> <span class="label label-success">blog</span> <span class="label label-info">personal</span> <span class="label label-warning">Warning</span>
<span class="label label-danger">Danger</span></div>         
     </div>
    <hr>
    <h1>Revolution has begun!</h1>
    <p>'I am bound to Tahiti for more men.'
        'Very good. Let me board you a moment—I come in peace.' With that he leaped from the canoe, swam to the boat; and climbing the gunwale, stood face to face with the captain.
        'Cross your arms, sir; throw back your head. Now, repeat after me. As soon as Steelkilt leaves me, I swear to beach this boat on yonder island, and remain there six days. If I do not, may lightning strike me!'A pretty scholar,' laughed the Lakeman. 'Adios, Senor!' and leaping into the sea, he swam back to his comrades.</p>
    <div>
        <span class="badge">Posted 2012-08-02 20:47:04</span><div class="pull-right"><span class="label label-default">alice</span> <span class="label label-primary">story</span> <span class="label label-success">blog</span> <span class="label label-info">personal</span> <span class="label label-warning">Warning</span>
<span class="label label-danger">Danger</span></div>
    </div>     
    <hr>
</div>
</div>