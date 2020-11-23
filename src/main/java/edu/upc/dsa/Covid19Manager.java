package edu.upc.dsa;

import edu.upc.dsa.models.Lab;
import edu.upc.dsa.models.Mostra;
import edu.upc.dsa.models.Persona;

import java.util.List;

public interface Covid19Manager {




    public Mostra addMostra(String id_clinic, String id_p, String data_extr, String id_lab);
    public Mostra addMostra(Mostra m);
    public Mostra getMostra(String id);
    public List<Mostra> findAllMostres();
    public void deleteMostra(String id);
    public Mostra updateMostra(Mostra a);

    public int mostresize();


    public Lab addLab(String state, String user);
    public Lab addLab(Lab l);
    public Lab getLab(String id);
    public List<Lab> findAllLabs();
    public void deleteLab(String id);
    public Lab updateLab(Lab l);

    public int size();



    public Persona addPersona(String nom_persona, String cognom_persona, String edat_persona,String salud_persona);
    public Persona addPersona(Persona p);
    public Persona getPersona(String id_persona);
    public List<Persona> findAllPersonas();
    //  public Order findOrderByUser(String id);
    public void deletePersona(String id_persona);
    public Persona updatePersona(Persona p);

    public int personasize();


}
