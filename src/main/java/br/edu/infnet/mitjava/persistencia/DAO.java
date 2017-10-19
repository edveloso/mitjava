package br.edu.infnet.mitjava.persistencia;

public interface DAO<T> {

	void salvar(T entity);

	void editar(T entity);

	T getById(Integer id);

	void deletar(T entity);

}