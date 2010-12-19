package biz.evolix.model;

import biz.evolix.model.Purchese;
import biz.evolix.model.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "findOrderAll", query = "select O from Order O"),
	@NamedQuery(name = "findOrderOwner", query = "select O from Order O where O.user =?1"),
	@NamedQuery(name = "findOrderByStaff", query = "select O from Order O where O.seller =?1"),
	@NamedQuery(name = "getSizeOrderAll", query = "select count(O) from Order O"),
	@NamedQuery(name = "getSizeOrderOwner", query = "select count(O) from Order O where O.user =?1"),
	@NamedQuery(name = "getSizeOrderByStaff", query = "select count(O) from Order O where O.seller =?1") })
@Table(name = "ORDER1")
public class Order implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	private List<Purchese> purchese = new ArrayList<Purchese>();

	@JoinColumn(name = "USER_ID",columnDefinition="CHAR(20)")
	@ManyToOne
	private Users user;

	@Column(name = "SELLER_ID" ,columnDefinition="CHAR(20)")
	private String seller;
	@Column(name = "TOTAL_PRICE")
	private double totalPrice = 0.0;

	@Column(name = "TOTAL_QUANTITY")
	private Integer totalQuantity = 0;
	@Column(name = "TOTAL_SV")
	private Integer totalSv = 0;

	@Column(name = "READED")
	private Boolean readed = false;
	
	@Column(name = "BRANCE")
	private Integer brance;
	
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
		getTSV();
		return this.totalSv;
	}
	
	@Transient
	private void getTSV() {
		if(getPurchese()==null || getPurchese().size()<1)return;
		Integer s = 0;
		for (Purchese p : getPurchese())
			s += p.getPsv();
		setTotalSv(s);
	}

	public void setTotalSv(Integer totalSv) {
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

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		getTp();
		return totalPrice;
	}
	@Transient
	private void getTp() {
		if(getPurchese()==null || getPurchese().size()<1)return;
		Double tot = 0.0;		
		for (Purchese p : getPurchese())
			tot += p.getPurchesePrice();
		setTotalPrice(tot);
	}

	public void setPurchese(List<Purchese> purchese) {
		this.purchese = purchese;
	}

	@OneToMany(mappedBy = "P_ID", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public List<Purchese> getPurchese() {
		return purchese;
	}

	public void setTotalQuantity(Integer totalQuantity) {

		this.totalQuantity = totalQuantity;
	}

	public Integer getTotalQuantity() {
		getTQ();
		return totalQuantity;
	}
	@Transient
	private void getTQ() {
		if(getPurchese()==null || getPurchese().size()<1)return;
		Integer tot = 0;		
		for (Purchese p : getPurchese())
			tot += p.getQuantity();
		setTotalQuantity(tot);
	}

	public void setReaded(Boolean readed) {
		this.readed = readed;
	}

	public Boolean getReaded() {
		return readed;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSeller() {
		return seller;
	}

	public void setBrance(Integer brance) {
		this.brance = brance;
	}

	public Integer getBrance() {
		return brance;
	}
}
