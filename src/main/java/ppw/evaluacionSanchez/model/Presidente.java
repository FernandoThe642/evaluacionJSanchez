package ppw.evaluacionSanchez.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="TBL_PRESIDENTE")
public class Presidente {
	
	@Id
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;	
	
	@Column(name = "telefono")
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cedula_cliente")
    private List<Vicepresidente> vicepresidentes;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vicepresidente> getVicepresidentes() {
		return vicepresidentes;
	}

	public void setVicepresidentes(List<Vicepresidente> vicepresidentes) {
		this.vicepresidentes = vicepresidentes;
	}

	@Override
	public String toString() {
		return "Presidente [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", vicepresidentes=" + vicepresidentes + "]";
	}

	public void addVicepresidente(Vicepresidente vicepresidente) {
		if(this.vicepresidentes == null) {
			this.vicepresidentes = new ArrayList<>();
		}
		this.vicepresidentes.add(vicepresidente);
	}
	
	
	

}
