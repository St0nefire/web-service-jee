/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Migrations.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */

package sunwell.stonefire.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Benny
 */
@Entity 
@Table(name = "migration")
@NamedQueries({
    @NamedQuery(name = "Migration.findAll", query = "SELECT m FROM Migration m")
    , @NamedQuery(name = "Migration.findById", query = "SELECT m FROM Migration m WHERE m.id = :id")
    , @NamedQuery(name = "Migration.findByMigration", query = "SELECT m FROM Migration m WHERE m.migration = :migration")
    , @NamedQuery(name = "Migration.findByBatch", query = "SELECT m FROM Migration m WHERE m.batch = :batch")})
public class Migration implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "migration")
    private String migration;
    @Basic(optional = false)
    @Column(name = "batch")
    private int batch;

    public Migration ()
    {
    }

    public Migration (Integer id)
    {
        this.id = id;
    }

    public Migration (Integer id, String migration, int batch)
    {
        this.id = id;
        this.migration = migration;
        this.batch = batch;
    }

    public Integer getId ()
    {
        return id;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getMigration ()
    {
        return migration;
    }

    public void setMigration (String migration)
    {
        this.migration = migration;
    }

    public int getBatch ()
    {
        return batch;
    }

    public void setBatch (int batch)
    {
        this.batch = batch;
    }

    @Override
    public int hashCode ()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode () : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Migration)) {
            return false;
        }
        Migration other = (Migration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.Migrations[ id=" + id + " ]";
    }

}
