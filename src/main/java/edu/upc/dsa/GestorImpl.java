package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;

import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.Usuari;
import org.apache.log4j.Logger;

public class GestorImpl implements Gestor {

    private static Gestor instance;
    protected List<Product> products;
  //  protected Queue<Track> ColaRep;                                 //quines cançons afegeixo si no tinc memoria

    protected List<Order> orders;
    protected List<Usuari> usuaris;
   // protected HashMap<String, Usuari> usuaris = new HashMap<String, Usuari>();;

    final static Logger logger = Logger.getLogger(GestorImpl.class);


    private GestorImpl() {
        this.products = new LinkedList<>();
        this.orders = new LinkedList<>();
        //this.usuaris= new LinkedList<>();
    }

    public static Gestor getInstance() {
        if (instance==null) instance = new GestorImpl();
        return instance;
    }
///////////////////////////////////////////////////////////////////////TRACKS
    public int size() {
        int ret = this.products.size();

        logger.info("size " + ret);

        return ret;
    }

    public Product addProduct(Product t) {
        logger.info("new Product " + t);

        this.products.add (t);
        logger.info("new Product added");
        return t;
    }

    public Product addProduct(String productName, String prize) {
        return this.addProduct(new Product(productName, prize));
    }

    public Product getProduct(String id) {
        logger.info("getProduct("+id+")");

        for (Product t: this.products) {
            if (t.getId().equals(id)) {
                logger.info("getProduct("+id+"): "+t);

                return t;
            }
        }

        logger.warn("Product not found " + id);
        return null;
    }

    public List<Product> findAllProducts() {
        return this.products;
    }

    @Override
    public void deleteProduct(String id) {

        Product t = this.getProduct(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.products.remove(t);

    }

    @Override
    public Product updateProduct(Product p) {
        Product t = this.getProduct(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setId(p.getId());
            t.setPrize(p.getPrize());
            t.setProductName(p.getProductName());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }

    public int productsize() {
        int ret = this.products.size();
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
    public Order addOrder(Order a) {
        logger.info("new Order " + a);

        this.orders.add (a);
        logger.info("new Order added");
        return a;
    }

    public Order addOrder(String state, String user) {
        return this.addOrder(new Order(state, user));
    }

    public Order getOrder(int id) {
        logger.info("getOrder("+id+")");

        for (Order a: this.orders) {
            if (a.getId()==id) {
                logger.info("getOrder("+id+"): "+a);

                return a;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Order> findAllOrders() {
        return this.orders;
    }

    @Override
    public void deleteOrder(int id) {

        Order a = this.getOrder(id);
        if (a==null) {
            logger.warn("not found " + a);
        }
        else logger.info(a+" deleted ");

        this.orders.remove(a);

    }

    @Override
    public Order updateOrder(Order s) {
        Order order = this.getOrder(s.getId());

        if (order !=null) {
            logger.info(s+" rebut!!!! ");

            order.setUser(s.getUser());
            order.setState(s.getState());

            logger.info(order +" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return order;
    }

    public int ordersize() {
        int ret = this.orders.size();
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
            album.setTitle(s.getState());

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

        this.usuaris.add(u);
        logger.info("new User added");
        return u;
    }

    public Usuari addUsuari(String nom, String pwd) {
        logger.info("new Usuari " +nom);
        return this.addUsuari(new Usuari(nom, pwd));
    }

    public Usuari getUsuari(String id) {
        logger.info("getUsuari("+id+")");

        for (Usuari u: this.usuaris) {
            if (u.getId().equals(id)) {                 //user u = this.users.get (id); tb es pot fer aixi
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