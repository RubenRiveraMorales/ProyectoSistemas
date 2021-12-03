package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

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

        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        int numero = 0;

        con = conexion.getConnection();

        try {
            
            String sql = "SELECT nombre FROM alumno";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            if(rs.wasNull()) {

                stm.close();
                sql = "SELECT nombre FROM profesor";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                if(rs.wasNull()) {

                    numero = 0;

                } else {

                    stm.close();
                    rs.close();
                    sql = "SELECT password FROM profesor";
                    stm = con.createStatement();
                    rs = stm.executeQuery(sql);

                    if(rs.wasNull()) {

                        numero = 0;

                    } else {

                        numero = 1;

                    }

                }

            } else {

                stm.close();
                rs.close();
                sql = "SELECT password FROM alumno";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                if(rs.wasNull()) {

                    numero = 0;

                } else {

                    numero = 1;

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
