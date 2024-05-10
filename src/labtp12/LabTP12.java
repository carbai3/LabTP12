/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtp12;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carba
 */
public class LabTP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            String bd = "jdbc:mysql://localhost/construirsa";
            String usuario = "root";
            String password = "";
            Connection con = DriverManager.getConnection(bd, usuario, password);
            String sql = "INSERT INTO "
                    + "empleado( dni, apellido, nombre, acceso, estado)"
                    + "VALUES (23567823,'Lopez','Juan',1,1),"
                    + "(23774323,'Suarez','Mario',1,1),"
                    + "(23534323,'Sosa','Miguel',1,1)";
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Empleado Agregado");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error carga Driver");
        } catch (SQLException ex) {
            int codigoE = ex.getErrorCode();
            if (codigoE == 1062) {
                JOptionPane.showMessageDialog(null, "Entrada duplicada");
            }
            JOptionPane.showMessageDialog(null, "Error de Conexion");
            ex.printStackTrace();
            System.out.println("codigo de error" + ex.getErrorCode());
        }
    }
}
