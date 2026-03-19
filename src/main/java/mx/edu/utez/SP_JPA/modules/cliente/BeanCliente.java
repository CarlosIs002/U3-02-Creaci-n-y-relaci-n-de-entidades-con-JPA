package mx.edu.utez.SP_JPA.modules.cliente;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cedi.BeanCedi;
import mx.edu.utez.SP_JPA.modules.costo.BeanCosto;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;
import mx.edu.utez.SP_JPA.modules.vehiculo.BeanVehiculo;

import java.util.List;

@Entity
@Table(name = "clientes")
public class BeanCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    
    @Column(nullable = false, length = 150)
    private String razonSocial;
    
    @Column(length = 100)
    private String email;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 20)
    private String telefonoAlternativo;
    
    @Column(length = 100)
    private String gestor;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanCedi> cedis;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanVehiculo> vehiculos;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanNota> notas;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanCosto> costos;
    
    // Getters y Setters
    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
    
    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getTelefonoAlternativo() { return telefonoAlternativo; }
    public void setTelefonoAlternativo(String telefonoAlternativo) { this.telefonoAlternativo = telefonoAlternativo; }
    
    public String getGestor() { return gestor; }
    public void setGestor(String gestor) { this.gestor = gestor; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public List<BeanCedi> getCedis() { return cedis; }
    public void setCedis(List<BeanCedi> cedis) { this.cedis = cedis; }
    
    public List<BeanVehiculo> getVehiculos() { return vehiculos; }
    public void setVehiculos(List<BeanVehiculo> vehiculos) { this.vehiculos = vehiculos; }
    
    public List<BeanNota> getNotas() { return notas; }
    public void setNotas(List<BeanNota> notas) { this.notas = notas; }
    
    public List<BeanCosto> getCostos() { return costos; }
    public void setCostos(List<BeanCosto> costos) { this.costos = costos; }
}

