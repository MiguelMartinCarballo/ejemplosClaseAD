package aleatorio.ejercicios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que gestiona un conjunto de departamentos en un fichero
 * de acceso aleatorio o directo
 * @author Eva Royo
 *
 */
public class ConjuntoDepartamentos {

	private static int TAMAGNONOMBRE = 32; // son los car�cteres 32*2 = 64 bytes
	private static int TAMAGNOLOCALIDAD = 20; // son los car�cteres 20*2 = 40 bytes
	// para almacenar el n�mero de departamento usamos un entero = 4 bytes
	private static int TAMAGNOREGISTO = TAMAGNONOMBRE*4 + TAMAGNOLOCALIDAD*4 + 4; // son los bytes 64 + 40 + 4(int)
	
	private String nombreFichero = "departamentos.dat";
	private RandomAccessFile fichero ;

	/* ***** CONSTRUCTORES *****/
	/**
	 * Constructor
	 * @param nombreFichero	Nombre del fichero que contendr� los departamentos
	 */
	public ConjuntoDepartamentos(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/* *************************/
	

	/**
	 * Devuelve el nombre del fichero con el que estamos a trabajando
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}


	/**
	 * Cambia el nombre del fichero con el que estamos trabajando, as� que
	 * TIENE QUE CERRAR EL FICHERO QUE TEN�A ACTIVO ANTERIORMENTE
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		if (fichero != null)
			try {
				fichero.close();
			} catch (IOException e) {
				System.err.println("Error cuando cierro el fichero anterior, al cambiar de fichero");
				e.printStackTrace();
			}
		this.nombreFichero = nombreFichero;
	}


	/**
	 * A�ade un departamente en la posici�n indicada
	 * @param dep	El departamento que va a incluir en la posicion pos
	 * @param pos	La posici�n dentro del fichero
	 * @throws IOException	Excepci�n producida al intentar escribir en el fichero
	 */
	public void agnadir(Departamento dep, int pos) throws IOException {
		
		// comprobaciones de error
		if (fichero != null) {
			// posicionar el cursor en el lugar adecuado
			fichero.seek(calculaPosicion(pos));
			
			// PARA ESCRIBIR UNA CADENA
			// primero escribo las cosas en un buffer
			StringBuffer bufferNombre= new StringBuffer();
			if (dep.getNombre() != null ) {
				bufferNombre.append(dep.getNombre());
			}
			bufferNombre.setLength(TAMAGNONOMBRE); // fijo un tama�o al buffer, para que todos los nombres tengan el mismo tama�o
			
			StringBuffer bufferLocalidad= new StringBuffer();
			if (dep.getLocalidad() != null ) {
				bufferLocalidad.append(dep.getLocalidad());
			}
			bufferLocalidad.setLength(TAMAGNOLOCALIDAD);

			// escribir el identificador
			fichero.writeInt(dep.getNumDepartamento());
			// escribir el nombre
			fichero.writeChars(bufferNombre.toString());
			// escribir el localidad
			fichero.writeChars(bufferLocalidad.toString());
		}

		
	}

	/**
	 * Lee el departamento que est� en la posici�n indicada
	 * @param pos Posici�n en la que se encuentra el departamento que quiere leerse
	 * @return	El departamento leido o @NULL si el fichero no est� abierto
	 * @throws IOException	Si se podruce alg�n error de entrada/salida al leer
	 */
	public Departamento leer(int pos) throws IOException {
			
		Departamento dep = null;
		
		if (fichero != null) {
			dep = new Departamento();
			
			// situar el cursor donde quiero leer
			fichero.seek(calculaPosicion(pos));
			
			try {
				// ya s� que el departamento tiene 3 campos y SU ORDEN
				
				// leer el identificador (numDepartamento)
				int numDepartamento = fichero.readInt();
						
				// leo car�cter a car�cter el nombre
				char campoNombre[] = new char[TAMAGNONOMBRE];
				for (int i = 0; i < TAMAGNONOMBRE; i++) {
					campoNombre[i] = fichero.readChar();
				}			
				
				// leo car�cter a car�cter la localidad
				char campoLocalidad[] = new char[TAMAGNOLOCALIDAD];
				for (int i = 0; i < TAMAGNOLOCALIDAD; i++) {
					campoLocalidad[i] = fichero.readChar();
				}			
				
				dep.setNumDepartamento(numDepartamento);		
				dep.setNombre(new String(campoNombre));
				dep.setLocalidad(new String(campoLocalidad));				
				
			} catch (EOFException e) {
				// entrar� aqu� cuando haya llegado al final del fichero
				dep = null;
			}
		}
				
		return dep;
	}

	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException	Lanza la excepci�n al intentar abrir en lectura/escritura
	 */
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nombreFichero, "rw");
	}
	
	/**
	 * Cerrar el fichero de los contactos
	 * @throws IOException	Lanza excepci�n al intentar cerrar el fichero
	 */
	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	/**
	 * Calcula el byte en el que tiene que situarse seg�n la posici�n deseada
	 * @param pos Posici�n dentro del fichero
	 * @return El byte en el que ha de situarse el fichero
	 */
	public int calculaPosicion(int pos) {
		return (pos-1)*TAMAGNOREGISTO;
	}

}
