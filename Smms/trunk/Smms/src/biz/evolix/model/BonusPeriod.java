package biz.evolix.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BONUSPERIOD")
public class BonusPeriod implements java.io.Serializable {
	
	private static final long serialVersionUID = -7521961542923752274L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BONUS_ID")
	private Long bonusId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID", nullable = false)
	private Users userId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private Date date;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;
	@Column(name = "BONUS_TEAMS")
	private Integer bonusTeam = 0;
	@Column(name = "BONUS_INV")
	private Integer bonusInv = 0;
	@Column(name = "BONUS")
	private Integer bonus = 0;

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Integer getBonusTeam() {
		return bonusTeam;
	}

	public void setBonusTeam(Integer bonusTeam) {
		this.bonusTeam = bonusTeam;
	}

	public Integer getBonusInv() {
		return bonusInv;
	}

	public void setBonusInv(Integer bonusInv) {
		this.bonusInv = bonusInv;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public Long getBonusId() {
		return bonusId;
	}

	public void setCommissions(Integer commissions) {
		this.commissions = commissions;
	}

	public Integer getCommissions() {
		return commissions;
	}
}
