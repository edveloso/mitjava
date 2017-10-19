package br.edu.infnet.mitjava.modelo.persistencia;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import br.edu.infnet.mitjava.modelo.Turma;
import br.edu.infnet.mitjava.persistencia.jpa.impl.TurmaDao;
public class InserirTurmaTest {

	@Test
	public void inserirTurma() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Turma turma = new Turma();
		turma.setNome("Java Avançado");
		turma.setCodigo("MitJa801");
		TurmaDao dao = new TurmaDao();
		
		dao.salvar(turma);
		
		assertThat(turma.getId(), notNullValue());
		
	}
	
	
}
