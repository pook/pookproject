package biz.evolix.model;

import biz.evolix.model.Brance;
import biz.evolix.model.Purchese;
import biz.evolix.model.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 * 
 */
@Entity
@Table(name = "ORDER1")
public class Order implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long orderId;

	
	@JoinColumn(name = "P_ID")
	private List<Purchese> purchese = new ArrayList<Purchese>();
	
	@JoinColumn(name = "USER_ID")
	private Users user;
	
	@Column(name = "TOTAL_PRICE")
	private double totalPrice = 0.0;
	
	@Column(name="TOTAL_QUANTITY")
	private Integer totalQuantity =0;
	@Column(name = "TOTAL_SV", length = 50)
	private Integer totalSv = 0;

	@JoinColumn(name = "BRANCE_CODE")
	private Brance brance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private Date date;	

	private static final long serialVersionUID = 1L;

	public Order() {
		super();
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getTotalSv() {
		return this.totalSv;
	}

	public void setTotalSv(Integer totalSv) {
		totalSv=0;
		for(Purchese p:getPurchese())totalSv=p.getPsv();
		this.totalSv = totalSv;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	public Brance getBrance() {
		return this.brance;
	}

	public void setBrance(Brance brance) {
		this.brance = brance;
	}

	public void setTotalPrice(double totalPrice) {
		totalPrice = 0.0;
		for(Purchese p:getPurchese())totalPrice+=p.getPurchesePrice();
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setPurchese(List<Purchese> purchese) {
		this.purchese = purchese;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="P_ID")
	public List<Purchese> getPurchese() {
		return purchese;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		totalQuantity=0;
		for(Purchese p:getPurchese())totalQuantity+=p.getQuantity();		
		this.totalQuantity = totalQuantity;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

}
