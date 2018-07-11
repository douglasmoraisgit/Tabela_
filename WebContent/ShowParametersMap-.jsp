<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShowParametersMap</title>
<link rel="stylesheet" href="./CSS/mycss.css">
 <!-- <script src="./JS/js.js"></script> -->
</head>
<body>
<div class="container">
<div class="grupo_1">
<div class="receita">
<form action="FormularioAjaxParametros" method="get">
<fieldset style="margin-bottom: 15px;width: 340px;height: 72px" ><legend>Olho Direito</legend>
<div style="float: left;">
	<p style="display: block; margin-right: 10px">Esférico   :</p><input id="odesf" name="odesf" onblur="insertcode();"style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Cilíndrico :</p><input id="odcil" name="odcil" onblur="insertcode();"style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10" >
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 15px">Adição :</p><input style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
</fieldset>
<fieldset style="margin-bottom: 10px;width: 340px; height: 72px;"><legend>Olho Esquerdo</legend>
	<div style="float: left;">
	<p style="display: block; margin-right: 10px">Esférico   :</p><input id="oeesf" name="oeesf" onblur="insertcode();"style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Cilíndrico :</p><input id="oecil" name="oecil" onblur="insertcode();"style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10" >
</div>
<div style="float: left;">
	<p style="display:block; margin-right: 10px">Adição :</p><input style="margin-right: 10px; text-align: right;" type="text" size="10" maxlength="10">
</div>
</fieldset>
<fieldset style="width: 340px;height: 65px;">
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
</div>
<div class="opcoes">
<div class="checkboxes">
 <fieldset style="width: 150px; height:135px;float: left;margin-right: 8px;">
 <legend>Material</legend>
 <div class="material">
    <label for="acrilico"><input type="checkbox"      name="material"  value="acrilico"      id="acrilico" /> <span>Acrílico</span></label>
    <label for="policarbonato"><input type="checkbox" name="material"  value="policarbonato" id="policarbonato" /> <span>Policarbonato</span></label>
    <label for="trivex"><input type="checkbox"        name="material"  value="trivex"        id="trivex" /> <span>Trivex</span></label>
    <label for="cristal"><input type="checkbox"       name="material"  value="cristal"       id="cristal" /> <span>Cristal</span></label>
    <label for="highlite"><input type="checkbox"      name="material"  value="highlite"      id="highlite" /> <span>High-Lite</span></label>
 </div>
 </fieldset>
 <fieldset style="width: 150px;height:135px;float:  left;margin-left:  8px;">
 <legend>Tratamento</legend>
  <div class="tratamento"> 
    <label for="comum"><input type="checkbox"         name="tratamento"  value="comum"  id="comum" /> <span>Sem Tratamento</span></label>
    <label for="antireflexo"><input type="checkbox"   name="tratamento"  value="antireflexo"  id="antireflexo" /> <span>Anti-Reflexo</span></label>
    <label for="colorido"><input type="checkbox"      name="tratamento"  value="colorido" id="colorido" /> <span>Colorido</span></label>
    <label for="fotossensivel"><input type="checkbox" name="tratamento"  value="fotossensivel" id="fotossensivel" /> <span>Fotossensível</span></label>
   </div>
  </fieldset>
  <input type="submit">
  </form>
  </div>
  </div>
  </div>
<div class="grupo_2">
<table style="width: 300px; font-size: 12px">
<thead><tr><th colspan="5">Tabela de preÃ§os</th></tr></thead>
<tfoot><tr><td colspan="5"></td></tr></tfoot>
<tbody>
<tr>
<td rowspan="8" align="center">Essilor</td>
<td rowspan="2">CRIZAL EASY</td>
<td>AcrÃ­lico</td>
<td>Airwear</td>
<td>Transistions</td>
</tr>
<tr>
<td>$500</td>
<td>$640</td>
<td>$650</td>
</tr>
<tr>
       <td rowspan="2">CRIZAL ALIZE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
       <tr>
         <td rowspan="2">CRIZAL FORTE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
</tbody>
<tbody>
<tr>
<td rowspan="8">Hoya</td>
<td rowspan="2">CRIZAL EASY</td>
<td>AcrÃ­lico</td>
<td>Airwear</td>
<td>Transistions</td>
</tr>
<tr>
<td>$500</td>
<td>$640</td>
<td>$650</td>
</tr>
<tr>
       <td rowspan="2">CRIZAL ALIZE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
       <tr>
         <td rowspan="2">CRIZAL FORTE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
</tbody>
<tbody>
<tr>
<td rowspan="8">Essilor</td>
<td rowspan="2">CRIZAL EASY</td>
<td>AcrÃ­lico</td>
<td>Airwear</td>
<td>Transistions</td>
</tr>
<tr>
<td>$500</td>
<td>$640</td>
<td>$650</td>
</tr>
<tr>
       <td rowspan="2">CRIZAL ALIZE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
       <tr>
         <td rowspan="2">CRIZAL FORTE</td>
           <td>AcrÃ­lico</td>
           <td>Airwear</td>
           <td>Transistions</td>
        </tr>
        <tr>
           <td>$500</td>
           <td>$640</td>
           <td>$650</td>
       </tr>
</tbody>
</table>
</div>
</div>



 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 <!--    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>-->
</body>
</html>