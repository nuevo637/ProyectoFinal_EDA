from cancion import Cancion  # Asumiendo que Cancion está definida en cancion.py
import csv

def leer_csv(archivo_csv):
    canciones = []
    with open(archivo_csv, newline='', encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        next(reader, None) 

        for row in reader:
            if len(row) >= 17: 
                cancion = Cancion()
                cancion.set_artist_name(row['artist_name'].strip())
                cancion.set_track_name(row['track_name'].strip())
                cancion.set_track_id(int(row['track_id']))
                cancion.set_popularity(int(row['popularity']))
                cancion.set_year(int(row['year']))
                cancion.set_duration_ms(int(row['duration_ms']))
                canciones.append(cancion)

    return canciones