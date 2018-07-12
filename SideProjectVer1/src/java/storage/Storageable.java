package storage;

import java.util.List;

public interface Storageable<E> {

	public boolean delete(String id);

	public boolean save(E e);
	
	public List<E> getAll();

	public boolean update(E e);
}
