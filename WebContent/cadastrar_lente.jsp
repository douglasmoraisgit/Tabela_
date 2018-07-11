<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Tabela de Preços</title>

 <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="./bootstrap/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="barra_superior_cadastrar_lente.jspf" />
 
 <div id="main" class="container-fluid">
  
  <h3 class="page-header">Adicionar Item</h3>
  
  <form action="index.html">
  	<div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">NOME</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">MATERIAL</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
  	 <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">COR</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">TRATAMENTO</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
  	  </div>
  	  <div class="row">
  	  <div class="form-group col-md-6">
  	  	<label for="exampleInputEmail1">DESCRIÇÃO</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	</div>
	
	<div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">ESFERICO DE</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">ESFERICO ATÉ</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">CILINDRICO DE </label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">CILINDRICO ATÉ</label>
  	  	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
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