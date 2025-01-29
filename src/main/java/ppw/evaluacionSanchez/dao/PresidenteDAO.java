package ppw.evaluacionSanchez.dao;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import ppw.evaluacionSanchez.model.Presidente;



@Stateless
public class PresidenteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void agregarPresidente(Presidente presidente) {
		em.persist(presidente);
	}
	

    public void actualizarPresidente(Presidente presidente) {
        em.merge(presidente);
    }


    public void eliminarPresidente(int id) {
        Presidente presidente = em.find(Presidente.class, id);
        if (presidente != null) {
            em.remove(presidente);
        }
    }
	
	public Presidente read(String cedula) {
		Presidente presidente = em.find(Presidente.class, cedula);
		return presidente;
	}        
	
	public List<Presidente> getPresidentes() {
        String jpql = "SELECT u FROM Presidente u";
        TypedQuery<Presidente> query = em.createQuery(jpql, Presidente.class);
        return query.getResultList();
	}
}
