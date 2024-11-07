package com.sanchez.serviteca.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estados_reserva")
@NamedQueries({
    @NamedQuery(name = "EstadosReserva.findAll", query = "SELECT e FROM EstadosReserva e"),
    @NamedQuery(name = "EstadosReserva.findByIdEstadosReserva", query = "SELECT e FROM EstadosReserva e WHERE e.idEstadosReserva = :idEstadosReserva"),
    @NamedQuery(name = "EstadosReserva.findByEstado", query = "SELECT e FROM EstadosReserva e WHERE e.estado = :estado")})
public class EstadosReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estados_reserva")
    private Integer idEstadosReserva;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;


    public EstadosReserva() {
    }

    public EstadosReserva(Integer idEstadosReserva) {
        this.idEstadosReserva = idEstadosReserva;
    }

    public EstadosReserva(Integer idEstadosReserva, String estado) {
        this.idEstadosReserva = idEstadosReserva;
        this.estado = estado;
    }

    public Integer getIdEstadosReserva() {
        return idEstadosReserva;
    }

    public void setIdEstadosReserva(Integer idEstadosReserva) {
        this.idEstadosReserva = idEstadosReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosReserva != null ? idEstadosReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosReserva)) {
            return false;
        }
        EstadosReserva other = (EstadosReserva) object;
        if ((this.idEstadosReserva == null && other.idEstadosReserva != null) || (this.idEstadosReserva != null && !this.idEstadosReserva.equals(other.idEstadosReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.icfe.parametrizacion_reglas_cobros.ihgjh.EstadosReserva[ idEstadosReserva=" + idEstadosReserva + " ]";
    }
    
}
