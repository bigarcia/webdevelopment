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
                E-mail: <input name="email_cliente" type="text" value=""/><br/>
                Senha: <input name="senha_cliente" type="text" value=""/><br/>
                CPF: <input name="cpf_cliente" type="text" value=""/><br/>
                Nome: <input name="nome_cliente" type="text" /><br/>
                Telefone: <input name="telefone_cliente" type="text" value="" /><br/>
                Sexo: <input name="sexo_cliente" type="text" value=""/><br/>
                Data de nascimento: <input name="dataDeNascimento_cliente" type="date" value="" /><br/>
                <input type="submit" value="Enviar"/>
            </fieldset>
        </form>
    </body>
</html>
