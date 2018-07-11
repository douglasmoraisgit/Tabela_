<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.tabela.dao.Produtodao" %>
<%@ page import="com.tabela.beans.Produto" %>
<jsp:useBean id="produto" class="com.tabela.beans.Produto"/>
<jsp:useBean id="dao" class="com.tabela.dao.Produtodao"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css" /> 
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" /> 
<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table>
<!-- percorre contatos montando as linhas da tabela -->
<c:forEach var="produtos" items="${dao.lista}">
<tr>
<td>${produtos.nomeProduto}</td>
</tr>
</c:forEach>
</table>

</body>
</html>