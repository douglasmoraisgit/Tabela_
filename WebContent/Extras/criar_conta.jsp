<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
 
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css" /> 
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" /> 
<script src="./bootstrap/js/bootstrap.min.js"></script>
 
</head>
<body>
    <jsp:include page="barra_superior_criar_conta.jspf" />
 
    <div class="container" style="padding-top: 80px;">
        <div class="row">
            <div class="container">
                <div class="col-md-8">
                    <h1>Crie sua conta do MyImage.com!</h1>
                    <p>Criando sua conta no MyImage.com você poderá compartilhar
                        suas imagens o mundo.</p>
                    <br />
                    <form class="form-horizontal" method="post"
                        action="UsuarioController?action=criar_conta" role="form">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name ="email" id="email"
                                    placeholder="Digite aqui seu email" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nome" class="col-sm-3 control-label">Nome</label>
                            <div class="col-sm-8">
                                <input type="text" name ="nome" class="form-control" id="nome"
                                    placeholder="Digite aqui seu usuário" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="senha" class="col-sm-3 control-label">Senha</label>
                            <div class="col-sm-6">
                                <input type="password" name ="senha" id="senha" class="form-control"
                                    placeholder="Digite aqui sua senha" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="senha2" class="col-sm-3 control-label">Confirma
                                senha</label>
                            <div class="col-sm-6">
                                <input type="password" id="senha2" class="form-control"
                                    placeholder="Confirme aqui sua senha" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-default">Criar
                                    conta</button>
                            </div>
                        </div>
 
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>