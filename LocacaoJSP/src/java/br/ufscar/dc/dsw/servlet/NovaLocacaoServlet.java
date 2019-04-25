/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.locacao.bean.NovaLocacaoFormBean;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Bianca
 */
@WebServlet(urlPatterns = {"/novolocacao"})
public class NovaLocacaoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

               NovaLocacaoFormBean nlofb = new NovaLocacaoFormBean();
        try {
            BeanUtils.populate(nlofb, request.getParameterMap());
            request.getSession().setAttribute("novaLocacao", nlofb);
            request.getRequestDispatcher("confirmaLocacao.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

       
    }
}
