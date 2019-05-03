package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Locadora;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locadora_crud/*")
public class LocadoraController extends HttpServlet {

    private LocadoraDAO daoLocadora;
    private UsuarioDAO daoUsuario;

    @Override
    public void init() {
        daoLocadora = new LocadoraDAO();
        daoUsuario = new UsuarioDAO();
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

                case "/cadastro":
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

                case "/filtro_cidade":
                    filtra_cidade(request, response);

                default:
                    lista(request, response);
                    break;
            }

        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        } catch (SQLException ex) {
            Logger.getLogger(LocadoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) //listar todas as locadoras
            throws ServletException, IOException {
        List<Locadora> listaLocadoras = daoLocadora.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locacadora/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("locacadora/formulario.jsp"); //formulario de locacoes
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) //editar locacoes
            throws ServletException, IOException {
        int id_locadora = Integer.parseInt(request.getParameter("id_locadora"));
        Locadora locadora = daoLocadora.get(id_locadora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locadora/formulario.jsp");
        request.setAttribute("locadora", locadora);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        String cnpj_locadora = request.getParameter("cnpj_locadora");
        String nome_locadora = request.getParameter("nome_locadora");
        String cidade_locadora = request.getParameter("cidade_locadora");
        String senha_usuario = request.getParameter("senha_usuario");
        String email_usuario = request.getParameter("email_usuario");
        int ativo_usuario = 1;

        Locadora locadora = new Locadora(-1,cnpj_locadora, nome_locadora, cidade_locadora, senha_usuario, email_usuario, ativo_usuario);
        daoLocadora.insert(locadora);
        response.sendRedirect("lista");
    }

    private void atualiza(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id_locadora = Integer.parseInt(request.getParameter("id_locadora"));
        String cnpj_locadora = request.getParameter("cnpj_locadora");
        String nome_locadora = request.getParameter("nome_locadora");
        String cidade_locadora = request.getParameter("cidade_locadora");
        String senha_usuario = request.getParameter("senha_usuario");
        String email_usuario = request.getParameter("email_usuario");
        int ativo_usuario = 1;

        Locadora locadora = new Locadora(id_locadora,cnpj_locadora, nome_locadora, cidade_locadora, senha_usuario, email_usuario, ativo_usuario);
        daoLocadora.update(locadora);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id_locadora = Integer.parseInt(request.getParameter("id_locadora"));
        Locadora locadora = new Locadora(id_locadora);
        daoLocadora.delete(locadora);
        response.sendRedirect("lista");
    }
    private void filtra_cidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String cidade = request.getParameter("cidade");
        
        List<Locadora> listaLocadoras = daoLocadora.getbyCities(cidade);
        request.setAttribute("listaLocadoras", listaLocadoras);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista.jsp");
        dispatcher.forward(request, response);
    }
}
