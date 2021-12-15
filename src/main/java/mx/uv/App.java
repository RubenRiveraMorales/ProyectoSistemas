package mx.uv;

import static spark.Spark.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.MultipartConfigElement;

import com.google.gson.*;

import mx.uv.bd.DAO;
import mx.uv.bd.usuario;

public class App 
{

    //private static Gson gson = new Gson();
    private static Map<String, String> arregloEncuesta = new HashMap<>();

    public static void main( String[] args )
    {

        File uploadDir = new File("upload");
        uploadDir.mkdir();

        staticFiles.externalLocation("upload");

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

        //---------------------------------------------------------------------------------------

        post("/guardarVideo", (req, res) -> {

            DAO dao = new DAO();

            //String payload = req.body();

            Path tempFile = Files.createTempFile(uploadDir.toPath(), dao.consultarNumeroEncuestas()+1 + "-video-", ".mp4");

            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            try (InputStream input = req.raw().getPart("videoPregunta").getInputStream()) {

                Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);

            }

            return "Se guardo video";

        });

        //----------------------------------------------------------------------------------------

        post("/obtenerEncuesta", (req, res) -> {

            System.out.println("Entra al backend");

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            int noEncuesta = peticion.get("noEncuesta").getAsInt();

            DAO dao = new DAO();

            arregloEncuesta.put("nombreEncuesta", dao.filaEncuestas(noEncuesta).get("nombreEncuesta").toString());
            arregloEncuesta.put("preguntas", dao.filaEncuestas(noEncuesta).get("preguntas").toString());
            arregloEncuesta.put("resPreg1", dao.filaEncuestas(noEncuesta).get("resPreg1").toString());
            arregloEncuesta.put("resPreg2", dao.filaEncuestas(noEncuesta).get("resPreg2").toString());
            arregloEncuesta.put("resPreg3", dao.filaEncuestas(noEncuesta).get("resPreg3").toString());
            arregloEncuesta.put("resPreg4", dao.filaEncuestas(noEncuesta).get("resPreg4").toString());
            arregloEncuesta.put("resPreg5", dao.filaEncuestas(noEncuesta).get("resPreg5").toString());
            arregloEncuesta.put("resPreg6", dao.filaEncuestas(noEncuesta).get("resPreg6").toString());
            arregloEncuesta.put("resPreg7", dao.filaEncuestas(noEncuesta).get("resPreg7").toString());
            arregloEncuesta.put("resPreg8", dao.filaEncuestas(noEncuesta).get("resPreg8").toString());
            arregloEncuesta.put("resPreg9", dao.filaEncuestas(noEncuesta).get("resPreg9").toString());
            arregloEncuesta.put("resPreg10", dao.filaEncuestas(noEncuesta).get("resPreg10").toString());
            arregloEncuesta.put("resCorrectas", dao.filaEncuestas(noEncuesta).get("resCorrectas").toString());
            arregloEncuesta.put("nombreProfesor", dao.filaEncuestas(noEncuesta).get("nombreProfesor").toString());

            return arregloEncuesta;

        });

    }

}