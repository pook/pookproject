package biz.evolix.model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Purchese
 *
 */
@Entity
@Table(name="PURCHESE")
public class Purchese implements java.io.Serializable {
 
//	@Embeddable
//	public static class Id implements Serializable{
//		public 
//	}
		
	private static final long serialVersionUID = 6759142374990937368L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="P_ID")
	private Long pId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="S_ID")
	private Sku sku;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ORDER_ID")
	private Order order;	
		
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name ="PSV")
	private Integer psv;
	
	@Column(name="P_PRICE")
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
	public Integer getPsv() {
		return psv;
	}
	public void setPsv(Integer psv) {
		this.psv = psv*getQuantity();
	}
	public void setPurchesePrice(Double purchesePrice) {
		this.purchesePrice = purchesePrice*getQuantity();
	}
	public Double getPurchesePrice() {
		return purchesePrice;
	}
	   
}
