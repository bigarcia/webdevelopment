package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class novoCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro de Novo Cliente</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      br.ufscar.dc.dsw.model.Cliente cliente = null;
      synchronized (_jspx_page_context) {
        cliente = (br.ufscar.dc.dsw.model.Cliente) _jspx_page_context.getAttribute("cliente", PageContext.PAGE_SCOPE);
        if (cliente == null){
          cliente = new br.ufscar.dc.dsw.model.Cliente();
          _jspx_page_context.setAttribute("cliente", cliente, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <h1>Novo cliente</h1>\n");
      out.write("        <form action=\"NovoClienteServlet\" method=\"post\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Digite seus dados:</legend>\n");
      out.write("                E-mail: <input name=\"email\" type=\"text\" value=\"\"/><br/>\n");
      out.write("                Senha: <input name=\"senha\" type=\"text\" value=\"\"/><br/>\n");
      out.write("                CPF: <input name=\"cpf\" type=\"text\" value=\"\"/><br/>\n");
      out.write("                Nome: <input name=\"nome\" type=\"text\" /><br/>\n");
      out.write("                Telefone: <input name=\"telefone\" type=\"text\" value=\"\" /><br/>\n");
      out.write("                Sexo: <input name=\"sexo\" type=\"text\" value=\"\"/><br/>\n");
      out.write("                Data de nascimento: <input name=\"dataDeNascimento\" type=\"date\" value=\"\" /><br/>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <input type=\"submit\" value=\"Enviar\"/>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}