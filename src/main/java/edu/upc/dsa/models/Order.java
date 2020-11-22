package edu.upc.dsa.models;

public class Order {

    int id =0;
    String state;
    String user;
 //  int numTracks;                               //contador de tracks
    static int lastId;

    public Order() {
        this.id = id+1;
    }           //nomes volem que sigui random la primera vegada. després s'hauria de guardar

    public Order(String state, String user) {         //afegir que printee la llista de cançons!!!!!!!!!!!
        this();
        this.setUser(user);
        this.setState(state);
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id=id;
    }


    public String getState() {
        return state;
    }
    public void setState(String title) { this.state = state;}

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order [id="+id+", state=" + state + ", user =" + user +"]";
    }

}