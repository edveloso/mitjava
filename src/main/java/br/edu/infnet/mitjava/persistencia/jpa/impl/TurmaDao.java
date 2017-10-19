package br.edu.infnet.mitjava.persistencia.jpa.impl;

import br.edu.infnet.mitjava.modelo.Turma;
import br.edu.infnet.mitjava.persistencia.jpa.JpaDao;

public class TurmaDao extends JpaDao<Turma>{

	public TurmaDao() {
		super(Turma.class);
	}
	
}
