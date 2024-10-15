import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONBiblioteca {
    public GestorJSONBiblioteca()
    {}

    public JSONObject serializar(Biblioteca biblioteca)
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("nombreBiblioteca", biblioteca.getNombreBiblioteca());

        JSONArray jsonArray = new JSONArray();

        for (Libro libro: biblioteca.getLibros())
        {
            JSONObject jsonLibro = new JSONObject();

            jsonLibro.put("nombre", libro.getNombre());
            jsonLibro.put("genero", libro.getGenero());
            jsonLibro.put("autor", libro.getAutor());
            jsonLibro.put("ISBN", libro.getISBN());

            jsonArray.put(jsonLibro);
        }

        jsonObject.put("libros", jsonArray);

        return jsonObject;
    }

    public Biblioteca deserializar (JSONTokener jsonTokener)
    {
        JSONObject jsonObject = new JSONObject(jsonTokener);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.setNombreBiblioteca(jsonObject.getString("nombreBiblioteca"));

        JSONArray jsonArray = jsonObject.getJSONArray("libros");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonLibro = jsonArray.getJSONObject(i);
            Libro libro = new Libro();

            libro.setNombre(jsonLibro.getString("nombre"));
            libro.setAutor(jsonLibro.getString("autor"));
            libro.setGenero(jsonLibro.getString("genero"));
            libro.setISBN(jsonLibro.getString("ISBN"));

            biblioteca.agregarLibro(libro);
        }

        return biblioteca;
    }

    public boolean agregarLibro(Libro libro)
    {
        JSONObject jsonObject = serializar();
    }
}
