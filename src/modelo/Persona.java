
package modelo;

public class Persona {
    private String idpersonas;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha_nacimiento;

    public Persona() {
    }

    public Persona(String idpersonas, String nombre, String apellido, String dni, String fecha_nacimiento) {
        this.idpersonas = idpersonas;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getIdpersonas() {
        return idpersonas;
    }

    public void setIdpersonas(String idpersonas) {
        this.idpersonas = idpersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
