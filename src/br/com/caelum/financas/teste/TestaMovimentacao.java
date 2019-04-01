package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("6200");
		conta.setBanco("Bradesco");
		conta.setNumero("476595");
		conta.setTitular("Thalyson");
		
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setValor(new BigDecimal("200.00"));
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.persist(movimentacao);
		
		
		em.getTransaction().commit();
	}
}
