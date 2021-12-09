package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    
    private conexion conexion = new conexion();

    public String crearAlumno (usuario u) {

        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try {
            
            String sql = "INSERT INTO alumno (id, nombre, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if( stm.executeUpdate()>0 ){
                
                msj = "Si se pudo crear alumno";

            } else {

                msj = "No se pudo crear alumno";

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if( stm != null ) {

                try {

                    stm.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();
                
            }

        }

        return msj;
    }

    public String crearProfesor (usuario u) {

        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try {
            
            String sql = "INSERT INTO profesor (id, nombre, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if( stm.executeUpdate()>0 ){
                
                msj = "Si se pudo crear profesor";

            } else {

                msj = "No se pudo crear profesor";

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if( stm != null ) {

                try {

                    stm.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();
                
            }

        }

        return msj;
    }

    public int logearUsuario (String nombre, String password) {

        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        int numero = 0;

        con = conexion.getConnection();

        // Arreglar todo con las nuevas instrucciones con where

        try {
            
            String sql = "SELECT nombre, password FROM alumno WHERE nombre=? and password=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, nombre);
            stm.setString(2, password);
            rs = stm.executeQuery();

            if(rs.next()) {

                numero = 1;

            } else {

                stm.close();
                sql = "SELECT nombre, password FROM profesor WHERE nombre=? and password=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, nombre);
                stm.setString(2, password);
                rs = stm.executeQuery();

                if(rs.next()) {

                    numero = 2;

                } else {

                    numero = 0;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if( stm != null ) {

                try {

                    stm.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();
                
            }

        }

        return numero;

    }
    
}
