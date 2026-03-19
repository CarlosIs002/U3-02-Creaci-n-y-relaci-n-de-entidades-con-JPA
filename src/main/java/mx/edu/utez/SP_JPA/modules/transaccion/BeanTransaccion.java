package mx.edu.utez.SP_JPA.modules.transaccion;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;
import mx.edu.utez.SP_JPA.modules.usuario.BeanUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transacciones")
public class BeanTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;
    
    @Column(length = 20)
    private String tipoPago;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal monto;
    
    @Column(length = 100)
    private String cuentaDeposito;
    
    @Column(length = 100)
    private String numeroFactura;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean pagado;
    
    private LocalDate fechaPedido;
    
    @Column(length = 100)
    private String cotizacion;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean pendiente;
    
    @Column(length = 500)
    private String comentario;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_nota")
    private BeanNota nota;
    
    @ManyToOne
    @JoinColumn(name = "id_reviso")
    private BeanUsuario revisoTransaccion;
    
    @ManyToOne
    @JoinColumn(name = "id_atendio")
    private BeanUsuario atendioTransaccion;
    
    // Getters y Setters
    public Integer getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(Integer idTransaccion) { this.idTransaccion = idTransaccion; }
    
    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
    
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    
    public String getCuentaDeposito() { return cuentaDeposito; }
    public void setCuentaDeposito(String cuentaDeposito) { this.cuentaDeposito = cuentaDeposito; }
    
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    
    public Boolean getPagado() { return pagado; }
    public void setPagado(Boolean pagado) { this.pagado = pagado; }
    
    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }
    
    public String getCotizacion() { return cotizacion; }
    public void setCotizacion(String cotizacion) { this.cotizacion = cotizacion; }
    
    public Boolean getPendiente() { return pendiente; }
    public void setPendiente(Boolean pendiente) { this.pendiente = pendiente; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanNota getNota() { return nota; }
    public void setNota(BeanNota nota) { this.nota = nota; }
    
    public BeanUsuario getRevisoTransaccion() { return revisoTransaccion; }
    public void setRevisoTransaccion(BeanUsuario revisoTransaccion) { this.revisoTransaccion = revisoTransaccion; }
    
    public BeanUsuario getAtendioTransaccion() { return atendioTransaccion; }
    public void setAtendioTransaccion(BeanUsuario atendioTransaccion) { this.atendioTransaccion = atendioTransaccion; }
}

