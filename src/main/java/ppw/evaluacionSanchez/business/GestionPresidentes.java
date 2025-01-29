package ppw.evaluacionSanchez.business;

import ppw.evaluacionSanchez.dao.PresidenteDAO;
import ppw.evaluacionSanchez.model.Presidente;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionPresidentes {
	
	
	@Inject PresidenteDAO presidenteDAO;
	
    public void agregarPresidente(Presidente presidente) throws Exception {
        if (presidente == null) {
            throw new Exception("El presidente no puede ser nulo");
        }
        presidenteDAO.agregarPresidente(presidente);
    }

	
	public Presidente getPresidente(String cedula) throws Exception {
		if(cedula.length() != 10) {
			throw new Exception("Cedula incorrecta");
		}
		Presidente presidente = presidenteDAO.read(cedula);
		if(presidente == null)
			throw new Exception("Presidente no existe");
		return presidente;
	}
	
	
	public List<Presidente> getAll(){
		return presidenteDAO.getPresidentes();
	}

}
