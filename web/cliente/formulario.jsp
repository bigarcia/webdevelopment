<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Locação</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Clientes</h1>
        <h2>
            <a href="cadastra">Adicione Novo Cliente</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista">Lista de Clientes</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${cliente != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${cliente == null}">
            <form action="insercao" method="post">
            </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${cliente != null}">
                                Edição
                            </c:if>
                            <c:if test="${cliente == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${cliente != null}">
                        <input type="hidden" name="id_cliente" value="<c:out value='${cliente.id_cliente}' />" />
                    </c:if>
                    <tr>
                        <th>CPF: </th>
                        <td>
                            <input type="text" name="cpf_cliente" size="45"
                                   value="<c:out value='${cliente.cpf_cliente}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome_cliente" size="45"
                                   value="<c:out value='${cliente.nome_cliente}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Telefone: </th>
                        <td>
                            <input type="text" name="telefone_cliente" size="5"
                                   value="<c:out value='${cliente.telefone_cliente}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Sexo: </th>
                        <td>
                            <input type="text" name="sexo_cliente" size="5"
                                   value="<c:out value='${cliente.sexo_cliente}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Data de nascimento: </th>
                        <td>
                            <input type="text" name="nascimento_cliente" size="5"
                                   value="<c:out value='${cliente.nascimento_cliente}' />"
                                   />
                        </td>
                    </tr>

                    <tr>                        
                        <th>Email </th>                    
                        <td>                            
                            <input type="email" name="email_usuario"                                   
                                   value="<c:out value='${cliente.email_usuario}' />"                                   
                                   />                        
                        </td>                    
                    </tr>
                    <tr>                        
                        <th>Senha</th>                    
                    <td>                            
                        <input type="password" name="senha_usuario"                                   
                               value="<c:out value='${cliente.senha_usuario}' />"                                   
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