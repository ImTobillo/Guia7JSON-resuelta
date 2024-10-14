import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public final class JsonUtils {
    private JsonUtils ()
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
}
