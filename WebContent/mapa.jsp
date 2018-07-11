<%@page import="com.tabela.beans.VisaoSimples"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="lente" class="com.tabela.beans.VisaoSimples"/>
<jsp:useBean id="dao" class="com.tabela.dao.Conexao"/>
<html>
    <head>
     <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <link href="./bootstrap/css/style.css" rel="stylesheet">   
    </head>
<body>   
  <% Map<Integer, Object>  matriz =   (Map<Integer, Object>)request.getAttribute("produtos"); %>
  <% List<VisaoSimples> lentes = (List<VisaoSimples>) matriz.get(1); %>
  <% String grau = (String) matriz.get(2); %>
  <% //out.println(lentes.get(0).getNomeLente());%>
  <br>
  <% //out.println(lentes.get(1).getNomeLente());%>
  <br>
  <% //out.println(lentes.get(2).getNomeLente());%>
  <br>
  <jsp:include page="barra_superior_cadastrar_lente.jspf" />   
  <jsp:include page="barra_busca_visao_simples.jspf"/> 
  <h3>Grau consultado </h3><h4><%out.print(grau); %></h4> 
  <table  class="table table-striped">
  
 
                            <thead>
                                <tr>
                                    <td>Nome</td>
                                    <td>Material</td>
                                    <td>I.Refração</td>
                                    <td>Tratamento</td>
                                    <td>Descrição</td>
                                    <td>Disponibilidade</td>
                                </tr>
                            </thead>

<%
for (VisaoSimples vs : lentes ) {
%>
<tr>
  <td><%= vs.getMarcaLente() %></td>
  <td><%= vs.getMaterial() %></td>
  <td><%= vs.getIndice() %></td>
  <td><%= vs.getTratamento() %></td>
  <td><%= vs.getDescricao() %></td>
  <td><%= vs.getChave() %></td>  
  </tr>
  <%} %>
  </table>  
 </body>
</html>