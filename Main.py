import csv

class Cancion:
    def __init__(self):
        self.artist_name = ""
        self.track_name = ""

    def set_artist_name(self, name):
        self.artist_name = name

    def set_track_name(self, name):
        self.track_name = name

    def get_artist_name(self):
        return self.artist_name

    def get_track_name(self):
        return self.track_name

def leer_csv(archivo_csv):
    canciones = []
    with open(archivo_csv, newline='', encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        next(reader, None)  # Skip the header
        for row in reader:
            if len(row) >= 2:
                cancion = Cancion()
                cancion.set_artist_name(row[1].strip())
                cancion.set_track_name(row[2].strip())
                canciones.append(cancion)
    return canciones

def main():
    archivo_csv = "./archive/spotify_data.csv"
    try:
        canciones = leer_csv(archivo_csv)
        for cancion in canciones:
            print(f"Nombre de Artista: {cancion.get_artist_name()} y Canción del Artista: {cancion.get_track_name()}")
    except IOError as e:
        print(f"Error leyendo el archivo: {e}")

if __name__ == "__main__":
    main()
