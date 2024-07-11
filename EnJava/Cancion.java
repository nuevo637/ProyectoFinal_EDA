public class Cancion {
    public String artist_name, track_name , id;

    public void setArtistId(String str){
        this.id = str;
    }

    public void setArtistName(String str){
        this.artist_name = str;
    }

    public void setTrackName(String str){
        this.track_name = str;
    }

    public String getArtistName(){
        return artist_name;
    }

    public String getTrackName(){
        return track_name;
    }

    public String getArtistId(){
        return id;
    }

    public String toString() {
        return "Cancion{artistName='" + this.getArtistName() + "', trackName='" + this.getTrackName() + "'}";
    }
}
