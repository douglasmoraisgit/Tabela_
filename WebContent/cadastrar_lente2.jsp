<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Lentes Visão Simples</title>

<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./bootstrap/css/style.css" rel="stylesheet">
</head>
<body> 
<div id="main" class="container-fluid">
<h3 class="page-header">Adicionar Item</h3>
  
  <form action="index.html" method="get">
  	<div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="marca">Marca</label>
  	  	<input type="text" class="form-control" id="marca">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="material">MATERIAL</label>
  	  	<input type="text" class="form-control" id="material" placeholder="Digite o valor">
  	  </div>
  	 <div class="form-group col-md-3">
  	  	<label for="cor">COR</label>
  	  	<input type="text" class="form-control" id="cor" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="tratamento">TRATAMENTO</label>
  	  	<input type="text" class="form-control" id="tratamento" placeholder="Digite o valor">
  	  </div>
  	  </div>
  	  <div class="row">
  	  <div class="form-group col-md-6">
  	  	<label for="descricao">DESCRIÇÃO</label>
  	  	<input type="text" class="form-control" id="descricaol1" placeholder="Digite o valor">
  	  </div>
  	  <div class="form-group col-md-3">
  	  	<label for="fotossensivel">FOTOSSENSIVEL</label>
  	  	<input type="text" class="form-control" id="fotossensivel" placeholder="Digite o valor">
  	  </div>
  	  <div class="form-group col-md-3">
  	  	<label for="ir">I.REFRAÇÃO</label>
  	  	<input type="text" class="form-control" id="ir" placeholder="Digite o valor">
  	  </div>
	</div>
	
	<div class="row">
	 <div class="form-group col-md-4">
  	  	<label for="dioptria">Vergencia</label>
  	  	<input type="text" class="form-control" id="dioptria" placeholder="Digite o valor">
  	  </div>
  	  <div class="form-group col-md-2">
  	  	<label for="esf_ini">ESFERICO DE</label>
  	  	<input type="text" class="form-control" id="esf_ini" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-2">
  	  	<label for="esf_fim">ESFERICO ATÉ</label>
  	  	<input type="text" class="form-control" id="esf_fim" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-2">
  	  	<label for="cil_ini">CILINDRICO DE </label>
  	  	<input type="text" class="form-control" id="cil_ini" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-2">
  	  	<label for="cil_fim">CILINDRICO ATÉ</label>
  	  	<input type="text" class="form-control" id="cil_fim" placeholder="Digite o valor">
  	  </div>
	</div>
	
	
	<hr />
	
	<div class="row">
	  <div class="col-md-12">
	  	<button type="submit" class="btn btn-primary">Salvar</button>
		<a href="index.jsp" class="btn btn-default">Cancelar</a>
	  </div>
	</div>

  </form>
 </div>
 

 <script src="./bootstrap/js/jquery.min.js"></script>
 <script src="./bootstrap/js/bootstrap.min.js"></script>
</body>
</html>