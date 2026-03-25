package com.example.domain;

import java.util.List;

public interface DomainService <E, K> {
	List<E> getAll();
	E getOne(K key);
	E add(E item);
	E change(E item);
	void delete(E item);
	void deleteById(K key);
}
