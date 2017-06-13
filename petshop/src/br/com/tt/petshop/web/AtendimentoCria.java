package br.com.tt.petshop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tt.petshop.dao.ClienteDAO;
import br.com.tt.petshop.model.Cliente;

@WebServlet("/AtendimentoCria")
public class AtendimentoCria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ClienteDAO clienteDAO;
	
    public AtendimentoCria() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w = response.getWriter();
		
		w.write("<html><body>");
		w.write("<form method='post'>");
		
		w.write("<select name='cliente_id'>");
		List<Cliente> lista = clienteDAO.list();
		for (Cliente cliente : lista){
			w.write("<option id='");
			w.write(cliente.getId()+"'>");
			w.write(cliente.getNome());
			w.write("</option>");
		}
		w.write("</select>");
		
		w.write("<input name='data_agendamento' type='date'>");
		w.write("<input type='submit' value='Agendar' />");
		
		w.write("</form>");
		w.write("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
