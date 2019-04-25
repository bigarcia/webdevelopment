package br.ufscar.dc.dsw.controller;
import br.ufscar.dc.dsw.model.Cliente;
import br.ufscar.br.dsw.dao.ClienteDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class ClienteController extends HttpServlet {
private ClienteDAO dao;

@Override
public void init() {
dao = new ClienteDAO();
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException {
doGet(request, response);
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException {
String action = request.getServletPath();
try {
switch (action) {

case "/cadastro_clientes":
apresentaFormCadastro(request, response);
break;

case "/insercao":
insere(request, response);
break;

case "/remocao":
remove(request, response);
break;

case "/edicao":
apresentaFormEdicao(request, response);
break;


case "/atualizacao":
atualize(request, response);
break;


default:
lista(request, response);
break;
}

} catch (RuntimeException | IOException | ServletException e) {
throw new ServletException(e);
}
}

private void lista(HttpServletRequest request, HttpServletResponse response) //listar todas as locacoes
throws ServletException, IOException {
List<Cliente> listarCliente = dao.getAll();
request.setAttribute("listaCliente", listarCliente);
RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/lista.jsp");
dispatcher.forward(request, response);
}

private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/formulario.jsp"); //formulario do cliente
dispatcher.forward(request, response);
}

private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")); //id = cpf?
Cliente cliente = dao.get(id);
RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/formulario.jsp");
request.setAttribute("cliente", cliente);
dispatcher.forward(request, response);
}

private void insere(HttpServletRequest request, HttpServletResponse response)throws IOException, SQLException{
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
String senha = request.getParameter("senha"); 
String cpf = request.getParameter("cpf");
String nome = request.getParameter("nome");
String telefone = request.getParameter("telefone");
String sexo = request.getParameter("sexo");
String data = request.getParameter("data");

Cliente cliente = new Cliente(email, senha, cpf, nome, telefone, sexo, data); 
dao.gravarCliente(cliente);
response.sendRedirect("lista");
}

private void atualize(HttpServletRequest request, HttpServletResponse response)
throws IOException {
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
String senha = request.getParameter("senha"); 
String cpf = request.getParameter("cpf");
String nome = request.getParameter("nome");
String telefone = request.getParameter("telefone");
String sexo = request.getParameter("sexo");
String data = request.getParameter("data");
Cliente cliente = new Cliente(email, senha, cpf, nome, telefone, sexo, data); 
dao.update(cliente);
response.sendRedirect("lista");
}
private void remove(HttpServletRequest request, HttpServletResponse response)
throws IOException {
int id = Integer.parseInt(request.getParameter("id")); //id = cpf?
Cliente cliente = new Cliente(id);
dao.delete(cliente);
response.sendRedirect("lista");
}
}