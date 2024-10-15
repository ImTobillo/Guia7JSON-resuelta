import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONPersona {
    public GestorJSONPersona()
    {}

    public JSONObject serializar(Persona p) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("nombre", p.getNombre());
        jsonObject.put("edad", p.getEdad());
        jsonObject.put("sexo", p.getSexo());
        jsonObject.put("dni", p.getDni());

        return jsonObject;
    }

    public Persona deserializar(JSONTokener jsonTokener)
    {
        Persona persona = new Persona();

        try
        {
            JSONObject jsonObject = new JSONObject(jsonTokener);

            persona.setNombre(jsonObject.getString("nombre"));
            persona.setDni(jsonObject.getString("dni"));
            persona.setEdad(jsonObject.getInt("edad"));
            persona.setSexo(jsonObject.getString("sexo"));

            return persona;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return persona;
    }
}
