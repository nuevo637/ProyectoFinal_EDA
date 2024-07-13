import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivocsv = "../archive/spotify_data.csv";
        HashMap<String, Cancion> cancionesMap = new HashMap<>();
        int cancionesnum = 0;
        try {
            Cancion[] canciones = leerCSV(archivocsv);
            for (Cancion cancion : canciones) {
                cancionesMap.put(cancion.getArtistId(), cancion);
            }

            for (HashMap<String, Cancion>.Entry<String, Cancion> entry : cancionesMap.entrySet()) {
                String key = entry.key;
                Cancion value = entry.value;
                System.out.println("Key: " + key + ", Value: " + value.toString());
                cancionesnum++;
            }

            System.out.println("Número de canciones: " + cancionesnum);

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


