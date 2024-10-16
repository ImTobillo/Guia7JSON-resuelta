import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONEmpleado {
    private String nomJSON = "empleado.json";

    public GestorJSONEmpleado()
    {}

    public void guardarEnJSON (Empleado empleado)
    {
        JSONObject jsonEmpleado = empleado.toJSON();

        OperacionesLectoEscritura.grabar(nomJSON, jsonEmpleado);
    }

    public Empleado leerJSON() throws FormatoIncorrectoException
    {
        Empleado empleado;

        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        JSONObject jsonEmpleado = new JSONObject(jsonTokener);

        if (jsonEmpleado.has("id") && jsonEmpleado.has("nombre") && jsonEmpleado.has("salario") && jsonEmpleado.has("departamente"))
        {
            empleado = new Empleado(jsonEmpleado);
        }
        else
        {
            throw new FormatoIncorrectoException();
        }

        return empleado;
    }
}
