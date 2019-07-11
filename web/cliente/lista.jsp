<%-- 
    Document   : lista
    Created on : 03-May-2019, 02:08:02
    Author     : Bianca
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Locação</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Locacoes</h1>
        <h2>
            <a href="cadastro">Adicione Novo Cliente</a>
            &nbsp;&nbsp;&nbsp;
           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Clientes</h2></caption>
            <tr>
                <th>ID</th>
                <th>CPF</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Sexo</th>
                <th>Data de nascimento</th>
            </tr>
            <c:forEach var="cliente" items="${listaClientes}">
                <tr>
                    <td><c:out value="${cliente.id_cliente}" /></td>
                    <td><c:out value="${cliente.cpf_cliente}" /></td>
                    <td><c:out value="${cliente.nome_cliente}" /></td>
                    <td><c:out value="${cliente.telefone_cliente}" /></td>
                    <td><c:out value="${cliente.sexo_cliente}" /></td>
                    <td><c:out value="${cliente.nascimento_cliente}" /></td>
                    <td><a href="edicao?id_cliente=<c:out value='${cliente.id_cliente}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?id_cliente=<c:out value='${cliente.id_cliente}' />"
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>