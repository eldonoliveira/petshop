package br.com.tt.petshop.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.tt.petshop.model.Atendimento;

@Stateless
public class AtendimentoDAO extends GenericDAO {

	private static final long serialVersionUID = 1L;
	
	public List<Atendimento> listarPorIntervalo( Date inicio, Date fim){
		
//		getHibernateSession().evict(arg0);
//		getHibernateSession().saveOrUpdate(arg0);
//		getHibernateSession().get(Produto.class, 1);
		
		
//		select a from Atendimento a join fetch a.unidade 
//		where a.dataAgendamento between :inicio and :fim
//		and a.unidade is not null
//		and u.nome like '%Target%'
//		and 
		
		Criteria cr = getHibernateSession().createCriteria(Atendimento.class);
		cr.createAlias("unidade", "u");
		cr.add(Restrictions.between("dataAgendamento", inicio, fim));
		cr.add(Restrictions.isNotNull("unidade"));
//		cr.add(Restrictions.ilike("u.nome", "Target", MatchMode.ANYWHERE)); /* Equivalente ao FETCH */
		
		cr.addOrder(Order.asc("dataAgendamento"));
		
		return cr.list();
	}

}
