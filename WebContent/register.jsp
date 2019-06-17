<%@ include file="Navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="register.css">

<meta charset="ISO-8859-1">
<title>Twistter Register</title>
</head>
<body>
<div class="container register-container">
            <form class="form-horizontal" role="form" action="CadastrarUsuario.do" method="POST" >
                <h3>Cadastro</h3>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Nome</label>
                    <div class="col-sm-9">
                        <input type="text" id="nome" placeholder="Nome completo" class="form-control" autofocus name="nome">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Telefone </label>
                    <div class="col-sm-9">
                        <input type="text" id="telefone" placeholder="Telefone" class="form-control" name="telefone">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-3 control-label">NickName</label>
                    <div class="col-sm-9">
                        <input type="text" id="nickname" placeholder="NickName" class="form-control" autofocus name="nickname">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Email </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Senha</label>
                    <div class="col-sm-9">
                        <input type="password" id="senha" placeholder="Senha" class="form-control" name="senha">
                    </div>
				</div>
                <button type="submit" class="btnSubmit">Cadastro</button>
                <div class="form-group">
							<a>Já tem uma conta no Twistter?</a>
                            <a href="login.jsp" class="entrar">Acesse agora »</a>
                        </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>