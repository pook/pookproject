package biz.evolix.model;

import javax.persistence.*;

@Entity
@NamedQueries({ @NamedQuery(name = "findSku", query = "Select K from Sku K"),
		@NamedQuery(name = "getSizeSku", query = "select count(o) from Sku o") })
@Table(name = "SKU")
public class Sku implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_ID")
	private Long sid;
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;
	@Column(name = "PRICE")
	private Double price = 0.0;
	@Column(name = "MEMBER_PRICE")
	private Double memberPrice = 0.0;
	@Column(name = "SV")
	private Integer sv = 0;
	@Column(name = "DISCOUNT")
	private Integer discount = 0;
	@Column(name = "DESCRIPTION", columnDefinition="TEXT(500)")
	private String description;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "PRICE_DISCOUNT")
	private Double priceDiscount = 0.0;
	private static final long serialVersionUID = 1L;

	public Sku() {
		super();
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSv() {
		return this.sv;
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Double getMemberPrice() {
		return memberPrice;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setPriceDiscount(Double priceDiscount) {
		this.priceDiscount = priceDiscount; // +=(getPrice()*getDiscount()/100);

	}

	public Double getPriceDiscount() {
		setPriceDiscount( (getMemberPrice() - (getMemberPrice() * getDiscount() / 100)));
		return this.priceDiscount;
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Sku) {
			long id = ((Sku) that).getSid();
			if (this.getSid() == id)
				return true;
		}
		return false;
	}

}
