package Modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCliente")
	private int IDCliente;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Apellido")
	private String Apellido;
	
	@Column(name = "Email")
	private String Email;
	
	@OneToMany(mappedBy = "IDCliente", cascade = CascadeType.ALL)
    private List<Cliente> cliente = new ArrayList<>();
	
	public Cliente() {
    }

    // Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad espec�ficos
    public Cliente(String Nombre, String Apellido, String Email) {
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.Email=Email;      
    }

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		this.IDCliente = iDCliente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
	
	@Override
	public String toString() {
		return "Cliente{"+
				"IDCliente="+IDCliente+
				", Nombre='"+Nombre+
				", Apellido="+Apellido+
				", Email="+Email+'\''+
				'}'; 
	}
    
    
	
}
