
package vistacontrol;

import java.util.ArrayList;
import modelo.Trabajador;
import utils.Lectura;

public class Principal {
    private final static Lectura leer = new Lectura();
    private final static ArrayList<Trabajador> trabajadores = new ArrayList<>();
    
    public static boolean validarCantidad(String msg){
        boolean val = false;
        if (trabajadores.isEmpty()) {
            System.out.println("\nNo hay trabajadores por " + msg);
            val = true;
        }
        return val;
    }
    
    public static void cargar_data_preinstalada(){
        Trabajador trabajador1 = new Trabajador(1000, "RIMAC", "Ventas", "Jefe de Ventas", "1", "Samuel", "Larico Pinedo", "12345678", "10/10/2010");
        Trabajador trabajador2 = new Trabajador(2000, "Pacifico", "Sistemas", "Jefe de Sistemas", "2", "Miguel", "Coz Miranda", "00112233", "11/10/2010");
        Trabajador trabajador3 = new Trabajador(3000, "RIMAC", "Compras", "Jefe de compras", "3", "Maria", "Lara Conde", "11122233", "12/10/2010");
        Trabajador trabajador4 = new Trabajador(4000, "La Positiva", "Ventas", "Jefe de Ventas", "4", "Pedro", "Flores Conde", "11111122", "13/10/2010");
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(trabajador3);
        trabajadores.add(trabajador4);
    }
    public static void agregar_trabajador(){
        System.out.println("Nuevo Trabajador: ");
        System.out.print("ID: ");
        String idpersona = leer.cadena();
        System.out.print("Nombre: ");
        String nombre = leer.cadena();
        System.out.print("Apellidos: ");
        String apellido = leer.cadena();       
        System.out.print("DNI: ");
        String dni = leer.cadena();
        System.out.print("Fecha de Nacimiento: ");
        String fecha_nacimiento = leer.cadena();
        
        System.out.print("Salario: ");
        double salario = leer.decimal();
        System.out.print("Seguro: ");
        String seguro = leer.cadena();
        System.out.print("area_trabajo: ");
        String area_trabajo = leer.cadena();
        System.out.print("Cargo: ");
        String cargo = leer.cadena();
        
        Trabajador trabajador = new Trabajador(salario, seguro, area_trabajo, cargo, idpersona, nombre, apellido, dni, fecha_nacimiento);
        trabajadores.add(trabajador);
    }
    public static void eliminar_trabajador(){
        
        if (validarCantidad("eliminar.")) {return;}
        listar_trabajador();
        boolean validate = true;
        String id;
        do {
            
            System.out.print("\nSeleccione el ID del Trabajador a Eliminar: ");
            id = leer.cadena();

            for (int i = 0; i < trabajadores.size(); i++) {

                if (trabajadores.get(i).getIdpersonas().equals(id)) {
                    System.out.println("Trabajador " + trabajadores.get(i).getApellido() + " eliminado.");
                    trabajadores.remove(i);
                    validate = false;
                }
            }
            
            if(validate){
                System.out.println("No se encontró el ID digitado. Intente nuevamente.");
            }
            
        } while (validate);
        
        String question;
        System.out.print("Desea eliminar otro trabajador? (Y/N): ");
        question = leer.cadena();
        
        if(question.equals("Y")){
            eliminar_trabajador();
        } else {
            System.out.println("Gracias...");
        }
        
    }
    public static void editar_trabajador(){
        if (validarCantidad("editar.")) {return;}
        listar_trabajador();
    }
    public static void listar_trabajador(){
        System.out.println("LISTA DE TRABAJADORES");
        int numero = 1;
        for (Trabajador trabajador : trabajadores) {
            System.out.println("---------------------------------------");
            System.out.println("Trabajador Nro " + numero);
            System.out.println("ID: " + trabajador.getIdpersonas());        
            System.out.println("Nombre: " + trabajador.getNombre());        
            System.out.println("Apellidos: " + trabajador.getApellido());        
            System.out.println("DNI: " + trabajador.getDni());        
            System.out.println("Fecha de Nacimiento: " + trabajador.getFecha_nacimiento());        
            System.out.println("Salario: " + trabajador.getSalario());        
            System.out.println("Seguro: " + trabajador.getSeguro());        
            System.out.println("area_trabajo: " + trabajador.getArea_trabajo());        
            System.out.println("Cargo: " + trabajador.getCargo());
            numero++;                
        }
    }
    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    public static void error(){
        System.out.println("Error: Alternativa incorrecta");
    }
    public static void menu(){
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("1. Nuevo trabajador");
        System.out.println("2. Eliminar trabajador");
        System.out.println("3. Editar trabajador");
        System.out.println("4. Listar trabajadores");
        System.out.println("5. Salir");
        System.out.print("Elija una opción [1-5]: ");
        
    }

    public static void inicio(){
        String opcion;
        cargar_data_preinstalada();
        do {            
            menu();
            opcion = leer.cadena();
            switch(opcion){
                case "1" -> agregar_trabajador();
                case "2" -> eliminar_trabajador();
                case "3" -> editar_trabajador();
                case "4" -> listar_trabajador();
                case "5" -> salir();
                default -> error();
            }            
        } while (!opcion.equals("5"));
    }
    
    public static void main(String[] args) {
        inicio();
    }
}
