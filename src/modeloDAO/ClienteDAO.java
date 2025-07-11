
package modeloDAO;

import java.sql.*;
import conectividad.Conexion;
import java.util.ArrayList;
import misInterfaces.ClienteInterface;
import modelo.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO implements ClienteInterface{
    
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Cliente c;
    ArrayList<Cliente> vc = new ArrayList<>();

    @Override
    public void insertar(Cliente c) {
        try {
            String sql = "insert into cliente(codcli, nomcli) values (?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String codigo) {
           try {
            String sql = "delete from cliente where codcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Cliente c) {
        try {
            String sql = "update cliente set nomcli = ? where codcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCodigo());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente listarUno(String codigo) {
       try {
            String sql = "select * from cliente where codcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                c.setCodigo(rs.getString("codcli"));
                c.setNombre(rs.getString("nomcli"));
            }
            conn.close();
        } catch (SQLException ex) {
            if (ex.getMessage().toLowerCase().contains("constraint")) {
                 JOptionPane.showMessageDialog(null, "Ese código ya está registrado.");
            }else{
                 Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        return c;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        vc = new ArrayList<>(); 
        try {
            String sql = "select * from cliente";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                c.setCodigo(rs.getString("codcli"));
                c.setNombre(rs.getString("nomcli"));
                vc.add(c);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vc;
    }
    
}
