package biz.evolix.model;

import biz.evolix.model.Authorities;
import biz.evolix.model.Brance;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Staffs
 *
 */
@Entity
@Table(name = "STAFFS")
@DiscriminatorValue("S")

public class Staffs extends Authorities implements Serializable {

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BRANCE_CODE")
	private Brance brance;
	private static final long serialVersionUID = 1L;

	public Staffs() {
		super();
	}   
	public Brance getBrance() {
		return this.brance;
	}

	public void setBrance(Brance brance) {
		this.brance = brance;
	}	   
}
