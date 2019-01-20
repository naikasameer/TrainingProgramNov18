package com.mastek.training_app.jdbcapp;

import java.util.List;

public interface DataAccessObject<E> {

	public E add(E newEntity);
	public List<E> list();
	public List<E> find(int key);
	public E remove(E e);
	public E update(E e);
	
}
