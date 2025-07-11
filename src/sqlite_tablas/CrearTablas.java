
package sqlite_tablas;

import conectividad.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CrearTablas {
    
    public static void main(String[] args) {
        Connection conn;
        Conexion con = new Conexion();
        try {
           
            conn = con.getConexion();  
            Statement st = conn.createStatement();
            String sql = "create table cliente (codcli text primary key,"
                    + "nomcli text)";
            
            st.execute(sql);            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
