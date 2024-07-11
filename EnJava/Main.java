import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivocsv = "../archive/spotify_data.csv";
        HashMap<String, Cancion> cancionesMap = new HashMap<>();
        try {
            Cancion[] canciones = leerCSV(archivocsv);
            for (Cancion cancion : canciones) {
                //System.out.println(" Id: " + cancion.getArtistId() + " Nombre de Artista: " + cancion.getArtistName() + " y Cancion del artista: " + cancion.getTrackName());
                cancionesMap.put(cancion.getArtistId(), cancion);
            }

            for (Map.Entry<String, Cancion> entry : cancionesMap.entrySet()) {
                String key = entry.getKey();
                Cancion value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value.toString());
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static Cancion[] leerCSV(String archivoCSV) throws IOException {
        List<Cancion> canciones = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
        String linea;

        while ((linea = br.readLine()) != null) {

            String[] campos = linea.split(",");
            Cancion cancion = new Cancion();
            cancion.setArtistId(campos[0].trim());
            cancion.setArtistName(campos[1].trim());
            cancion.setTrackName(campos[2].trim());
            canciones.add(cancion);
            
        }

        br.close();

        return canciones.toArray(new Cancion[0]);
    }
} 


