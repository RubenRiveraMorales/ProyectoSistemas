package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    
    private conexion conexion = new conexion();

    public String crearAlumno (usuario u) {

        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try {
            
            msj = "Si se pudo";

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

}
