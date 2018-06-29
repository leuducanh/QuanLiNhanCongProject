package main.java.storage;

import java.util.List;

public interface Storageable<E> {

	public void save(E e);
	
	public List<E> getAll();
}
