package dao;

import java.util.List;

import model.Vuelo;

public interface VuelosDao {
	
	public List<Vuelo> devolverVuelos ();
	
	public void guardarVueloDAO(Vuelo vuelo);
	
	public Vuelo obtenerVueloporIdDAO(Integer id);

}
