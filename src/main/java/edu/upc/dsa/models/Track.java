package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Track {

    String id;
    String title;
    String singer;
    int numReproducciones=0;
    static int lastId;

    public Track() {
        this.id = RandomUtils.getId();
    }

    public Track(String title, String singer) {
        this();
        this.setSinger(singer);
        this.setTitle(title);
        this.numReproducciones=0;
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
        return "Track [id="+id+", title=" + title + ", pwd=" + singer +"]";
    }

}