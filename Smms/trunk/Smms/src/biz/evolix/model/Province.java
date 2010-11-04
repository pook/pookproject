package biz.evolix.model;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Province
 * 
 */
@Entity
@Table(name="PROVINCE")
public class Province implements java.io.Serializable {

	@Id
	@Column(name ="PROVINCE_CODE",length=5 )
	private String pCode;
	@Column(name = "PROVINCE", length = 50)
	private String pname;
	private static final long serialVersionUID = 1L;

	public Province() {
		super();
	}

	

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}



	public void setpCode(String pCode) {
		this.pCode = pCode;
	}



	public String getpCode() {
		return pCode;
	}

}
