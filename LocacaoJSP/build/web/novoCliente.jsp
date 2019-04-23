<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Novo Cliente</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <jsp:useBean id="cliente" class="br.ufscar.dc.dsw.model.Cliente" />
        <h1>Novo cliente</h1>
        <form action="NovoClienteServlet" method="post">
            <fieldset>
                <legend>Digite seus dados:</legend>
                E-mail: <input name="email" type="text" value=""/><br/>
                Senha: <input name="senha" type="text" value=""/><br/>
                CPF: <input name="cpf" type="text" value=""/><br/>
                Nome: <input name="nome" type="text" /><br/>
                Telefone: <input name="telefone" type="text" value="" /><br/>
                Sexo: <input name="sexo" type="text" value=""/><br/>
                Data de nascimento: <input name="dataDeNascimento" type="date" value="" /><br/>
                <input type="submit" value="Enviar"/>
            </fieldset>
        </form>
    </body>
</html>
