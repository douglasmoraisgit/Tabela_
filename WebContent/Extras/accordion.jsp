<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#accordion" ).accordion({
    	  active: 0
    });
  });
 
  </script>
</head>
<body>
<input type="text" name="grau"><br>
<div id="accordion">
  <h2>Anti-Reflexo</h2>
  <div>
     <input type="checkbox" name="ar" value="Anti-Reflexo">Anti-Reflexo<br>
            <input type="checkbox" name="ar" value="Crizal">Crizal<br>
            <input type="checkbox" name="ar" value="Crizal Alize">Crizal Alize<br>
  </div>
  <h3>Cor</h3>
  <div>
    <input type="checkbox" name="cor" value="Transistions">Transistions<br>
            <input type="checkbox" name="cor" value="Incolor">Incolor<br>
  </div>
  <h3>Material</h3>
  <div>
    <input type="checkbox" name="material" value="acrilico">Acrilico<br>
            <input type="checkbox" name="material" value="policarbonato">Policarbonato<br>
            <input type="checkbox" name="material" value="stylis">Stylis<br>
            <input type="checkbox" name="material" value="trivex">Trivex<br>
  </div>
  <h3>Indice Refração</h3>
  <div>
   <input type="checkbox" name="material" value="acrilico">Acrilico<br>
            <input type="checkbox" name="material" value="policarbonato">Policarbonato<br>
            <input type="checkbox" name="material" value="stylis">Stylis<br>
            <input type="checkbox" name="material" value="trivex">Trivex<br>
   
  </div>
  
</div>
 
 
</body>
</html>