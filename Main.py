from leer_csv import *
def main():
    archivo_csv = "./archive/spotify_data.csv"
    try:
        canciones = leer_csv(archivo_csv)
        for cancion in canciones[:10]:
            print(f"{cancion.get_artist_name()}, {cancion.get_track_name()}, {cancion.get_track_id()}, {cancion.get_popularity()}, {cancion.get_year()}, {cancion.get_duration_ms()}")
    except IOError as e:
        print(f"Error leyendo el archivo: {e}")

if __name__ == "__main__":
    main()