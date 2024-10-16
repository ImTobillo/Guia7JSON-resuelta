import org.json.JSONException;
import org.json.JSONTokener;

public class Main {
    public static void main(String[] args) {
        try
        {
            GestorJSONPersona gestorJSONPersona = new GestorJSONPersona();
            GestorJSONCurso gestorJSONCurso = new GestorJSONCurso();
            GestorJSONBiblioteca gestorJSONBiblioteca = new GestorJSONBiblioteca();
            GestorJSONEmpleado gestorJSONEmpleado = new GestorJSONEmpleado();

            /// EJERCICIO 1 - gestorPersona.serializar() convierte el objeto a JSONObject y el metodo estatico grabar() guarda el JSONObject en un archivo con extension .json
            Persona persona = new Persona("Juancito", 15, "43223223", "masculino");
            OperacionesLectoEscritura.grabar("persona.json", gestorJSONPersona.serializar(persona));

            /// EJERCICIO 2 - gestorPersona.deserializar() recibe el JSONTokener generado al leer el archivo JSON, para poder convertir el JSONObject a un objeto Java
            JSONTokener jsonTokener = OperacionesLectoEscritura.leer("persona.json");
            Persona personaJSON = gestorJSONPersona.deserializar(jsonTokener);
            System.out.println("Persona leida del JSON: " + personaJSON.toString());

            /// EJERCICIO 3
            /// carga del curso
            Curso curso = new Curso("Illia", 112323);
            curso.agregarAlumno(new Persona("Maria", 12, "47848983", "femenino"));
            curso.agregarAlumno(new Persona("Marcos", 14, "46343243", "masculino"));
            curso.agregarAlumno(new Persona("Julia", 17, "45434343", "femenino"));

            /// escritura
            OperacionesLectoEscritura.grabar("curso.json", gestorJSONCurso.serializar(curso));

            /// lectura
            Curso cursoJSON = gestorJSONCurso.deserializar();
            System.out.println("Curso leído del JSON: " + cursoJSON.toString());

            /// EJERCICIO 4
            // carga inicial de datos
            Biblioteca biblioteca = new Biblioteca("Ateneo");
            biblioteca.agregarLibro(new Libro("El hombre que fue Jueves", "GK Chesterton", "Policial", "233-345-32332-2-1"));
            biblioteca.agregarLibro(new Libro("Rebelion en la granja", "George Orwell", "Satira", "212-341-36677-1-4"));
            biblioteca.agregarLibro(new Libro("Un mundo feliz", "Huxley", "Ciencia Ficción", "132-151-38671-3-1"));

            // guardar estado actual
            OperacionesLectoEscritura.grabar("biblioteca.json", gestorJSONBiblioteca.serializar(biblioteca));

            // agregar un libro
            gestorJSONBiblioteca.agregarLibro(new Libro("El principito", "Saint-Exupery", "Fantasia", "233-442-64545-3-6"));

            // borrar un libro
            gestorJSONBiblioteca.borrarLibro("233-442-64545-3-6");

            /// EJERCICIO 5
            Empleado empleado = new Empleado(1, "Carlos Alvarado", 1200000, "Sistemas");
            gestorJSONEmpleado.guardarEnJSON(empleado);
            Empleado empleadoLeido = gestorJSONEmpleado.leerJSON();
            System.out.println(empleadoLeido.toString());
        }
        catch (FormatoIncorrectoException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}