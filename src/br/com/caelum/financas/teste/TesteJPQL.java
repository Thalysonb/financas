package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria categoria = new Categoria();
		categoria.setId(3);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc"; //Escreve query JPQL
		
		String jpql = "select m from Movimentacao m  join m.categoria c where c = :pCategoria "; //Escreve query JPQL
		
		Query query = em.createQuery(jpql); //cria a query
		query.setParameter("pCategoria",categoria); //seta o named parameter
		//query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList(); //recebe o resultado da query
		
		for (Movimentacao movimentacao : resultados) {
			
			System.out.println("Descricao " + movimentacao.getDescricao());
		}

	}

}
