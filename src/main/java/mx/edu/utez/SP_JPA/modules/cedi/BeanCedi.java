package mx.edu.utez.SP_JPA.modules.cedi;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cliente.BeanCliente;
import mx.edu.utez.SP_JPA.modules.region.BeanRegion;
import mx.edu.utez.SP_JPA.modules.vehiculo.BeanVehiculo;

import java.util.List;

@Entity
@Table(name = "cedis")
public class BeanCedi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCedis;
    
    @Column(length = 100)
    private String nombre;
    
    @Column(length = 255)
    private String direccion;
    
    @Column(length = 100)
    private String encargado;
    
    @Column(length = 100)
    private String correo;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 20)
    private String telAlternativo;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private BeanCliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_region")
    private BeanRegion region;
    
    @OneToMany(mappedBy = "cedi", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanVehiculo> vehiculos;
    
    // Getters y Setters
    public Integer getIdCedis() { return idCedis; }
    public void setIdCedis(Integer idCedis) { this.idCedis = idCedis; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getEncargado() { return encargado; }
    public void setEncargado(String encargado) { this.encargado = encargado; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getTelAlternativo() { return telAlternativo; }
    public void setTelAlternativo(String telAlternativo) { this.telAlternativo = telAlternativo; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanCliente getCliente() { return cliente; }
    public void setCliente(BeanCliente cliente) { this.cliente = cliente; }
    
    public BeanRegion getRegion() { return region; }
    public void setRegion(BeanRegion region) { this.region = region; }
    
    public List<BeanVehiculo> getVehiculos() { return vehiculos; }
    public void setVehiculos(List<BeanVehiculo> vehiculos) { this.vehiculos = vehiculos; }
}

