package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Thalyson");
		conta.setBanco("Bradesco");
		conta.setAgencia("6200");
		conta.setNumero("476595");
		
		EntityManagerFactory efm = Persistence.createEntityManagerFactory("financas");
		
		EntityManager em = efm.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		efm.close();
	}
}
