package aleatorio.encapsulado;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Aqu� se van a almacenar los datos de las personas
 * @author 
 *
 */
public class GestionaAgenda {
	
	private int dimensionNombre = 10;
	private int dimensionEmail = 30;
	// nombre de una persona ocupa 10 characteres --> 10 *2 = 20 bytes para almacenar el nombre 
	// 4 bytes para almacenar el entero de edad
	// el email del due�o de la persona ocupa 50 caracteres --> 30*2 = 60 bytes para almacenar el email
	// en total 20 + 4 + 60 = 84
	public final static int TAMAGNOREGISTRO = 84;


	private RandomAccessFile fichero;
	private String nomFichero;
	
	
	/**
	 * CONSTRUCTOR CON EL NOMBRE DEL FICHERO QUE UTILIZAREMOS
	 * @param fichero
	 */
	public GestionaAgenda(String nomfichero) {
		this.nomFichero = nomfichero;
	}

	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException
	 */
	public void abrir() throws FileNotFoundException {
	}
	
	/**
	 * Cerrar el fichero de las personas
	 * @throws IOException
	 */
	public void cerrar() throws IOException {
		
	}
	
	/**
	 * Escribir una persona en mi agenda en la posici�n indicada
	 * @param registro la persona que quiero escribir
	 * @param pos la posici�n donde quiero escribir
	 * @throws IOException
	 */
	public void escribir (Persona registro, int pos) throws IOException {
		


	/**
	 * Escribir una persona en la posici�n en la que actualmente est� el cursor 
	 * @param registro la persona que se quiere escribir en el fichero
	 * @throws IOException
	 */
	public void escribir (Persona registro) throws IOException {
		if (fichero != null) {

			// nombre de una persona ocupa 10 characteres --> 10 *2 = 20 bytes para almacenar el nombre 
			// 4 bytes para almacenar el entero de edad
			// el email del due�o de la persona ocupa 50 caracteres --> 30*2 = 60 bytes para almacenar el email 
			
			// PARA ESCRIBIR EL NOMBRE
			StringBuffer bufferN= new StringBuffer();
			if (registro.getNombre() != null) {
				bufferN.append(registro.getNombre());
			}
			bufferN.setLength(dimensionNombre);
			
		}
		
	}
	
	/**
	 * Leer del fichero un registro cualquiera, el par�metro indica la posici�n
	 * del registro
	 * @param pos
	 * @return
	 * @throws IOException
	 */
	public Persona leer (int pos) throws IOException {
		
		if (fichero != null) {
			fichero.seek(calculaposicion(pos));
		}
		
		return this.leer();
	}

	
	/**
	 * Leer del fichero la persona que se encuentra en la posici�n actual del cursor
	 * 
	 * @return la persona leida o null si ha llegado al final del fichero
	 */
	public Persona leer() {
		
		
	}
	
	/**
	 * Calcula la posici�n en la que tendr� que situarse el cursor
	 * dentro del fichero
	 * 
	 * @param pos -se considera que la primera posici�n es la 1 (no la 0)
	 * @return la posici�n
	 */
	private int calculaposicion(int pos) {
		
	}
	
	/**
	 * Posiciona el cursor al inico del fichero
	 * 
	 * @throws IOException
	 */
	public void iniciar() throws IOException  {			
			
	}
	
	
}
