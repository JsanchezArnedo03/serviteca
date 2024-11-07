package com.sanchez.serviteca.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reserva")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaReservar", query = "SELECT r FROM Reserva r WHERE r.fechaReservar = :fechaReservar")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Basic(optional = false)
    @Column(name = "fecha_reservar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReservar;
    @JoinColumn(name = "estado_reservacion", referencedColumnName = "id_estados_reserva")
    @ManyToOne
    private EstadosReserva estadoReservacion;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private Persona cliente;
    @JoinColumn(name = "servicio", referencedColumnName = "id_servicios")
    @ManyToOne
    private Servicio servicio;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, Date fechaReservar) {
        this.idReserva = idReserva;
        this.fechaReservar = fechaReservar;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReservar() {
        return fechaReservar;
    }

    public void setFechaReservar(Date fechaReservar) {
        this.fechaReservar = fechaReservar;
    }

    public EstadosReserva getEstadoReservacion() {
        return estadoReservacion;
    }

    public void setEstadoReservacion(EstadosReserva estadoReservacion) {
        this.estadoReservacion = estadoReservacion;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.icfe.parametrizacion_reglas_cobros.ihgjh.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
