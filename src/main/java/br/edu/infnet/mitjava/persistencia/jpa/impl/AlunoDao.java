package br.edu.infnet.mitjava.persistencia.jpa.impl;

import br.edu.infnet.mitjava.modelo.Aluno;
import br.edu.infnet.mitjava.persistencia.jpa.JpaDao;

public class AlunoDao extends JpaDao<Aluno> {

	public AlunoDao() {
		super(Aluno.class);
	}

}
