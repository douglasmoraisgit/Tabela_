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
    <jsp:include page="barra_busca_multifocal.jspf"/>  
 <div id="main" class="container-fluid">
  
  <h3 class="page-header">Lentes Multifocais</h3>
       <!--   <div class="container"> -->
                          
              
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>Descrição</td>
                                    <td>Fornecedor</td>
                                    <td>Preço</td>
                                                                        
                                </tr>
                            </thead>
                            <c:forEach var="tabela" items="${requestScope.produtos}">
                                                                                   
                                    <tr>                                
                                    <td>${tabela.descricao}</td>
                                    <td>${tabela.nomeFornecedor}</td>
                                    <td>${tabela.valorMult}</td>
                                   
                                    
                                    </tr>
                            </c:forEach>               
                        </table>  
                   
           
        </div>
    </body>
</html>