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

	@JoinColumn(name = "USER_ID")
	@ManyToOne
	private Users user;

	@JoinColumn(name = "SELLER_ID")
	@ManyToOne
	private Users seller;
	@Column(name = "TOTAL_PRICE")
	private double totalPrice = 0.0;

	@Column(name = "TOTAL_QUANTITY")
	private Integer totalQuantity = 0;
	@Column(name = "TOTAL_SV", length = 50)
	private Integer totalSv = 0;

	@Column(name = "READED")
	private Boolean readed = false;
	// brance name
	@Column(name = "BRANCE", length = 50)
	private String brance;
	// ////
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

	private void getTSV() {
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

	private void getTp() {
		Double tot = 0.0;
		for (Purchese p : getPurchese())
			tot += p.getPurchesePrice();
		setTotalPrice(tot);
	}

	public void setPurchese(List<Purchese> purchese) {
		this.purchese = purchese;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "P_ID")
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

	private void getTQ() {
		Integer tot = 0;
		for (Purchese p : getPurchese())
			tot += p.getQuantity();
		setTotalQuantity(tot);
	}

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getBrance() {
		return brance;
	}

	public void setReaded(Boolean readed) {
		this.readed = readed;
	}

	public Boolean getReaded() {
		return readed;
	}

	public void setSeller(Users seller) {
		this.seller = seller;
	}

	public Users getSeller() {
		return seller;
	}
}
