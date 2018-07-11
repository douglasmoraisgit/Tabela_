<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.grupo{
        height:auto;
        border:solid 1px;      
    
</style>
</head>
<body>

     <form action="CheckBoxAux" method="get">
     <div class="grupo">
     Características:<br>
        <input type="text" id="grau" name="grau" ><br>
        <input type="checkbox" name="cor" value="Transistions">Transistions<br>
        <input type="checkbox" name="cor" value="Acclimates">Acclimates<br>
        <input type="checkbox" name="cor" value="Incolor">Incolor<br>
        <input type="checkbox" name="tratamento" value="Anti-Reflexo">Anti-Reflexo<br>
         <input type="checkbox" name="tratamento" value="Easy Clean">Easy Clean<br>
         <input type="checkbox" name="tratamento" value="Crizal">Crizal<br>
         <input type="checkbox" name="tratamento" value="Crizal Alize">Crizal Alize<br>
        <input type="checkbox" name="indice" value="1.49">I.Refração 1.49<br>
         <input type="checkbox" name="indice" value="1.56">I.Refração 1.56<br>
         <input type="checkbox" name="indice" value="1.59">I.Refração 1.59<br>
         <input type="checkbox" name="indice" value="1.61">I.Refração 1.61<br>
         <input type="checkbox" name="material" value="cr39">Acrilico<br>
         <input type="checkbox" name="material" value="policarbonato">Policarbonato<br>
         <input type="checkbox" name="material" value="stylis">Stylis<br>
          <input type="checkbox" name="material" value="trivex">Trivex<br>
        <input type="submit" value="Submit">
        </div>
     </form>



</body>
</html>