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
        // se guarda el JSONObject del curso
        JSONObject jsonObject = new JSONObject(jsonTokener);
        // se instancia un objeto Curso para cargar y retornar con datos
        Curso curso = new Curso();

        curso.setNombreCurso(jsonObject.getString("nombreCurso"));
        curso.setCodigo(jsonObject.getInt("codigo"));

        // se instancia un JSONArray para deserializar los alumnos inscriptos
        JSONArray jsonArray = jsonObject.getJSONArray("alumnosInscriptos");

        // cada alumno es un JSONObject dentro del JSONArray de alumnos
        // por eso deserializamos uno por uno en el bucle for y los agregamos al Arraylist del curso
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject alumnoJson = jsonArray.getJSONObject(i);
            Persona persona = new Persona();

            persona.setNombre(alumnoJson.getString("nombre"));
            persona.setDni(alumnoJson.getString("dni"));
            persona.setEdad(alumnoJson.getInt("edad"));
            persona.setSexo(alumnoJson.getString("sexo"));

            curso.agregarAlumno(persona);
        }

        return curso;
    }
}