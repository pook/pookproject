package biz.evolix.model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Brance
 *
 */
@Entity
@Table(name="BRANCE")
public class Brance implements java.io.Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BRANCE_CODE",length=10)
	private Long branceCode;
	@Column(name = "BRANCE_NAME", length = 50)
	private String bName;
	@Column (name = "BRANCE_ADDRESS",length=70)
	private String bAddress;
	@Column(name = "BRANCE_TEL",length=50)
	private String bTel;
	private static final long serialVersionUID = 1L;

	public Brance() {
		super();
	}   
	public Long getBranceCode() {
		return this.branceCode;
	}

	public void setBranceCode(Long branceCode) {
		this.branceCode = branceCode;
	}   
	public String getBName() {
		return this.bName;
	}

	public void setBName(String bName) {
		this.bName = bName;
	}   
	public String getBAddress() {
		return this.bAddress;
	}

	public void setBAddress(String bAddress) {
		this.bAddress = bAddress;
	}   
	public String getBTel() {
		return this.bTel;
	}

	public void setBTel(String bTel) {
		this.bTel = bTel;
	}
   
}
