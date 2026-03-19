package mx.edu.utez.SP_JPA.modules.costo;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cliente.BeanCliente;
import mx.edu.utez.SP_JPA.modules.usuario.BeanUsuario;

import java.math.BigDecimal;

@Entity
@Table(name = "costos")
public class BeanCosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCosto;
    
    @Enumerated(EnumType.STRING)
    private ENUM_MATERIA materia;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal costo;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private BeanCliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_encargado")
    private BeanUsuario encargado;
    
    @ManyToOne
    @JoinColumn(name = "id_atencion_cobro")
    private BeanUsuario atencionCobro;
    
    // Getters y Setters
    public Integer getIdCosto() { return idCosto; }
    public void setIdCosto(Integer idCosto) { this.idCosto = idCosto; }
    
    public ENUM_MATERIA getMateria() { return materia; }
    public void setMateria(ENUM_MATERIA materia) { this.materia = materia; }
    
    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanCliente getCliente() { return cliente; }
    public void setCliente(BeanCliente cliente) { this.cliente = cliente; }
    
    public BeanUsuario getEncargado() { return encargado; }
    public void setEncargado(BeanUsuario encargado) { this.encargado = encargado; }
    
    public BeanUsuario getAtencionCobro() { return atencionCobro; }
    public void setAtencionCobro(BeanUsuario atencionCobro) { this.atencionCobro = atencionCobro; }
}

