package com.example.domain;

import java.util.List;

public interface Repository<E, K> {
	List<E> read();
	E read(K key);
	E save(E item);
	void delete(E item);
	void deleteById(K key);
}
