package br.com.tt.petshop.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tt.petshop.dao.ClienteDAO;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.model.Cliente;

/**
 * Servlet implementation class ClienteList
 */
@WebServlet("/ClienteList")
public class ClienteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Inject
	private ClienteDAO clienteDAO;

	public ClienteList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("<html><body>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().write(
				"<br><br>"
				+"<form method='get'>"
				+"Cliente: "
				+"<input name='pesquisa' />"
				+"<input type='submit' value='Pesquisar' />"
				+"</form><br><br>"
		);
		
		List<Cliente> lista;
		
		if (request.getParameter("pesquisa") != null &&
				!request.getParameter("pesquisa").isEmpty()){
			lista = clienteDAO.findByNome(request.getParameter("pesquisa"));
		} else {
			lista = clienteDAO.list();
		}
		
		response.getWriter().write("Lista de Clientes<br>");
		for (Cliente cliente : lista) {
			response.getWriter().write(cliente.getId() 
										+ " - " + cliente.getNome()
										+ " - Unidade: " + cliente.getUnidade().getNome()
										+ " <br>");
			
			response.getWriter().write("<small>Atendimentos: ");
			
			List<Atendimento> atendimentos = cliente.getAtendimentos();
			
			for (Atendimento atendimento : atendimentos){
				response.getWriter().write(atendimento.getDataAgendamento() + ", ");
			}
			
			response.getWriter().write("</small><br><br>");
		}
		response.getWriter().write("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
