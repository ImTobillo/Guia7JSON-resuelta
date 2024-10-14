import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Main {
    public static void main(String[] args) {
        try
        {
            /// EJERCICIO 1 - persona.serializar() convierte el objeto a JSONObject y el metodo estatico grabar() guarda el JSONObject en un archivo con extension .json
            Persona persona = new Persona("juancito", 15, "43223223", "masculino");
            JsonUtils.grabar("persona.json", persona.serializar());

            /// EJERCICIO 2 -
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}