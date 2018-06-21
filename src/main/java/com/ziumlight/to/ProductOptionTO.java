package com.ziumlight.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
@Entity
@DynamicUpdate
@Table(name = "product_option")
public class ProductOptionTO extends BaseTO {

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_option_id", nullable=false)
	private Integer productOptionId;

	@Column(name = "name", nullable=false)
    private String name;
	
	@Column(name = "display_ind", nullable=false)
    private Character displayInd;

	public Integer getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(Integer productOptionId) {
		this.productOptionId = productOptionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getDisplayInd() {
		return displayInd;
	}

	public void setDisplayInd(Character displayInd) {
		this.displayInd = displayInd;
	}
}
