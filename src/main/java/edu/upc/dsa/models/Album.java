package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Album {

    String id;
    String title;
    String singer;
 //  int numTracks;                               //contador de tracks
    static int lastId;

    public Album() {
        this.id = RandomUtils.getId();
    }           //nomes volem que sigui random la primera vegada. després s'hauria de guardar

    public Album(String title, String singer) {         //afegir que printee la llista de cançons!!!!!!!!!!!
        this();
        this.setSinger(singer);
        this.setTitle(title);
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album [id="+id+", title=" + title + ", pwd=" + singer +"]";
    }

}