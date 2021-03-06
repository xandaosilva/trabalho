package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.ModalidadeDao;
import model.domain.Modalidade;

public class ModalidadeDaoImpl implements ModalidadeDao{

	@PersistenceContext(unitName="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	public Modalidade salvar(Modalidade modalidade){
		entityManager.persist(modalidade);
		return modalidade;
	}
	
	@Override
	public void atualizar(Modalidade modalidade){
		salvar(entityManager.merge(modalidade));
	}
	
	@Override
	public void excluir(Modalidade modalidade){
		entityManager.remove(entityManager.merge(modalidade));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Modalidade> getModalidades(Modalidade modalidade){
		StringBuilder hql = new StringBuilder("select m from Modalidade m where 1 = 1");
		
		if(modalidade.getCodigo() != null)
			hql.append("and m.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(modalidade.getCodigo() != null)
			query.setParameter("codigo",modalidade.getCodigo());
			
		return query.getResultList();
	}
}
