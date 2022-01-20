package controlador;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.*;

public class ConsultaDatos {

	public static void main(String[] args) {
		
		ODB baseDatosOO = null;
		try {
			String nombreBD = "BDDeportes.test";
			String ruta = "src\\basedatos\\";
			baseDatosOO = ODBFactory.open(ruta + nombreBD);
			
			IQuery consulta = new CriteriaQuery(Jugador.class, Where.equal("deporte", "voleybol"));
			consulta.orderByAsc("edad");
			
			//mostrar los resultados de la consulta
			Objects<Jugador> jugadores = baseDatosOO.getObjects(consulta);
			
			for (Jugador jugador : jugadores) {
				System.out.println(jugador.getNombre());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
