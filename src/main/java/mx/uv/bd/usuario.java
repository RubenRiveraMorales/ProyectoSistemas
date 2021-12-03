package mx.uv.bd;

public class usuario {

    private String id;
    private String nombre;
    private String password;
    private String rol;

    public usuario(String id, String nombre, String password, String rol) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPassword(password);
        this.setRol(rol);
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
