<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Locação</title>
    </head>
    <body>
    <center>
        <h1>Locadora</h1>
        <h2>
           
            <a href="lista">Lista de Locadoras</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${locadora != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${locadora == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${locadora != null}">
                                Edição
                            </c:if>
                            <c:if test="${locadora == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${locadora != null}">
                        <input type="hidden" name="id_locadora" value="<c:out value='${locadora.id_locadora}' />" />
                    </c:if>
                    <tr>
                        <th>CNPJ: </th>
                        <td>
                            <input type="text" name="cnpj_locadora" size="45"
                                   value="<c:out value='${locadora.cnpj_locadora}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome_locadora" size="45"
                                   value="<c:out value='${locadora.nome_locadora}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade: </th>
                        <td>
                            <input type="text" name="cidade_locadora" size="5"
                                   value="<c:out value='${locadora.cidade_locadora}' />"/>
                        </td>
                    </tr>
          

                    <tr>                        
                        <th>Email </th>                    
                        <td>                            
                            <input type="email" name="email_usuario"                                   
                                   value="<c:out value='${locadora.email_usuario}' />"                                   
                                   />                        
                        </td>                    
                    </tr>
                    <tr>                        
                        <th>Senha</th>                    
                        <td>                            
                            <input type="password" name="senha_usuario"                                   
                                   value="<c:out value='${locadora.senha_usuario}' />"                                   
                                   />                        
                        </td>                    
                    </tr> 
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="salva" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
</body>
</html>