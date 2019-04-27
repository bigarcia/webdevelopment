<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Locadoções</title>
		<link rel="stylesheet" type="text/css" href="estilo.css" />
	</head>
	<body>
		<h1>Locações</h1>
		<hr>
		<c:if test="${empty requestScope.listaLocacao}">
			Não há locações!
		</c:if>
		<c:if test="${!empty requestScope.listaLocacao}">
		<%! static LocadoraDAO locadoraDAO = new LocadoraDAO();
                static List<Locadora> listarLocadora = dao.getAll();
                static int i = 0;
                static int id_locacao = 0;
            %>
			<% for (i = 0; i < listaLocadora.size(); i++) { %>
            <tr>
                <td> <% out.println(listaLocadora.get(i).getId_locadora());%></td>
                <td> <% out.println(listaLocadora.get(i).getNome_locadora());%></td>
                <td> <% out.println(listaLocadora.get(i).getCnpj_locadora());%></td>
                <td> <% out.println(listaLocadora.get(i).getCidade_locadora());%></td>
                <td> <% out.println(listaLocadora.get(i).getEmail_locadora());%></td>
                <% id_locacao = listaLocadora.get(i).getId_locadora();
                        System.out.println(id_locacao);%>
                <td><a href="edicao?id=<%=id_locacao%> "><fmt:message key="editar"/></a>                        
                    &nbsp;&nbsp;&nbsp;&nbsp;                        
                    <a href="remocao?id=<%=id_locacao%>
                       "onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        <fmt:message key="remover"/>
                    </a></td>                
            </tr> 
		<table>
			<tr>
				<th>Locacao</th>
			</tr>
			<c:forEach items="${requestScope.listaLocacao}" var="locacao">
				<tr>
					<td>${locacao.cnpj_locacao}</td>
					<td>${locacao.data_locacao}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</body>
</html>