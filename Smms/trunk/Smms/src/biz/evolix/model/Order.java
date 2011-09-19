package biz.evolix.model;

import biz.evolix.model.Purchese;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.TableGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
		@NamedQuery(name = "findOrderAll", query = "select O from Order O where O.canceled=?1 order by O.orderId desc"),
		@NamedQuery(name = "findOrderbyOwner", query = "select O from Order O where O.user =?1 and O.canceled=?2 order by O.orderId desc"),
		@NamedQuery(name = "findOrderByStaff", query = "select O from Order O where O.seller in (select S.userId from Staff S where S.brance=?1) and O.canceled=?2 order by O.orderId desc"),
		@NamedQuery(name = "getSizeOrderAll", query = "select count(0) from Order O where O.canceled=?1"),
		@NamedQuery(name = "getSizeOrderOwner", query = "select count(0) from Order O where O.user =?1 and O.canceled=?2"),
		@NamedQuery(name = "getSizeOrderByStaff", query = "select count(0) from Order O where O.seller in (select S.userId from Staff S where S.brance=?1) and O.canceled=?2") })
@Table(name = "ORDER1")
public class Order implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "ORDER_SEQ", strategy = GenerationType.TABLE)
	@TableGenerator(name = "ORDER_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "ORDER_ID")
	private Long orderId;

	private List<Purchese> purchese = new ArrayList<Purchese>();

	@JoinColumn(name = "USER_ID")
	@ManyToOne
	private Users user;

	@Column(name = "SELLER_ID")
	private Long seller;
	@Column(name = "TOTAL_PRICE")
	private double totalPrice = 0.0;

	@Column(name = "TOTAL_QUANTITY")
	private Integer totalQuantity = 0;
	@Column(name = "TOTAL_SV")
	private Integer totalSv = 0;

	@Column(name = "BRANCE")
	private String brance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private Date date;

	@Column(name = "READED")
	private Boolean readed = false;
	@Column(name = "CANCELED")
	private Boolean canceled = false;

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
		int s = 0;
		if (getPurchese() != null || getPurchese().size() >0){
			for (Purchese p : getPurchese())
				s += p.getPsv();			
		}			
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

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		getTp();
		return totalPrice;
	}

	@Transient
	private void getTp() {
		double tot = 0.0;
		if (getPurchese() != null || getPurchese().size() > 0) 
			for (Purchese p : getPurchese())
				tot += p.getPurchesePrice();		
		setTotalPrice(tot);
	}

	public void setPurchese(List<Purchese> purchese) {
		this.purchese = purchese;
	}

	@OneToMany(mappedBy = "P_ID", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE, CascadeType.MERGE }, fetch = FetchType.EAGER)
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
		int tot = 0;
		if (getPurchese() != null || getPurchese().size() > 0)
			for (Purchese p : getPurchese())
				tot += p.getQuantity();
		setTotalQuantity(tot);
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
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

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public Boolean getCanceled() {
		return canceled;
	}

	public void setSeller(Long seller) {
		this.seller = seller;
	}

	public Long getSeller() {
		return seller;
	}
}