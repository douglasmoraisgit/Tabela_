<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/mycss.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
<script src="./JS/AjaxParametersMap.js"></script>
</head>
<body>
<div class="container">
<div class="grupo_1">
<div class="receita">
<form id="myAjaxRequestForm">
<fieldset  style="margin-bottom: 15px;width: 330px;height: 65px;">
<legend>Tipo de Lente</legend>
<div class="tipo_lente">
<div style="width:105px;float: left; margin: auto;">
<label for="visaosimples"><input type="checkbox" id="visaosimples" /> <span>Visao Simples</span></label>
</div>
<div style="width: 105px;float: left;margin:auto;text-align: center;">
<label for="bifocal"><input type="checkbox" id="bifocal" /> <span>Bifocal</span></label>
</div>
<div style="width: 105px;float: left;">
<label for="multifocal"><input type="checkbox" id="multifocal" /> <span>Multifocal</span></label>
</div>
</div>
</fieldset>
<fieldset style="margin-bottom: 15px;width: 330px;height: 72px" ><legend>Olho Direito</legend>
<div style="float: left;">
	<p style="display: block; margin-right: 10px">Esférico   :</p><input id="odesf" name="odesf" style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Cilíndrico :</p><input id="odcil" name="odcil" style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10" >
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 15px">Adição :</p><input style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
</fieldset>
<fieldset style="margin-bottom: 10px;width: 330px; height: 72px;"><legend>Olho Esquerdo</legend>
	<div style="float: left;">
	<p style="display: block; margin-right: 10px">Esférico   :</p><input id="oeesf" name="oeesf" style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Cilíndrico :</p><input id="oecil" name="oecil" style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10" >
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Adição :</p><input style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
</fieldset>
<div style="float: right;margin-top: 8px;margin-right: 10px;">
    <input type="reset" value="Limpar">
    </div>
</div>

  </div>
  <div class="grupo_2">
  <div class="opcoes">
<div class="checkboxes">
 <fieldset style="width: 150px; height:120px;float: left;margin-right: 8px;">
 <legend>Material</legend>
 <div class="material">
    <label for="acrilico"><input type="checkbox"      name="material"  value="acrilico"      id="acrilico" /> <span>Acrílico</span></label>
    <label for="policarbonato"><input type="checkbox" name="material"  value="policarbonato" id="policarbonato" /> <span>Policarbonato</span></label>
    <label for="trivex"><input type="checkbox"        name="material"  value="trivex"        id="trivex" /> <span>Trivex</span></label>
    <label for="cristal"><input type="checkbox"       name="material"  value="cristal"       id="cristal" /> <span>Cristal</span></label>
    <label for="highlite"><input type="checkbox"      name="material"  value="highlite"      id="highlite" /> <span>High-Lite</span></label>
 </div>
 </fieldset>
 <fieldset style="width: 150px;height:120px;float:  left;margin-left:  2px;">
 <legend>Tratamento</legend>
  <div class="tratamento"> 
    <label for="comum"><input type="checkbox"         name="tratamento"  value="comum"  id="comum" /> <span>Sem Tratamento</span></label>
    <label for="antireflexo"><input type="checkbox"   name="tratamento"  value="antireflexo"  id="antireflexo" /> <span>Anti-Reflexo</span></label>
    <label for="colorido"><input type="checkbox"      name="tratamento"  value="colorido" id="colorido" /> <span>Colorido</span></label>
    <!--  <label for="fotossensivel"><input type="checkbox" name="tratamento"  value="fotossensivel" id="fotossensivel" /> <span>Fotossensível</span></label>-->
   </div>
  </fieldset>
  
  <fieldset style="width: 150px;height:135px;float:left;margin-left:0px;margin-top: 8px">
 <legend>Fotossensível</legend>
  <div class="fotossensivel"> 
    <label for="nao"><input type="checkbox"            name="fotossensivel" value="nao"           id="nao" /> <span>Não</span></label>
    <label for="transistions"><input type="checkbox"   name="fotossensivel" value="transistions"  id="transistions" /> <span>Transistions</span></label>
    <label for="aclimates"><input type="checkbox"      name="fotossensivel" value="aclimates"     id="aclimates" /> <span>Acclimates</span></label>
    <label for="generico"><input type="checkbox"       name="fotossensivel" value="fotossensivel" id="fotossensivel" /> <span>Genérico</span></label>
   </div>
  </fieldset>
  <fieldset style="width: 150px;height:135px;float:left;margin-left:8px;margin-top: 8px">
 <legend>Índice Refração</legend>
  <div class="indice"> 
   <div style="display: block; width: 50px; float:left;">
    <label for="1.49"><input type="checkbox" name="ir"  value="1.49" id="1.49" /> <span>1.49</span></label>
    <label for="1.53"><input type="checkbox" name="ir"  value="1.53" id="1.53" /> <span>1.53</span></label>
    <label for="1.56"><input type="checkbox" name="ir"  value="1.56" id="1.56" /> <span>1.56</span></label>
    <label for="1.59"><input type="checkbox" name="ir"  value="1.59" id="1.59" /> <span>1.59</span></label>
    <label for="1.61"><input type="checkbox" name="ir"  value="1.61" id="1.61" /> <span>1.61</span></label>
    </div>
    <div style="display: block; width: 50px; float: left;">
    <label for="1.67"><input type="checkbox" name="ir"  value="1.67" id="1.67" /> <span>1.67</span></label>
    <label for="1.70"><input type="checkbox" name="ir"  value="1.70" id="1.70" /> <span>1.70</span></label> 
    <label for="1.74"><input type="checkbox" name="ir"  value="1.74" id="1.74" /> <span>1.74</span></label>
    <label for="1.80"><input type="checkbox" name="ir"  value="1.80" id="1.80" /> <span>1.80</span></label>
    <label for="1.90"><input type="checkbox" name="ir"  value="1.90" id="1.90" /> <span>1.90</span></label>
    </div>
   </div>
  </fieldset>
  </div>
  <div style="float: right;margin-top: 8px;margin-right: 10px;">
    <input type="submit" value="Consultar">
    </div>
   </form>
  </div>
  </div>
  <div class="grupo_3">
  
  <table id="tabela" border="1" width="773px;">
		    <thead>
		        <tr>
		            <th>Produto</th>
		            <th>Material</th>
		            <th>Cor</th>
		            <th>Tratamento</th>
		            <th>Fotossensível</th>
		            <th>Indice Refração</th>
		            <th>Valor</th>
       		    </tr>
		    </thead>
		    <tbody id="tabela">
		    </tbody>
		</table>
		</div>
  </div>
  
   </body>
</html>