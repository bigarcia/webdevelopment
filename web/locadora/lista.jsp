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
            <a href="cadastro">Adicione Nova Locadora</a>
            &nbsp;&nbsp;&nbsp;

        </h2>
    </center>
    <form name='form'>
        <table>
            <tr>
                <td>Selecione uma cidade</td>
                <td>
                    <select id = 'cidade_locadora' name='cidade_locadora' onchange='cidadeSelecionada(this.value)'>
                        <option value='--'>--</option>
                        <c:forEach items='${listaLocadoras}' var='locadora'>                               
                            <option value='${locadora.cidade_locadora}'>${locadora.cidade_locadora}</option>                                
                        </c:forEach>                               
                    </select>   
                </td>
            </tr>
        </table>
        
    </form>
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Locadoras</h2></caption>
        <tr>
            <th>ID</th>
            <th>CNPJ</th>
            <th>Nome</th>
            <th>Cidade</th>

        </tr>
        <c:forEach var="locadora" items="${listaLocadoras}">
            <tr>
                <td><c:out value="${locadora.id_locadora}" /></td>
                <td><c:out value="${locadora.cnpj_locadora}" /></td>
                <td><c:out value="${locadora.nome_locadora}" /></td>
                <td><c:out value="${locadora.cidade_locadora}" /></td>
                <td><a href="edicao?id_locadora=<c:out value='${locadora.id_locadora}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id_locadora=<c:out value='${locadora.id_locadora}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>