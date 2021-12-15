package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DAO {

    private static Map<String, String> arregloEncuesta = new HashMap<>();
    
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
    
    public int consultarNumeroEncuestas () {

        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        int numEncuestas = 0;

        con = conexion.getConnection();

        try {
            
            String sql = "SELECT nombreEncuesta FROM encuestas";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while(rs.next()) {

                numEncuestas ++;

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

        return numEncuestas;

    }

    public Map filaEncuestas (int noEncuesta) {

        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;

        con = conexion.getConnection();

        try {
            
            String sql = "SELECT * FROM encuestas WHERE noEncuesta=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, noEncuesta);
            rs = stm.executeQuery();

            if(rs.next()) {

                arregloEncuesta.put("nombreEncuesta", rs.getString("nombreEncuesta"));
                arregloEncuesta.put("preguntas", rs.getString("preguntas"));
                arregloEncuesta.put("resPreg1", rs.getString("resPreg1"));
                arregloEncuesta.put("resPreg2", rs.getString("resPreg2"));
                arregloEncuesta.put("resPreg3", rs.getString("resPreg3"));
                arregloEncuesta.put("resPreg4", rs.getString("resPreg4"));
                arregloEncuesta.put("resPreg5", rs.getString("resPreg5"));
                arregloEncuesta.put("resPreg6", rs.getString("resPreg6"));
                arregloEncuesta.put("resPreg7", rs.getString("resPreg7"));
                arregloEncuesta.put("resPreg8", rs.getString("resPreg8"));
                arregloEncuesta.put("resPreg9", rs.getString("resPreg9"));
                arregloEncuesta.put("resPreg10", rs.getString("resPreg10"));
                arregloEncuesta.put("resCorrectas", rs.getString("resCorrectas"));
                arregloEncuesta.put("nombreProfesor", rs.getString("nombreProfesor"));

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

        return arregloEncuesta;

    }

}
