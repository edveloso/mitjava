package br.edu.infnet.mitjava.modelo.persistencia;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.mitjava.modelo.Aluno;
import br.edu.infnet.mitjava.persistencia.DAO;
import br.edu.infnet.mitjava.persistencia.jpa.impl.AlunoDao;

public class DeletarAlunoTest {

	
	Aluno aluno = new Aluno();
	DAO dao = new AlunoDao();

	@Before
	public void setup() {
		aluno.setNome("jose da silva");
		aluno.setEndereco("rua das couves, 25");
		dao.salvar(aluno);
	}
	
	
	@Test
	public void deletaUmAlunoPorId() {
		
		dao.deletar(aluno);
		Aluno alunoBD  = (Aluno) dao.getById(aluno.getId());
		assertThat(alunoBD, nullValue());
		
	}
}
