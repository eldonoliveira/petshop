package br.com.tt.petshop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tt.petshop.dao.AtendimentoDAO;
import br.com.tt.petshop.dao.ClienteDAO;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.model.Cliente;

@WebServlet("/AtendimentoLista")
public class AtendimentoLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Inject private ClienteDAO clienteDAO;
    
    @Inject private AtendimentoDAO atendimentoDAO;

    public AtendimentoLista() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter w = response.getWriter();
		w.write("<html><body><form method='post'>");

		w.write("<select name='cliente_id'>");
		List<Cliente> lista = clienteDAO.list();
		for (Cliente cliente : lista) {
			w.write("<option value='");
			w.write(String.valueOf(cliente.getId()));
			w.write("'>"); 
			w.write(cliente.getNome());
			w.write("</option>");
		}
		w.write("</select>");
		
		w.write("<input name='data_inicio' type='date'>");
		w.write("<input name='data_fim' type='date'>");
		w.write("<input value='Listar' type='submit'>");

		w.write("</form>");
		
		//Veio param?
		String clienteId = request.getParameter("cliente_id");
		if(clienteId != null && !clienteId.isEmpty()){
			String dataInicio = request.getParameter("data_inicio");
			String dataFim = request.getParameter("data_fim");
			List<Atendimento> atendimentos = atendimentoDAO.listarPorIntervalo(
																converteParaDate(dataInicio), 
																converteParaDate(dataFim),
																Long.parseLong(clienteId));
			w.write("<ol>");
			for (Atendimento atendimento : atendimentos) {
				w.write("<li>");
				w.write(atendimento.getCliente().getNome());
				w.write(" - ");
				w.write(String.valueOf(atendimento.getDataAgendamento()));
				w.write("</li>");
			}
			w.write("</ol>");
		}
		
		w.write("</body></html>");
	}
	
	public Date converteParaDate(String entrada){
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(entrada);
		} catch (ParseException e){
			e.printStackTrace();
			return null;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
