package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.TableGenerator;


@Entity
@NamedQueries({ 
	@NamedQuery( name="findAllBrance",
	    query="select B from Brance B"),
	@NamedQuery( name="branceSize",query="select count(B) from Brance B")  	
})

@Table(name="BRANCE")
public class Brance implements java.io.Serializable {
	   
	@Id
	@GeneratedValue(generator = "BRANCE_SEQ", strategy = GenerationType.TABLE)
	@TableGenerator(name = "BRANCE_SEQ", initialValue = 5001, allocationSize = 1)

	@Column(name = "BRANCE_CODE")
	private Integer branceCode;
	@Column(name = "BRANCE_NAME", length = 50)
	private String bName;
	@Column (name = "BRANCE_ADDRESS",columnDefinition="TEXT")
	private String bAddress;
	@Column(name = "BRANCE_TEL",length=50)
	private String bTel;
	@ManyToOne
	@JoinColumn(name = "BRANCE_PROVINCE")
	private Province province;
	@Column(name = "POST_CODE",length=10)
	private String postcode;
	private static final long serialVersionUID = 1L;

	public Brance() {
		super();
	}   
	public Integer getBranceCode() {
		return this.branceCode;
	}

	public void setBranceCode(Integer branceCode) {
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
	public void setProvince(Province province) {
		this.province = province;
	}
	public Province getProvince() {
		return province;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPostcode() {
		return postcode;
	}
   
}
