import org.json.JSONException;
import org.json.JSONTokener;

public class Main {
    public static void main(String[] args) {
        try
        {
            GestorJSONPersona gestorJSONPersona = new GestorJSONPersona();
            GestorJSONCurso gestorJSONCurso = new GestorJSONCurso();

            /// EJERCICIO 1 - gestorPersona.serializar() convierte el objeto a JSONObject y el metodo estatico grabar() guarda el JSONObject en un archivo con extension .json
            Persona persona = new Persona("Juancito", 15, "43223223", "masculino");
            OperacionesLectoEscritura.grabar("persona.json", gestorJSONPersona.serializar(persona));

            /// EJERCICIO 2 - gestorPersona.deserealizar() recibe el JSONTokener generado al leer el archivo JSON, para poder convertir el JSONObject a un objeto Java
            JSONTokener jsonTokener = OperacionesLectoEscritura.leer("persona.json");
            Persona personaJSON = gestorJSONPersona.deserealizar(jsonTokener);
            System.out.println("Persona leida del JSON: " + personaJSON.toString());

            /// EJERCICIO 3 -
            /// carga del curso
            Curso curso = new Curso("Illia", 112323);
            curso.agregarAlumno(new Persona("Maria", 12, "47848983", "femenino"));
            curso.agregarAlumno(new Persona("Marcos", 14, "46343243", "masculino"));
            curso.agregarAlumno(new Persona("Julia", 17, "45434343", "femenino"));

            /// escritura
            OperacionesLectoEscritura.grabar("curso.json", gestorJSONCurso.serializar(curso));

            /// lectura
            jsonTokener = OperacionesLectoEscritura.leer("curso.json");
            Curso cursoJSON =

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}