package mx.edu.utez.SP_JPA.modules.nota;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cliente.BeanCliente;
import mx.edu.utez.SP_JPA.modules.pedido.BeanPedido;
import mx.edu.utez.SP_JPA.modules.transaccion.BeanTransaccion;
import mx.edu.utez.SP_JPA.modules.usuario.BeanUsuario;
import mx.edu.utez.SP_JPA.modules.verificacion.BeanVerificacion;
import mx.edu.utez.SP_JPA.modules.verificentro.BeanVerificentro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notas")
public class BeanNota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;
    
    @Column(length = 50, unique = true)
    private String folioNota;
    
    @Enumerated(EnumType.STRING)
    private ENUM_TIPO_PAGO tipoPago;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal anticipo;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean pagadoCompleto;
    
    @Column(length = 500)
    private String comentario;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private BeanCliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_verificentro")
    private BeanVerificentro verificentro;
    
    @ManyToOne
    @JoinColumn(name = "atendio")
    private BeanUsuario atendio;
    
    @ManyToOne
    @JoinColumn(name = "reviso")
    private BeanUsuario reviso;
    
    @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanVerificacion> verificaciones;
    
    @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanTransaccion> transacciones;
    
    @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanPedido> pedidos;
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Integer getIdNota() { return idNota; }
    public void setIdNota(Integer idNota) { this.idNota = idNota; }
    
    public String getFolioNota() { return folioNota; }
    public void setFolioNota(String folioNota) { this.folioNota = folioNota; }
    
    public ENUM_TIPO_PAGO getTipoPago() { return tipoPago; }
    public void setTipoPago(ENUM_TIPO_PAGO tipoPago) { this.tipoPago = tipoPago; }
    
    public BigDecimal getAnticipo() { return anticipo; }
    public void setAnticipo(BigDecimal anticipo) { this.anticipo = anticipo; }
    
    public Boolean getPagadoCompleto() { return pagadoCompleto; }
    public void setPagadoCompleto(Boolean pagadoCompleto) { this.pagadoCompleto = pagadoCompleto; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanCliente getCliente() { return cliente; }
    public void setCliente(BeanCliente cliente) { this.cliente = cliente; }
    
    public BeanVerificentro getVerificentro() { return verificentro; }
    public void setVerificentro(BeanVerificentro verificentro) { this.verificentro = verificentro; }
    
    public BeanUsuario getAtendio() { return atendio; }
    public void setAtendio(BeanUsuario atendio) { this.atendio = atendio; }
    
    public BeanUsuario getReviso() { return reviso; }
    public void setReviso(BeanUsuario reviso) { this.reviso = reviso; }
    
    public List<BeanVerificacion> getVerificaciones() { return verificaciones; }
    public void setVerificaciones(List<BeanVerificacion> verificaciones) { this.verificaciones = verificaciones; }
    
    public List<BeanTransaccion> getTransacciones() { return transacciones; }
    public void setTransacciones(List<BeanTransaccion> transacciones) { this.transacciones = transacciones; }
    
    public List<BeanPedido> getPedidos() { return pedidos; }
    public void setPedidos(List<BeanPedido> pedidos) { this.pedidos = pedidos; }
}

