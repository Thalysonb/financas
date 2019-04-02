package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//Movimentacao movimentacao =  em.find(Movimentacao.class,4);
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		//TypedQuery<Double> query = em.createQuery(jpql,Double.class); //determina o tipo de resultado que a query deve retornar
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta Conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		
		
		//System.out.println(movimentacoes.size());
		
		
	}

}
