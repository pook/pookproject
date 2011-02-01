package biz.evolix;

public class BeanClazz<T> {
	private T arg0;
	private T arg1;
	private T arg2;
	
	public T getArg0() {
		return arg0;
	}

	public void setArg0(T arg0) {
		this.arg0 = arg0;
	}

	public T getArg1() {
		return arg1;
	}

	public void setArg1(T arg1) {
		this.arg1 = arg1;
	}

	public T getArg2() {
		return arg2;
	}

	public void setArg2(T arg2) {
		this.arg2 = arg2;
	}

	public BeanClazz(T arg0, T arg1, T arg2) {
		super();
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
}
