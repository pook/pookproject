package com.smms.model;

import com.smms.model.Account;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DailyPerformance
 * 
 */
@Entity
@Table(name = "DAILY_PERFARMANCE")
public class DailyPerformance implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="DID")
	private Long did;
	@ManyToOne
	@JoinColumn(name = "ACC_ID", nullable = false)
	private Account accId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private Date date;
	@Column(name="ACCU_VALUE")
	private Integer accuValue;
	@Column(name="ACC_PV")
	private Integer accuPV;
	@Column(name="COMMISSION",precision=2)
	private Double commission;
	@Column(name="BONUS",precision=2)
	private Double bonus;
	private static final long serialVersionUID = 1L;

	public DailyPerformance() {
		super();
	}

	
	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Account getAccId() {
		return this.accId;
	}

	public void setAccId(Account accId) {
		this.accId = accId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAccuValue() {
		return this.accuValue;
	}

	public void setAccuValue(Integer accuValue) {
		this.accuValue = accuValue;
	}

	public Integer getAccuPV() {
		return this.accuPV;
	}

	public void setAccuPV(Integer accuPV) {
		this.accuPV = accuPV;
	}

	public Double getCommission() {
		return this.commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getBonus() {
		return this.bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

}
