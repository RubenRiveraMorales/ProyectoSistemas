package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

import mx.uv.bd.DAO;
import mx.uv.bd.usuario;

public class App 
{
    public static void main( String[] args )
    {

        staticFiles.location("/");

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        //System.out.println( "Holaaaaaa" );

        post("/logearUsuario", (req, res) -> {

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            String usuario = peticion.get("usuario").getAsString();
            String contraseña = peticion.get("contraseña").getAsString();

            

            return "";

        });

        post("/registrarUsuario", (req, res) -> { 

            DAO dao = new DAO();
            usuario u = new usuario("123");

            return dao.crearAlumno(u);

        });

    }

}