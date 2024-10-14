import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class OperacionesLectoEscritura {
    private OperacionesLectoEscritura()
    {}

    public static void grabar (String archivo, JSONObject jsonObject)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void grabar (String archivo, JSONArray jsonArray)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JSONTokener leer (String archivo)
    {
        JSONTokener jsonTokener = null;

        try
        {
            jsonTokener = new JSONTokener(new FileReader(archivo));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return jsonTokener;
    }
}
