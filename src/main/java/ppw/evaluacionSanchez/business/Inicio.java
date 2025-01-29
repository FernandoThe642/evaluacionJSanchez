package ppw.evaluacionSanchez.business;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;


import java.util.List;


import jakarta.inject.Inject;
import ppw.evaluacionSanchez.dao.PresidenteDAO;
import ppw.evaluacionSanchez.model.*;



@Singleton
@Startup
public class Inicio {
	@Inject
	private PresidenteDAO presidenteDAO;
	
	@PostConstruct
	public void init() {
		
		// Presidentes
		 Presidente presidente1 = new Presidente();
	        presidente1.setCedula("1104567890");
	        presidente1.setNombre("Carlos Alvarado");
	        presidente1.setDireccion("Av. de las Américas");
	        presidente1.setTelefono("0991234567");
	        
	        
	      Presidente presidente2 = new Presidente();
	        presidente2.setCedula("1709856321");
	        presidente2.setNombre("Juan Cueva");
	        presidente2.setDireccion("Calle Larga");
	        presidente2.setTelefono("0987654321");
	        
	        // Vicepresidentes
	        Vicepresidente vicepresidente1 = new Vicepresidente();
	        vicepresidente1.setCedula("01568796346");
	        vicepresidente1.setNombre("Pedro");
	        vicepresidente1.setDireccion("Américas");
	        vicepresidente1.setTelefono("09987965342");
	        presidente1.addVicepresidente(vicepresidente1);
	        
	        Vicepresidente vicepresidente2 = new Vicepresidente();
	        vicepresidente2.setCedula("1456349863");
	        vicepresidente2.setNombre("Teodoro Torres");
	        vicepresidente2.setDireccion("Solano");
	        vicepresidente2.setTelefono("0998634567");
	        presidente2.addVicepresidente(vicepresidente2);
	        

	        //Agregar presidentes
	        presidenteDAO.agregarPresidente(presidente1);
	        presidenteDAO.agregarPresidente(presidente2);
	        
	        System.out.println("----------------Presidentes----------------------");
	        List<Presidente> listado = presidenteDAO.getPresidentes();
	        
	        for (Presidente usr : listado) {
	            System.out.println(usr.toString());
	        }
	}
}
