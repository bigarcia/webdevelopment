/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.Cliente;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cliente_crud/*")
public class ClienteController extends HttpServlet {
    
    private ClienteDAO daoCliente;
    private UsuarioDAO daoUsuario;

    @Override
    public void init() {
        daoCliente = new ClienteDAO();
        daoUsuario = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "insercao":
                    insere(request, response);
                    break;
                case "remocao":
                    remove(request, response);
                    break;
                case "edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "atualizacao":
                    atualiza(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> listaClientes = daoCliente.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/lista.jsp");    
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
       dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Cliente cliente = daoCliente.get(id_cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        request.setAttribute("cliente", cliente);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
      
                
        request.setCharacterEncoding("UTF-8");
        String cpf_cliente = request.getParameter("cpf_cliente");
        String nome_cliente = request.getParameter("nome_cliente");        
        String telefone_cliente = request.getParameter("telefone_cliente");
        String sexo_cliente = request.getParameter("sexo_cliente");
        String nascimento_cliente = request.getParameter("nascimento_cliente");      
        String email_usuario = request.getParameter("email_usuario");
          System.out.println(email_usuario);
        String senha_usuario = request.getParameter("senha_usuario");
        int ativo_usuario = 1;
                
        Cliente cliente = new Cliente(-1,cpf_cliente,nome_cliente,telefone_cliente,sexo_cliente,nascimento_cliente,senha_usuario, email_usuario, ativo_usuario);
        
        daoCliente.insert(cliente);
        
        response.sendRedirect("lista");
    }

    private void atualiza(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        request.setCharacterEncoding("UTF-8");
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String cpf_cliente = request.getParameter("cpf_cliente");
        String nome_cliente = request.getParameter("nome_cliente");        
        String telefone_cliente = request.getParameter("telefone_cliente");
        String sexo_cliente = request.getParameter("sexo_cliente");
        String nascimento_cliente = request.getParameter("nascimento_cliente");      
        String email_usuario = request.getParameter("email_usuario");
        String senha_usuario = request.getParameter("senha_usuario");
        int ativo_usuario = 1;
       
        
        Cliente cliente = new Cliente(id_cliente, cpf_cliente,nome_cliente,telefone_cliente,sexo_cliente,nascimento_cliente,senha_usuario, email_usuario, ativo_usuario);
        daoCliente.update(cliente);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Cliente cliente = new Cliente(id_cliente);
        daoCliente.delete(cliente);
        response.sendRedirect("lista");
    }
    
}
