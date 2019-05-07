<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Locação</title>
    </head>
    <body>
    <center>
        <h1>Locação</h1>
        <h2>

            <a href="lista">Lista de Locações</a>
        </h2>
    </center>
    <div align="center">


        <form action="insercao" method="post">

            <table border="1" cellpadding="5">
                <caption>
                    <h2>

                        Cadastro

                    </h2>
                </caption>
                <c:if test="${locacao != null}">
                    <input type="hidden" name="id_locacao" value="<c:out value='${locacao.id_locacao}' />" />
                </c:if>

                <tr>
                    <th>Locadora: </th>
                    <th>Selecione uma das locadoras:</th>
                    <td>
                        <select id = 'nome_locadora' name='nome_locadora'>
                            <option value='--'>--</option>
                            <c:forEach items='${listaLocadoras}' var='locadora'>                               
                                <option value='${locadora.nome_locadora}'>${locadora.nome_locadora}</option>                                
                            </c:forEach>                               
                        </select>   
                    </td>
                    <th> OU </th>
                    <th>Digite o CNPJ:</th>
                    <td>
                        <input type="text" name="cnpj_locadora" value="<c:out value='${locacao.cnpj_locadora}' />" />
                    </td>

                </tr>


                <tr>
                    <th>Data: </th>
                    <td>
                        <input type="date" name="data_locacao" size="5"
                               value="<c:out value='${locacao.data_locacao}' />"/>
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