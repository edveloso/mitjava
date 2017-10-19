package br.edu.infnet.mitjava.modelo.persistencia;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.edu.infnet.mitjava.modelo.Aluno;
import br.edu.infnet.mitjava.persistencia.DAO;
import br.edu.infnet.mitjava.persistencia.jpa.impl.AlunoDao;


public class InserirAlunoNoBancoTest {

	
	@Test
	public void inserirAluno() {
		//arrange
		Aluno aluno = new Aluno();
		aluno.setNome("jose da silva");
		aluno.setEndereco("rua das couves, 25");
		
		//act
		DAO dao = new AlunoDao();
		dao.salvar(aluno);
		
		//Assert
		assertThat(aluno.getId(), Matchers.notNullValue());
		
	}
	
}
