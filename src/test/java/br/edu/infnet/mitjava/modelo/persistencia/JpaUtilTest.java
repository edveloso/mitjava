package br.edu.infnet.mitjava.modelo.persistencia;

import javax.persistence.EntityManager;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import br.edu.infnet.mitjava.persistencia.JpaUtil;

public class JpaUtilTest {
	
	
	@Test
	public void retornaEntityManagerUnica() {
		
		EntityManager em = JpaUtil.createEntityManager();
		
		MatcherAssert.assertThat(em, Matchers.notNullValue());
		
		
	}

}
