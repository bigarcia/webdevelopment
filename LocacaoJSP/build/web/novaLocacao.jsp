<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Nova Locadora</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <jsp:useBean id="cliente" class="br.ufscar.dc.dsw.model.Locadora" />
        <h1>Nova Locadora</h1>
        <form action="NovoClienteServlet" method="post">
            <fieldset>
                <legend>Digite seus dados:</legend>
                <!--E-mail: <input name="email" type="text" value=""/><br/>
                Senha: <input name="senha" type="text" value=""/><br/>-->
                CNPJ: <input name="cnpj_locacao" type="text" value=""/><br/>
                Data da Locacao: <input name="data_locacao" type="text" value=""/><br/>
                <input type="submit" value="Gravar"/>
            </fieldset>
        </form>
    </body>
</html>
