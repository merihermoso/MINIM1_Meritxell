package edu.upc.dsa;

import edu.upc.dsa.models.Lab;
import edu.upc.dsa.models.Mostra;

import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.Persona;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;

  //  protected Queue<Track> ColaRep;                                 //quines cançons afegeixo si no tinc memoria

    protected List<Mostra> mostres;
    protected List<Lab> labs;
    protected List<Persona> personas;
   // protected HashMap<String, Usuari> usuaris = new HashMap<String, Usuari>();;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);


    private Covid19ManagerImpl() {
        this.personas = new LinkedList<>();
        this.mostres = new LinkedList<>();
        this.labs= new LinkedList<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }
               ///////////////                         ///////////////////                MOSTRES      /////////////////
    public Mostra addMostra(Mostra m) {
        logger.info("new Mostra " + m);

        this.mostres.add (m);
        logger.info("new Mostra added");
        return m;
    }

    public Mostra addMostra(String id_clinic, String id_p,String data_extr,String id_l) {
        return this.addMostra(new Mostra(id_clinic, id_p, data_extr, id_l));
    }

    public Mostra getMostra(String id_mostra) {
        logger.info("getMostra("+id_mostra+")");

        for (Mostra m: this.mostres) {
            if (m.getId_mostra().equals(id_mostra)) {
                logger.info("getMostra("+id_mostra+"): "+m);

                return m;
            }
        }

        logger.warn("not found " + id_mostra);
        return null;
    }


    public List<Mostra> findAllMostres() {
        return this.mostres;
    }

    @Override
    public void deleteMostra(String id_mostra) {

        Mostra m = this.getMostra(id_mostra);
        if (m==null) {
            logger.warn("not found " + m);
        }
        else logger.info(m+" deleted ");

        this.mostres.remove(m);

    }

    @Override
    public Mostra updateMostra(Mostra s) {
        Mostra mostra = this.getMostra(s.getId_mostra());

        if (mostra !=null) {
            logger.info(s+" rebut!!!! ");

            mostra.setId_p(s.getId_p());
            mostra.setId_l(s.getId_l());
            mostra.setData_extr(s.getData_extr());
            mostra.setId_clinic(s.getId_clinic());

            logger.info(mostra +" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return mostra;
    }

    public int mostresize() {
        int ret = this.mostres.size();
        logger.info("size " + ret);

        return ret;
    }
    /////////////             /////////////             LABS                    /////////////////////////
    public Lab addLab(Lab l) {
        logger.info("new Lab " + l);

        this.labs.add (l);
        logger.info("new Lab added");
        return l;
    }

    public Lab addLab(String nom_lab, String user) {
        return this.addLab(new Lab(nom_lab, user));
    }

    public Lab getLab(String id) {
        logger.info("getLab("+id+")");

        for (Lab l: this.labs) {
            if (l.getId().equals(id)) {
                logger.info("getLab("+id+"): "+l);

                return l;
            }
        }

        logger.warn("not found " + id);
        return null;
    }


    public List<Lab> findAllLabs() {

        return this.labs;
    }


    @Override
    public void deleteLab(String id) {

        Lab l = this.getLab(id);
        if (l==null) {
            logger.warn("not found " + l);
        }
        else logger.info(l+" deleted ");

        this.labs.remove(l);

    }

    @Override
    public Lab updateLab(Lab l) {
        Lab lab = this.getLab(l.getId());

        if (lab !=null) {
            logger.info(l+" rebut!!!! ");

            lab.setUser(l.getUser());
            lab.setNom_lab(l.getNom_lab());

            logger.info(lab +" updated ");
        }
        else {
            logger.warn("not found "+l);
        }

        return lab;
    }

    public int size() {
        int ret = this.labs.size();
        logger.info("size of labs " + ret);

        return ret;
    }
     ////////////            //////////////             PERSONAS                /////////////////////////

    public Persona addPersona(Persona p) {
        logger.info("new Persona " + p);

        this.personas.add(p);
        logger.info("new Persona added");
        return p;
    }

    public Persona addPersona(String nom_persona,  String cognom_persona, String edat_persona,String salud_persona) {
        return this.addPersona(new Persona(nom_persona, cognom_persona,edat_persona, salud_persona));
    }

    public Persona getPersona(String id_persona) {
        logger.info("getPersona("+id_persona+")");

        for (Persona p: this.personas) {
            if (p.getId().equals(id_persona)) {
                logger.info("getPersona("+"): "+p);

                return p;
            }
        }

        logger.warn("not found " + id_persona);
        return null;
    }


    public List<Persona> findAllPersonas() {
        return this.personas;
    }

    @Override
    public void deletePersona(String id_persona) {

        Persona p = this.getPersona(id_persona);
        if (p==null) {
            logger.warn("not found " + p);
        }
        else logger.info(p+" deleted ");

        this.personas.remove(p);

    }

    @Override
    public Persona updatePersona(Persona p) {
        Persona persona = this.getPersona(p.getId());

        if (persona !=null) {
            logger.info(p+" rebut!!!! ");

            persona.setSalud_persona(p.getSalud_persona());
            persona.setNom_persona(p.getNom_persona());
            persona.setCognom_persona(p.getCognom_persona());
            persona.setEdat_persona(p.getEdat_persona());


            logger.info(persona +" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return persona;
    }

    public int personasize() {
        int ret = this.personas.size();
        logger.info("size of personas" + ret);

        return ret;
    }

}