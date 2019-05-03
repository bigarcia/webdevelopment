package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.Cliente;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Locacao;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locacao_crud/*")
public class LocacaoController extends HttpServlet {

    private LocacaoDAO daoLocacao;
    private ClienteDAO daoCliente;

    @Override
    public void init() {
        daoLocacao = new LocacaoDAO();
        daoCliente = new ClienteDAO();
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

                case "/cadastro_locacao":
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
                    atualiza(request, response);
                    break;
                case "/filtro_cliente":
                    filtra_cliente(request, response);
                    break;
                    
                    
                 case "/filtro_locadora":
                    filtra_locadora(request, response);
                    break;
                    
                default:
                    lista(request, response);
                    break;
            }

        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) //listar todas as locacoes
            throws ServletException, IOException {
        List<Locacao> listarLocacao = daoLocacao.getAll();
        request.setAttribute("listaLocacao", listarLocacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/formulario.jsp"); //formulario de locacoes
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) //editar locacoes
            throws ServletException, IOException {
        int id_locacao = Integer.parseInt(request.getParameter("id_locacao")); //
        Locacao locacao = daoLocacao.get(id_locacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/formulario.jsp");
        request.setAttribute("locacao", locacao);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        request.setCharacterEncoding("UTF-8");
      
        //int id_locacao = Integer.parseInt(request.getParameter("id_locacao"));
        String dia_locacao = request.getParameter("dia_locacao");
        String hora_locacao = request.getParameter("hora_locacao");                
        String cpf_cliente = request.getParameter("cpf_cliente");
        String cnpj_locadora = request.getParameter("cnpj_locadora");
        //String email_usuario = request.getParameter("email_usuario");
        
        Locacao locacao = new Locacao(-1,dia_locacao,hora_locacao,cpf_cliente, cnpj_locadora);
        boolean sucesso = daoLocacao.insert(locacao);
        if(!sucesso){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/formulario.jsp");
            request.setAttribute("listaCliente", new ClienteDAO().getAll());
            dispatcher.forward(request, response);
        } 
        response.sendRedirect("lista");
    }

    private void atualiza(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        request.setCharacterEncoding("UTF-8");
        int id_locacao = Integer.parseInt(request.getParameter("id_locacao"));
        String dia_locacao = request.getParameter("dia_locacao");
        String hora_locacao = request.getParameter("hora_locacao");                
        String cpf_cliente = request.getParameter("cpf_cliente");
        String cnpj_locadora = request.getParameter("cnpj_locadora");
        Locacao locacao = new Locacao(id_locacao,dia_locacao,hora_locacao,cpf_cliente, cnpj_locadora);
        daoLocacao.update(locacao);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id_locacao = Integer.parseInt(request.getParameter("id_locacao")); //id = cpf?
        Locacao locacao = new Locacao(id_locacao);
        daoLocacao.delete(locacao);
        response.sendRedirect("lista");
    }
    
    private void filtra_cliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getUserPrincipal().getName().toString();
        List<Locacao> listaLocacao = daoLocacao. getbyClient(daoCliente.getCpf(email));
        request.setAttribute("listaLocacao", listaLocacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void filtra_locadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Locacao> listaLocacao = daoLocacao.getbyAgency(request.getParameter("cnpj_locadora"));
        request.setAttribute("listaLocacao", listaLocacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }
}
