/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyectos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findById", query = "SELECT p FROM Proyecto p WHERE p.id = :id"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByLocalidad", query = "SELECT p FROM Proyecto p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyecto.findByProsupuesto", query = "SELECT p FROM Proyecto p WHERE p.prosupuesto = :prosupuesto"),
    @NamedQuery(name = "Proyecto.findByHabitantes", query = "SELECT p FROM Proyecto p WHERE p.habitantes = :habitantes")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 15)
    @Column(name = "LOCALIDAD")
    private String localidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROSUPUESTO")
    private Double prosupuesto;
    @Column(name = "HABITANTES")
    private Integer habitantes;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String localidad, Double prosupuesto, Integer habitantes) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.prosupuesto = prosupuesto;
        this.habitantes = habitantes;
    }
    
    
    public Proyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Double getProsupuesto() {
        return prosupuesto;
    }

    public void setProsupuesto(Double prosupuesto) {
        this.prosupuesto = prosupuesto;
    }

    public Integer getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Integer habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.proyectos.entity.Proyecto[ id=" + id + " ]";
    }
    
}
