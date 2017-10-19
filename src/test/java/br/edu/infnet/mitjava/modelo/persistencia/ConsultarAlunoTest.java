package br.edu.infnet.mitjava.modelo.persistencia;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.mitjava.modelo.Aluno;
import br.edu.infnet.mitjava.persistencia.DAO;
import br.edu.infnet.mitjava.persistencia.jpa.impl.AlunoDao;

public class ConsultarAlunoTest {

	Aluno aluno = new Aluno();
	DAO dao = new AlunoDao();

	@Before
	public void setup() {
		aluno.setNome("jose da silva");
		aluno.setEndereco("rua das couves, 25");
		dao.salvar(aluno);
	}
	
	@Test
	public void testAluno() {
		//arrange
		dao = new AlunoDao();
		
		//act
		Aluno alunoBD =   (Aluno) dao.getById(aluno.getId());
		
		//assert
		MatcherAssert.assertThat(alunoBD.getNome(), Matchers.is(aluno.getNome()));
		
	}
	
}
