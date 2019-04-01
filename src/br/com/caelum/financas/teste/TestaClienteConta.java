package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(4);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Maria dos Santos");
		cliente1.setEndereco("Rua feitiço da vila");
		cliente1.setProfissao("Professora");
		cliente1.setConta(conta);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Antonio Duraes");
		cliente2.setEndereco("Estrada de Itapecerica");
		cliente2.setProfissao("Uber");
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente2);
		
		em.getTransaction().commit();

	}

}
