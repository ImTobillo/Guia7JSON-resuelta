import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONCurso {
    private GestorJSONPersona gestorJSONPersona;

    public GestorJSONCurso ()
    {
        gestorJSONPersona = new GestorJSONPersona();
    }

    public JSONObject serializar (Curso curso)
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("nombreCurso", curso.getNombreCurso());
        jsonObject.put("codigo", curso.getCodigo());

        /// serializacion del arreglo de alumnos

        JSONArray jsonArray = new JSONArray();

        for (Persona alumno: curso.getAlumnosInscriptos())
        {
            /// serializamos cada alumno y agregamos su JSONObject al JSONArray
            jsonArray.put(gestorJSONPersona.serializar(alumno));
        }

        /// se agrega el JSONArray de los alumnos al JSONObject

        jsonObject.put("alumnosInscriptos", jsonArray);

        return jsonObject;
    }

    public Curso deserializar (JSONTokener jsonTokener)
    {

    }
}