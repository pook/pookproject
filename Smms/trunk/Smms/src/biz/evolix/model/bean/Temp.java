package biz.evolix.model.bean;

public class Temp<T> implements java.io.Serializable{
	
	private static final long serialVersionUID = -8734017165842287045L;
	private T temp;

	public void setTemp(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public Temp(T temp) {
		super();
		this.temp = temp;
	}
	public Temp(){
		super();
	}
	
}
