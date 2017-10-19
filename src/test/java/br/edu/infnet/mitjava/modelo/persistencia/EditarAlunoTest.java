package br.edu.infnet.mitjava.modelo.persistencia;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.mitjava.modelo.Aluno;
import br.edu.infnet.mitjava.persistencia.DAO;
import br.edu.infnet.mitjava.persistencia.jpa.impl.AlunoDao;

public class EditarAlunoTest {

	Aluno aluno = new Aluno();
	DAO dao = new AlunoDao();

	@Before
	public void setup() {
		aluno.setNome("jose da silva");
		aluno.setEndereco("rua das couves, 25");
		dao.salvar(aluno);
	}
	
	
	@Test
	public void editarAluno() {
		//arrange
		aluno.setNome("Osmar Freire");
		aluno.setEndereco("Rua 2");
		
		//act
		dao.editar(aluno);
		
		//assert
		Aluno byId = (Aluno) dao.getById(aluno.getId());
		MatcherAssert.assertThat(byId.getNome(), Matchers.is("Osmar Freire"));
		
	}
	
}
