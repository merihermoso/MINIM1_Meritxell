package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Mostra {

    String id_mostra ;
    String id_clinic;
    String id_p;
    String data_extr;
    String id_l;

    static int lastId;

    public Mostra() {
        this.id_mostra = RandomUtils.getId();
    }           //nomes volem que sigui random la primera vegada. després s'hauria de guardar




    public Mostra(String id_clinic, String id_p, String data_extr,String id_l) {         //afegir que printee la llista de cançons!!!!!!!!!!!
        this();
        this.setId_clinic(id_clinic);
        this.setId_p(id_p);
        this.setData_extr(data_extr);
        this.setId_l(id_l);


    }

    public String getId_mostra() {
        return this.id_mostra;
    }
    public void setId_mostra(String id_mostra) {
        this.id_mostra=id_mostra;
    }

    public String getId_clinic() {
        return id_clinic;
    }
    public void setId_clinic(String id_clinic) { this.id_clinic = id_clinic;}

    public String getId_p() { return id_p; }
    public void setId_p(String id_p) { this.id_p = id_p; }

    public String getData_extr() { return data_extr; }
    public void setData_extr(String data_extr) { this.data_extr = data_extr; }

    public String getId_l() { return id_l; }
    public void setId_l(String id_l) { this.id_l = id_l; }

    @Override
    public String toString() {
        return "Mostra [id_mostra="+id_mostra+", id_clinic =" + id_clinic + ", id_persona =" + id_p +", data_extr =" + data_extr+", id_lab =" + id_l +"]";
    }

}