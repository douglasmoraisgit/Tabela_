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
        
    <jsp:include page="barra_superior_cadastrar_lente.jspf" />   
   <jsp:include page="barra_busca_visao_simples.jspf"/>    
    
  <!--   <div id="main" class="container-fluid"> -->
 
  
  <h3 class="page-header">Lentes Visão Simples</h3>
        <div class="container">
          
            <div class="col-md-9">                
              
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>Descrição</td>
                                    <td>Material</td>
                                    <td>I.Refração</td>
                                    <td>Tratamento</td>
                                    <td>Disponibilidade</td>
                                    
                                </tr>
                            </thead>
                            <c:forEach var="lente" items="${requestScope.produtos}">
                                                                                
                                    <tr>                                
                                    <td>${lente.descricao}</td>
                                    <td>${lente.material}</td>
                                    <td>${lente.indice}</td>
                                    <td>${lente.tratamento}</td>
                                    <td>${lente.chave}</td>
                                    
                                    </tr>
                            </c:forEach>               
                        </table>  
            </div>       
           </div>
        </div>
    </body>
</html>