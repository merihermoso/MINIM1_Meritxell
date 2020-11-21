package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.Track;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.upc.dsa.models.Usuari;
import org.apache.log4j.Logger;

public class TracksManagerImpl implements TracksManager {
    private static TracksManager instance;
    protected List<Track> tracks;
  //  protected Queue<Track> ColaRep;                                 //quines cançons afegeixo si no tinc memoria

    protected List<Album> albums;
    protected List<Usuari> usuaris;

    final static Logger logger = Logger.getLogger(TracksManagerImpl.class);


    private TracksManagerImpl() {
        this.tracks = new LinkedList<>();
        this.albums = new LinkedList<>();
        this.usuaris= new LinkedList<>();
    }

    public static TracksManager getInstance() {
        if (instance==null) instance = new TracksManagerImpl();
        return instance;
    }
///////////////////////////////////////////////////////////////////////TRACKS
    public int size() {
        int ret = this.tracks.size();
        logger.info("size " + ret);

        return ret;
    }

    public Track addTrack(Track t) {
        logger.info("new Track " + t);

        this.tracks.add (t);
        logger.info("new Track added");
        return t;
    }

    public Track addTrack(String title, String singer) {
        return this.addTrack(new Track(title, singer));
    }

    public Track getTrack(String id) {
        logger.info("getTrack("+id+")");

        for (Track t: this.tracks) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Track> findAllTracks() {
        return this.tracks;
    }

    @Override
    public void deleteTrack(String id) {

        Track t = this.getTrack(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.tracks.remove(t);

    }

    @Override
    public Track updateTrack(Track p) {
        Track t = this.getTrack(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setSinger(p.getSinger());
            t.setTitle(p.getTitle());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }

    public int tracksize() {
        int ret = this.tracks.size();
        logger.info("size " + ret);

        return ret;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////Cola Reproducción
  /*  public Track addColaRep(Track t) {
        logger.info("new Track to Queue" + t);

        this.ColaRep.add (t);
        logger.info("new Track added to Queue");
        return t;
    }

    public Queue<Track> findAll() {
        return this.ColaRep;
    }*/
/////////////////////////////////////////////////////////////////////////////////////////////// Albums
    public Album addAlbum(Album a) {
        logger.info("new Album " + a);

        this.albums.add (a);
        logger.info("new Album added");
        return a;
    }

    public Album addAlbum(String title, String singer) {
        return this.addAlbum(new Album(title, singer));
    }

    public Album getAlbum(String id) {
        logger.info("getAlbum("+id+")");

        for (Album a: this.albums) {
            if (a.getId().equals(id)) {
                logger.info("getAlbum("+id+"): "+a);

                return a;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Album> findAllAlbums() {
        return this.albums;
    }

    @Override
    public void deleteAlbum(String id) {

        Album a = this.getAlbum(id);
        if (a==null) {
            logger.warn("not found " + a);
        }
        else logger.info(a+" deleted ");

        this.albums.remove(a);

    }

    @Override
    public Album updateAlbum(Album s) {
        Album album = this.getAlbum(s.getId());

        if (album!=null) {
            logger.info(s+" rebut!!!! ");

            album.setSinger(s.getSinger());
            album.setTitle(s.getTitle());

            logger.info(album+" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return album;
    }

    public int albumsize() {
        int ret = this.albums.size();
        logger.info("size " + ret);

        return ret;
    }

    //////////////////////////////////////////////////////////RELACIÓ TRACKS ALBUM

    /*   public Album addTrackToAlbum(Track t,Album a) {
        logger.info("new Song " + t "to Album" + a);

        this.albums.track_name.add (t);        //afegim canço a les dades del album? o al reves? o creem relació amb bbdd?
        this.tracks.album_name.add (a)   //tal com està fet quedaria inicialitzarho a cada clase
        logger.info("new Track:" +t "added to Album:" +a );
        return a;
    }

    public Album addAlbum(String title, String singer) {
        return this.addAlbum(new Album(title, singer));
    }

    public Album getAlbum(String id) {
        logger.info("getAlbum("+id+")");

        for (Album a: this.albums) {
            if (a.getId().equals(id)) {
                logger.info("getAlbum("+id+"): "+a);

                return a;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Album> findAllAlbums() {
        return this.albums;
    }

    @Override
    public void deleteAlbum(String id) {

        Album a = this.getAlbum(id);
        if (a==null) {
            logger.warn("not found " + a);
        }
        else logger.info(a+" deleted ");

        this.tracks.remove(a);

    }

    @Override
    public Album updateAlbum(Album s) {
        Album album = this.getAlbum(s.getId());

        if (album!=null) {
            logger.info(s+" rebut!!!! ");

            album.setPwd(s.getPwd());
            album.setTitle(s.getTitle());

            logger.info(album+" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return album;
    }
*/          ////////////////////////////////////////////////////////////////////////////USUARIS
    public Usuari addUsuari(Usuari u) {
        logger.info("new Usuari " + u);

        this.usuaris.add (u);
        logger.info("new User added");
        return u;
    }

    public Usuari addUsuari(String nom, String pwd) {
        return this.addUsuari(new Usuari(nom, pwd));
    }

    public Usuari getUsuari(String id) {
        logger.info("getUsuari("+id+")");

        for (Usuari u: this.usuaris) {
            if (u.getId().equals(id)) {
                logger.info("getUsuari("+id+"): "+u);

                return u;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Usuari> findAllUsuaris() {
        return this.usuaris;
    }

    @Override
    public void deleteUsuari(String id) {

        Usuari u = this.getUsuari(id);
        if (u==null) {
            logger.warn("not found " + u);
        }
        else logger.info(u+" deleted ");

        this.usuaris.remove(u);

    }

    @Override
    public Usuari updateUsuari(Usuari s) {
        Usuari usuari = this.getUsuari(s.getId());

        if (usuari!=null) {
            logger.info(s+" rebut!!!! ");

            usuari.setPwd(s.getPwd());
            usuari.setNom(s.getNom());

            logger.info(usuari +" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return usuari;
    }

    public int usuarisize() {
        int ret = this.usuaris.size();
        logger.info("size " + ret);

        return ret;
    }

}