package mx.uv;

import static spark.Spark.*;
import java.util.UUID;
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

        //---------------------------------------------------------------------------------------

        post("/logearUsuario", (req, res) -> {

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            String usuario = peticion.get("usuario").getAsString();
            String contraseña = peticion.get("contraseña").getAsString();

            DAO dao = new DAO();

            JsonObject objectJson = new JsonObject();
            objectJson.addProperty("usuario", usuario);

            if(dao.logearUsuario(usuario, contraseña) == 1) {

                objectJson.addProperty("redirect", 1);

            } else {

                if(dao.logearUsuario(usuario, contraseña) == 2) {

                    objectJson.addProperty("redirect", 2);

                } else {

                    objectJson.addProperty("redirect", 0);

                }

            }
            

            return objectJson;

        });

        //----------------------------------------------------------------------------------------

        post("/registrarUsuario", (req, res) -> { 

            String id = UUID.randomUUID().toString();
            usuario u = new usuario(id);

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            u.setNombre(peticion.get("usuario").getAsString());
            u.setPassword(peticion.get("contraseña").getAsString());
            u.setRol(peticion.get("rol").getAsString());
            
            DAO dao = new DAO();

            JsonObject objectJson = new JsonObject();

            if(u.getRol().equals("profesor")) {

                objectJson.addProperty("status", dao.crearProfesor(u));

            }

            if(u.getRol().equals("alumno")) {

                objectJson.addProperty("status", dao.crearAlumno(u));

            }

            objectJson.addProperty("nombre", u.getNombre());

            return objectJson;

        });

        //---------------------------------------------------------------------------------------

        post("/consultarEncuestas", (req, res) -> {

            

            return "";

        });

    }

}