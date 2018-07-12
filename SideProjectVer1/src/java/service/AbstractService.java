package service;

import service.validation.CommonValidation;
import storage.Storageable;

import java.util.List;
import java.util.Scanner;

public class AbstractService<V,E extends Storageable<V>> {

	protected Scanner scanner = new Scanner(System.in);

	protected E storage;	
	
	public AbstractService() {
		super();
	}

	public AbstractService(E storage) {
		super();
		this.storage = storage;
	}
	
	public void setStorage(E storage) {
		this.storage = storage;
	}

	public boolean save(V v) {
		return storage.save(v);
	}
	
	public List<V> getAll() {
		return storage.getAll();
	}
}
