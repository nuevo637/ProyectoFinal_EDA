from cancion import Cancion
import csv

#Método para leer el archivo
def leer_csv(archivo_csv):
    canciones = []
    with open(archivo_csv, newline='', encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        next(reader, None) #Se omite la cabecera
        for row in reader:
            if len(row) >= 2:
                cancion = Cancion()
                cancion.set_artist_name(row[1].strip())
                cancion.set_track_name(row[2].strip())
                canciones.append(cancion)
    return canciones

#Main para la ejecucipon de prueba
def main():
    archivo_csv = "./archive/spotify_data.csv"
    try:
        canciones = leer_csv(archivo_csv)
        for cancion in canciones[:10]:
            print(f"Nombre de Artista: {cancion.get_artist_name()} y Canción del Artista: {cancion.get_track_name()}")
    except IOError as e:
        print(f"Error leyendo el archivo: {e}")

if __name__ == "__main__": #Se asegura ejecutar de manera independiente
    main()