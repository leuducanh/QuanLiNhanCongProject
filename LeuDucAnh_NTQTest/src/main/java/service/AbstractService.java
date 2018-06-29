package main.java.service;

import java.util.List;
import java.util.Scanner;

import main.java.service.validation.CommonValidation;
import main.java.storage.Storageable;

public class AbstractService<V,E extends Storageable<V>> {

	protected Scanner scanner = new Scanner(System.in);
	protected CommonValidation validation = new CommonValidation();
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

	public void save(V v) {
		storage.save(v);
	}
	
	public List<V> getAll() {
		return storage.getAll();
	}
}
