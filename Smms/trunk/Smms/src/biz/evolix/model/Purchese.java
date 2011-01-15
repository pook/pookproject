package biz.evolix.model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Purchese
 * 
 */
@Entity
@Table(name = "PURCHESE")
public class Purchese implements java.io.Serializable {

	private static final long serialVersionUID = 6759142374990937368L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "P_ID")
	private Long pId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "S_ID",referencedColumnName="S_ID",updatable=true)
	private Sku sku;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", nullable=false,referencedColumnName="ORDER_ID")	
	private Order order;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "PSV")
	private Integer psv;

	@Column(name = "P_PRICE")
	private Double purchesePrice;

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

		
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public void setPurchesePrice(Double purchesePrice) {
		this.purchesePrice = purchesePrice;
	}

	public Double getPurchesePrice() {
		Double p = getSku().getPriceDiscount() * getQuantity();
		setPurchesePrice(p);
		return purchesePrice;// *getQuantity();
	}

	public void setPsv(Integer psv) {
		this.psv = psv;
	}

	public Integer getPsv() {
		try {
			Integer sv = getSku().getSv() * getQuantity();
			if (sv > 0)
				setPsv(sv);
		} catch (Exception e) {
			
		}
		return psv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 13;
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchese other = (Purchese) obj;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		return true;
	}
	
}
