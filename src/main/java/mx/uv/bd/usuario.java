package mx.uv.bd;

public class usuario {

    private String id;
    private String nombre;
    private String password;

    public usuario(String id, String nombre, String password) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPassword(password);
    }

    public usuario(String id) {
        this.setId(id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
