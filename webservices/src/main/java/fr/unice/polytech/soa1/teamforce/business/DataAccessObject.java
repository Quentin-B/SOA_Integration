package fr.unice.polytech.soa1.teamforce.business;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
@Singleton(name = "teamforce-DB-Mock")
public class DataAccessObject {

    private List<User> users;
    private List<Product> products;
    private List<Order> orders;
    private List<Catalogue> catalogues;

    public DataAccessObject() { init(); }

    private void init() {

        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        orders = new ArrayList<Order>();
        catalogues = new ArrayList<Catalogue>();

        Address a1 = new Address("3943 Fusce Rd.","NE","74022","Bellevue",Kind.PERSONAL);
        Address a2 = new Address("Ap #731-6639 Dolor Av.","Wisconsin","51748","Kenosha",Kind.PERSONAL);
        Address a3 = new Address("704-6722 Morbi Ave","ID","89251","Idaho Falls",Kind.PERSONAL);
        Address a4 = new Address("P.O. Box 835, 1946 Hendrerit Street","HI","62541","Kaneohe",Kind.PROFESSIONAL);

        User u1 = new User("1","Patricia","Jambon","patricia.jambon@gmail.com","0698989898",a1,Access.CUSTOMER);
        User u2 = new User("4","George","Boby","lemailpro@hotmail.fr","0676756576",a4,Access.CUSTOMER);
        User u4 = new User("2","Robert","Lebogoss","playboy666@hotmail.fr","0613371337",a2,Access.EMPLOYEE);
        User u3 = new User("3","Margaret","Delavega","yolo.swag@gmail.com","0669696969",a3,Access.MANAGER);
        u3.addAddress(a4);

        Information info = new Information("01021212","Est ce que ce code est parfait ?","Tout a fait !");
        Information info2 = new Information("31051991","To be or not to be ?","Tobedoobedoo...");
        u1.addInformation(info);
        u1.addInformation(info2);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);

        Product p1 = new Product("1","Tintin","BOOK",15.4);
        Product p2 = new Product("2","Twingo","CAR",8000);
        Product p3 = new Product("3","GTR","CAR",40000);
        Product p4 = new Product("4","Champagne","ALCOHOL",120);
        Product p5 = new Product("5","Duvel","ALCOHOL",5.8);
        Product p6 = new Product("6","BananaWatch","WATCH",23.4);
        Product p7 = new Product("7","Screwdriver","TOOL",7.3);

        Product p8 = new Product("B8M6GJ4JX48ZL1N","Spirou","GAME",15.4);
        Product p9 =new Product("J7W5PI2IQ29CQ6K", "La voiture a romain <3","CAR",2);
        Product p10 =new Product("X6M7VR9BC86QI4I","iPhone6","PHONE",600);
        Product p11 =new Product("C7Y8AL6EM58VR9N", "iPod","ELECTRONIC",120);
        Product p12 = new Product("A1F8IW6GZ17ZF8P", "TV","ELECTRONIC",200);


        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);
        products.add(p10);
        products.add(p11);
        products.add(p12);

        HashSet<Product> catalogueListProduct1 = new HashSet<Product>();
        catalogueListProduct1.add(p1);
        catalogueListProduct1.add(p2);
        catalogueListProduct1.add(p3);
        catalogueListProduct1.add(p8);
        catalogueListProduct1.add(p9);
        catalogueListProduct1.add(p10);
        catalogueListProduct1.add(p11);
        catalogueListProduct1.add(p12);

        HashSet<Product> catalogueListProduct2 = new HashSet<Product>();
        catalogueListProduct2.add(p4);
        catalogueListProduct2.add(p5);
        catalogueListProduct2.add(p6);

        HashSet<Product> catalogueListProduct3 = new HashSet<Product>();
        catalogueListProduct3.add(p7);

        Catalogue catalogue1 = new Catalogue("MisterDiscountId","SUMMER15",catalogueListProduct1,"01/06/2015","31/08/2015");
        Catalogue catalogue2 = new Catalogue("2","WINTER14",catalogueListProduct2,"01/01/2014","31/03/2014");
        Catalogue catalogue3 = new Catalogue("3","SPRING15",catalogueListProduct3,"01/04/2015","31/05/2015");

        catalogues.add(catalogue1);
        catalogues.add(catalogue2);
        catalogues.add(catalogue3);

        Order o1 = new Order("1",a1,a2,u1.getId());

        o1.addItem(p1,2);
        o1.addItem(p2,1);
        o1.addItem(p8,1);
        o1.addItem(p9,1);
        o1.addItem(p10,1);
        o1.addItem(p11,1);
        o1.addItem(p12,1);


        Order o2 = new Order("2",a3,a3,u1.getId());
        Order o3 = new Order("3",a1,a2,u2.getId());
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);


    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Catalogue> getCatalogues() {
        return catalogues;
    }

    public void setCatalogues(List<Catalogue> catalogues) {
        this.catalogues = catalogues;
    }

    public Optional<User> findUserById(String idUser) {
        return getUsers().stream().filter(r -> r.getId().equals(idUser)).findFirst();
    }

    public Optional<Order> findOrderById(String idOrder) {
        return getOrders().stream().filter(r -> r.getId().equals(idOrder)).findFirst();
    }

    public Optional<Product> findProductById(String idProduct) {
        return getProducts().stream().filter(r -> r.getId().equals(idProduct)).findFirst();
    }

    public List<Order> findOrdersByCostumerId(String customerId) {
        List<Order> listOrder = getOrders().stream().filter(o -> o.getCustomerId().equals(customerId)).collect(Collectors.toList());
        return listOrder;
    }

    public Optional<Catalogue> findCatalogueById(String idCatalogue) {
        return getCatalogues().stream().filter(r-> r.getId().equals(idCatalogue)).findFirst();
    }
}
