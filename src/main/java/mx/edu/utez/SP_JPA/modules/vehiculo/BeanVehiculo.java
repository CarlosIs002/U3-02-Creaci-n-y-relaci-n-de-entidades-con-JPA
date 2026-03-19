package mx.edu.utez.SP_JPA.modules.vehiculo;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cedi.BeanCedi;
import mx.edu.utez.SP_JPA.modules.cliente.BeanCliente;
import mx.edu.utez.SP_JPA.modules.verificacion.BeanVerificacion;

import java.util.List;

@Entity
@Table(name = "vehiculos")
public class BeanVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;
    
    @Column(length = 20, unique = true, nullable = false)
    private String placa;
    
    @Column(length = 50, unique = true, nullable = false)
    private String serie;
    
    @Column(length = 100)
    private String tipo;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private BeanCliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_cedis")
    private BeanCedi cedi;
    
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanVerificacion> verificaciones;
    
    // Getters y Setters
    public Integer getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(Integer idVehiculo) { this.idVehiculo = idVehiculo; }
    
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    
    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanCliente getCliente() { return cliente; }
    public void setCliente(BeanCliente cliente) { this.cliente = cliente; }
    
    public BeanCedi getCedi() { return cedi; }
    public void setCedi(BeanCedi cedi) { this.cedi = cedi; }
    
    public List<BeanVerificacion> getVerificaciones() { return verificaciones; }
    public void setVerificaciones(List<BeanVerificacion> verificaciones) { this.verificaciones = verificaciones; }
}

