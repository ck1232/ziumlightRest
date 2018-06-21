package com.ziumlight.to;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ForeignKey;

@Entity
@DynamicUpdate
@Table(name = "product_suboption")
public class ProductSubOptionTO extends BaseTO {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_suboption_id", nullable=false)
	private Integer productSuboptionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable=false)
	@ForeignKey( name = "none" )
    private ProductTO productTO;
	
	@Column(name = "name", nullable=false)
    private String name;

	@Column(name = "display_ind", nullable=false)
    private Character displayInd;
	
	@Column(name = "code", nullable=false)
    private String code;
    
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="product_option_id", nullable=true)
	@ForeignKey( name = "none" )
    private ProductOptionTO productOptionTO;

	public Integer getProductSuboptionId() {
		return productSuboptionId;
	}

	public void setProductSuboptionId(Integer productSuboptionId) {
		this.productSuboptionId = productSuboptionId;
	}

	public ProductTO getProductTO() {
		return productTO;
	}

	public void setProductTO(ProductTO productTO) {
		this.productTO = productTO;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ProductOptionTO getProductOptionTO() {
		return productOptionTO;
	}

	public void setProductOptionTO(ProductOptionTO productOptionTO) {
		this.productOptionTO = productOptionTO;
	}
}
