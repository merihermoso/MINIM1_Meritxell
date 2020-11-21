package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.Track;
import edu.upc.dsa.models.Usuari;

import java.util.List;

public interface TracksManager {


    public Track addTrack(String title, String singer);
    public Track addTrack(Track t);
    public Track getTrack(String id);
    public List<Track> findAllTracks();
    public void deleteTrack(String id);
    public Track updateTrack(Track t);

    public int size();

    public Album addAlbum(String title, String singer);
    public Album addAlbum(Album a);
    public Album getAlbum(String id);
    public List<Album> findAllAlbums();
    public void deleteAlbum(String id);
    public Album updateAlbum(Album a);

    public int albumsize();

    public Usuari addUsuari(String nom, String pwd);
    public Usuari addUsuari(Usuari u);
    public Usuari getUsuari(String id);
    public List<Usuari> findAllUsuaris();
    public void deleteUsuari(String id);
    public Usuari updateUsuari(Usuari u);

    public int usuarisize();
}
