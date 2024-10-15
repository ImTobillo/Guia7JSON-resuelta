import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONBiblioteca {
    private String nomJSON = "biblioteca.json";
    public GestorJSONBiblioteca()
    {}

    public JSONObject serializar(Biblioteca biblioteca)
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("nombreBiblioteca", biblioteca.getNombreBiblioteca());

        JSONArray jsonArray = new JSONArray();

        for (Libro libro: biblioteca.getLibros())
        {
            JSONObject jsonLibro = libro.toJSON();

            jsonArray.put(jsonLibro);
        }

        jsonObject.put("libros", jsonArray);

        return jsonObject;
    }

    public Biblioteca deserializar ()
    {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.setNombreBiblioteca(jsonObject.getString("nombreBiblioteca"));

        JSONArray jsonArray = jsonObject.getJSONArray("libros");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonLibro = jsonArray.getJSONObject(i);

            /// usamos un constructor de libro que reciba un JSON
            Libro libro = new Libro(jsonLibro);

            biblioteca.agregarLibro(libro);
        }

        return biblioteca;
    }

    public void agregarLibro(Libro libro)
    {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        JSONObject jsonBiblioteca = new JSONObject(jsonTokener);

        /// leemos el JSONArray de libros dentro del JSONObject de biblioteca
        JSONArray jsonArray = jsonBiblioteca.getJSONArray("libros");

        /// transformamos el libro que queremos agregar a un JSONObject, para poder agregarlo al JSONArray
        JSONObject jsonLibro = libro.toJSON();
        /// agregamos el JSONObject de libro al JSONArray
        jsonArray.put(jsonLibro);

        /// guardamos el JSON de nuevo
        OperacionesLectoEscritura.grabar(nomJSON, jsonBiblioteca);
    }

    public void borrarLibro (String ISBN)
    {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        JSONObject jsonBiblioteca = new JSONObject(jsonTokener);

        /// leemos el JSONArray de libros dentro del JSONObject de biblioteca
        JSONArray jsonArray = jsonBiblioteca.getJSONArray("libros");

        /// buscamos la posicion del JSONObject del libro y lo borramos usando JSONArray.remove(i)
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonLibro = jsonArray.getJSONObject(i);
            if (jsonLibro.getString("ISBN").equals(ISBN))
            {
                jsonArray.remove(i);
                break;
            }
        }

        /// guardamos el JSON de nuevo
        OperacionesLectoEscritura.grabar(nomJSON, jsonBiblioteca);
    }
}
