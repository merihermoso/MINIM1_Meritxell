package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Usuari;

import java.util.List;

public interface Gestor {


    public Product addProduct(String title, String singer);
    public Product addProduct(Product t);
    public Product getProduct(String id);
    public List<Product> findAllProducts();
    public void deleteProduct(String id);
    public Product updateProduct(Product t);

    public int size();

    public Order addOrder(String title, String singer);
    public Order addOrder(Order a);
    public Order getOrder(int id);
    public List<Order> findAllOrders();
    public void deleteOrder(int id);
    public Order updateOrder(Order a);

    public int ordersize();

    public Usuari addUsuari(String nom, String pwd);
    public Usuari addUsuari(Usuari u);
    public Usuari getUsuari(String id);
    public List<Usuari> findAllUsuaris();
    public void deleteUsuari(String id);
    public Usuari updateUsuari(Usuari u);

    public int usuarisize();
}
