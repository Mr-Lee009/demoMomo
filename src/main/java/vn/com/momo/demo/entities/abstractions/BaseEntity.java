package vn.com.momo.demo.entities.abstractions;

public abstract class BaseEntity<T> {
	public T Id;
	public T getId() {
		return Id;
	}
	public void setId(T id) {
		Id = id;
	}
}
