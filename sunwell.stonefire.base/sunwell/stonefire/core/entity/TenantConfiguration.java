/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Users.java
 *
 * Created on Jul 17, 2017, 10:44:06 AM
 */

package sunwell.stonefire.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author Benny
 */
@Entity 
@Table(name = "tenantconfiguration")
@UuidGenerator(name="UUID")
@NamedQueries({
    @NamedQuery(name = "TenantConfiguration.findAll", query = "SELECT t FROM TenantConfiguration t")
    , @NamedQuery(name = "TenantConfiguration.findById", query = "SELECT t FROM TenantConfiguration t WHERE t.id = :id")
    , @NamedQuery(name = "TenantConfiguration.findByCurrency", query = "SELECT t FROM TenantConfiguration t WHERE t.currency = :currency")
    , @NamedQuery(name = "TenantConfiguration.findByParent", query = "SELECT t FROM TenantConfiguration t WHERE t.parent = :parent")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TenantConfiguration implements Serializable 
{
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="UUID")
    private String id;
    
    @ManyToOne
    @JoinColumn(name="parent")
    private Tenant parent;
    
    @Column(name="currency")
    private String currency;
    
    @Column(name="formatNoInvoice")
    private String formatNoInvoice;
    
    @Column(name="defaultmiscchargevalue")
    private Double defaultMiscChargeValue;
    
    @Column(name="defaultmiscchargetype")
    private Integer defaultMiscChargeType;
    
    @Column(name="defaultmiscchargememo")
    private String defaultMiscChargeMemo;
    
    @Column(name="vatinclusive")
    private Boolean vatInclusive;
    
    @Column(name="defaultvatvalue")
    private Double defaultVatValue;

    /**
     * @return the id
     */
    public String getId ()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId (String id)
    {
        this.id = id;
    }

    /**
     * @return the parent
     */
    public Tenant getParent ()
    {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent (Tenant parent)
    {
        this.parent = parent;
    }

    /**
     * @return the currency
     */
    public String getCurrency ()
    {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    /**
     * @return the formatNoInvoice
     */
    public String getFormatNoInvoice ()
    {
        return formatNoInvoice;
    }

    /**
     * @param formatNoInvoice the formatNoInvoice to set
     */
    public void setFormatNoInvoice (String formatNoInvoice)
    {
        this.formatNoInvoice = formatNoInvoice;
    }

    /**
     * @return the defaultMiscChargeValue
     */
    public Double getDefaultMiscChargeValue ()
    {
        return defaultMiscChargeValue;
    }

    /**
     * @param defaultMiscChargeValue the defaultMiscChargeValue to set
     */
    public void setDefaultMiscChargeValue (Double defaultMiscChargeValue)
    {
        this.defaultMiscChargeValue = defaultMiscChargeValue;
    }

    /**
     * @return the defaultMiscChargeType
     */
    public Integer getDefaultMiscChargeType ()
    {
        return defaultMiscChargeType;
    }

    /**
     * @param defaultMiscChargeType the defaultMiscChargeType to set
     */
    public void setDefaultMiscChargeType (Integer defaultMiscChargeType)
    {
        this.defaultMiscChargeType = defaultMiscChargeType;
    }

    /**
     * @return the defaultMiscChargeMemo
     */
    public String getDefaultMiscChargeMemo ()
    {
        return defaultMiscChargeMemo;
    }

    /**
     * @param defaultMiscChargeMemo the defaultMiscChargeMemo to set
     */
    public void setDefaultMiscChargeMemo (String defaultMiscChargeMemo)
    {
        this.defaultMiscChargeMemo = defaultMiscChargeMemo;
    }

    /**
     * @return the vatInclusive
     */
    public Boolean getVatInclusive ()
    {
        return vatInclusive;
    }

    /**
     * @param vatInclusive the vatInclusive to set
     */
    public void setVatInclusive (Boolean vatInclusive)
    {
        this.vatInclusive = vatInclusive;
    }

    /**
     * @return the defaultVatValue
     */
    public Double getDefaultVatValue ()
    {
        return defaultVatValue;
    }

    /**
     * @param defaultVatValue the defaultVatValue to set
     */
    public void setDefaultVatValue (Double defaultVatValue)
    {
        this.defaultVatValue = defaultVatValue;
    }
    private static final long serialVersionUID = 1L;
    
    
}
