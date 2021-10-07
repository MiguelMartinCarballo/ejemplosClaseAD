package aleatorio.encapsulado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
			
		GestionaAgenda agenda = new GestionaAgenda("AgendaPersonas.dat");
		
				
		//  guarda las personas en el fichero secuencial
		// la primera persona estará en la posición 1, la segunda en la posición 2
		// y así sucesivamente....
		try {
			agenda.abrir();
			
			// escribir las personas
				
			
		} // COMPLETA CON LOS CATCH QUE HAGAN FALTA  
		catch (FileNotFoundException e) {
			System.out.println("Error, fichero no econtrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error, de escritura");
			e.printStackTrace();
		}
		
		// leer las personas
		try {
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
}
