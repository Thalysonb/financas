package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaCategoriaMovimentacao {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocio");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setValor(new BigDecimal("300.00"));
		movimentacao1.setDescricao("Viagem para São Paulo");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setValor(new BigDecimal("400.00"));
		movimentacao2.setDescricao("Viagem para o Rio de Janeiro");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria1);
		em.persist(categoria2);
		em.merge(conta);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		

	}

}
