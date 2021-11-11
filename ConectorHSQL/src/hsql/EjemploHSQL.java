package hsql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class EjemploHSQL {
    public static void main(String[] args) {
        try {
        	// CARGAR EL CONTROLADOR JDBC de la base de datos
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
					//+ "org.hsqldb.jdbcDriver");
        	
        	// ESTABLECER LA CONEXIÓN con la base de datos que tiene usuario y contraseña
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:src\\datos\\biblioteca", "alumno", "alumno");
            // parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            // parametro 2 = nombre del usuario
            // parametro 3 = contraseña del usuario
            
            
            // PREPARAMOS LA SENTENCIA SQL
            Statement sentencia = (Statement) conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM \"libro\""); // cuidado con las comillas que exige HSQLDB
            
            // recorro el resultado
            while (resultado.next()) {
            	System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2));
            }
            
            // LIBRERAR LOS RECURSOS
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
            ex.printStackTrace();
        }
    }
}