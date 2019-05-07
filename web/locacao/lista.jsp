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

        <script src="js/ajax.js"></script>


    </head>
    <body>
    <center>
        <h1>Gerenciamento de Locacoes</h1>
        <h2>
            <a href="cadastro">Adicione Nova Locacao</a>
            &nbsp;&nbsp;&nbsp;

        </h2>
    </center>
    
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Locacoes</h2></caption>
        <tr>
            <th>ID</th>
            <th>CPF</th>
            <th>CNPJ</th>
            <th>Nome locacao</th>
            <th>Dia Locacao</th>
            <th>Hora Locacao</th>

        </tr>
        <c:forEach var="locacao" items="${listaLocacao}">
            <tr>
                <td><c:out value="${locacao.id_locacao}" /></td>
                <td><c:out value="${locacao.cpf_cliente}" /></td>
                <td><c:out value="${locacao.cnpj_locadora}" /></td> 
                <td><c:out value="${locacao.dia_locacao}" /></td>
                <td><c:out value="${locacao.hora_locacao}" /></td>
                    <a href="remocao?id_locacao=<c:out value='${locacao.id_locacao}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>