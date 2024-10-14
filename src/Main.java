import org.json.JSONException;
import org.json.JSONTokener;

public class Main {
    public static void main(String[] args) {
        try
        {
            GestorPersona gestorPersona = new GestorPersona();

            /// EJERCICIO 1 - persona.serializar() convierte el objeto a JSONObject y el metodo estatico grabar() guarda el JSONObject en un archivo con extension .json
            Persona persona = new Persona("juancito", 15, "43223223", "masculino");
            OperacionesLectoEscritura.grabar("persona.json", gestorPersona.serializar(persona));

            /// EJERCICIO 2 -
            JSONTokener jsonTokener = OperacionesLectoEscritura.leer("persona.json");
            Persona personaJSON = gestorPersona.deserealizar(jsonTokener);
            System.out.println("Persona leida del JSON: " + personaJSON.toString());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}