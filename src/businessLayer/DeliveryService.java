package businessLayer;

import dataLayer.Serializator;
import dataLayer.WriterForFile;
import presentationLayer.Observer;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private ArrayList<Account> accounts;
    private ArrayList<MenuItem> menuItems;
    private HashMap<Order, ArrayList<MenuItem>> orders;
    private final Serializator serializator;
    private final ArrayList<Observer> observers;
    private final HashSet<MenuItem> menuItemHashSet = new HashSet<>();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DeliveryService() {
        serializator = new Serializator();
        accounts = (ArrayList<Account>) serializator.deserialization("accounts.txt");
        if(accounts == null) {
            accounts = new ArrayList<>();
        }
        menuItems = (ArrayList<MenuItem>) serializator.deserialization("menu.txt");
        if(menuItems == null) {
            menuItems = new ArrayList<>();
        }
        orders = (HashMap<Order, ArrayList<MenuItem>>) serializator.deserialization("orders.txt");
        if(orders == null) {
            orders = new HashMap<>();
        }
        observers = new ArrayList<>();
    }

    /**
     * DeliveryService invariant - checks if all the instances have been initialized
     * @nochange
     */
    public void isWellFormed() {
        assert orders == null || menuItems != null || accounts != null : "Null";
    }

    /**
     * adds an account to the accounts list
     * @param account - account that we want to add to accounts list
     */
    @Override
    public void addUser(Account account) {
        assert account != null : "Null account";
        accounts.add(account);
        serializator.serialization("accounts.txt", accounts);
    }

    /**
     * adds a product to the products list
     * @param menuItem - products list
     */
    @Override
    public void addProduct(MenuItem menuItem) {
        assert menuItem != null : "Null menu item";
        menuItems.add(menuItem);
        serializator.serialization("menu.txt", menuItems);
    }

    /**
     * modifies the content of a product from the products list. Initially, the product is searched by title
     * @param menuItems - list of products
     * @param title - used for searching the product that we want to modify
     * @param newTitle - new title of the product
     * @param rating - new value of rating
     * @param calories - new value of calories
     * @param protein - new value of proteins
     * @param fat - new value of fats
     * @param sodium - new value of sodium
     * @param price - new value of price
     */
    @Override
    public void editMenuItem(ArrayList<MenuItem> menuItems, String title, String newTitle, float rating, int calories, int protein, int fat, int sodium, float price) {
        assert title != null : "Null title";
        MenuItem menuItem = searchByTitle(menuItems, title);
        menuItem.setTitle(newTitle);
        menuItem.setRating(rating);
        menuItem.setCalories(calories);
        menuItem.setProtein(protein);
        menuItem.setFat(fat);
        menuItem.setSodium(sodium);
        menuItem.setPrice(price);
        Serializator serializator = new Serializator();
        serializator.serialization("menu.txt", menuItems);
    }

    /**
     * search those products in the products list that have the given title
     * @param menuItems - products list
     * @param title - given title of the product we want to search
     * @return a list of products that have the given title
     */
    @Override
    public MenuItem searchByTitle(ArrayList<MenuItem> menuItems, String title) {
        assert title != null : "Null title";

        for(MenuItem menuItem : menuItems) {
            if(menuItem.getTitle().equals(title)) {
                return menuItem;
            }
        }
//        MenuItem menuItem = menuItems.stream().filter(menuItem1 -> menuItem1.getTitle().equals(title)).collect(Collectors.toList()).get(0);

        return null;
    }

    /**
     * search those products in the products list that have the given number of calories
     * @param menuItems - products list
     * @param calories - given number of calories used for searching
     * @return a list of products that have the given number of calories
     */
    @Override
    public ArrayList<MenuItem> searchByCalories(ArrayList<MenuItem> menuItems, int calories) {
        assert calories<0 : "Negative number of calories";

//        ArrayList<MenuItem> found = new ArrayList<>();
//
//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getCalories() == calories) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getCalories() == calories).collect(Collectors.toList());

        return found;
    }

    /**
     * seach those products in the products list that have the given number of fats
     * @param menuItems - products list
     * @param fat - given number of fats used for searching
     * @return a list of products that have the given number of fats
     */
    @Override
    public ArrayList<MenuItem> searchByFat(ArrayList<MenuItem> menuItems, int fat) {
        assert fat<0 : "Negative number of fats";

//        ArrayList<MenuItem> found = new ArrayList<>();
//
//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getFat() == fat) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getFat() == fat).collect(Collectors.toList());

        return found;
    }

    /**
     * search those products in the products list that have the given price
     * @param menuItems - products list
     * @param price - given price used for searching
     * @return a list of products that have the given price
     */
    @Override
    public ArrayList<MenuItem> searchByPrice(ArrayList<MenuItem> menuItems, float price) {
        assert price<0 : "Negative price";

        //ArrayList<MenuItem> found = new ArrayList<>();

//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getPrice() == price) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getPrice() == price).collect(Collectors.toList());

        return found;
    }

    /**
     * search those products in the products list that have the given number of proteins
     * @param menuItems - products list
     * @param protein - given number of proteins used for searching
     * @return a list of products that have the given number of proteins
     */
    @Override
    public ArrayList<MenuItem> searchByProtein(ArrayList<MenuItem> menuItems, int protein) {
        assert protein<0 : "Negative number of proteins";

//        ArrayList<MenuItem> found = new ArrayList<>();
//
//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getProtein() == protein) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getProtein() == protein).collect(Collectors.toList());

        return found;
    }

    /**
     * search those products in the products list that have the given rating
     * @param menuItems - products list
     * @param rating - given rating used for searching
     * @return a list of products that have the given rating
     */
    @Override
    public ArrayList<MenuItem> searchByRating(ArrayList<MenuItem> menuItems, float rating) {
        assert rating<0 : "Negative rating";

//        ArrayList<MenuItem> found = new ArrayList<>();
//
//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getRating() == rating) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getRating() == rating).collect(Collectors.toList());

        return found;
    }

    /**
     * search those products in the products list that have the given quantity of sodium
     * @param menuItems - products list
     * @param sodium - given quantity of sodium used for searching
     * @return a list of products that have the given quantity of sodium
     */
    @Override
    public ArrayList<MenuItem> searchBySodium(ArrayList<MenuItem> menuItems, int sodium) {
        assert sodium<0 : "Negative quantity of sodium";

//        ArrayList<MenuItem> found = new ArrayList<>();
//
//        for(MenuItem menuItem : menuItems) {
//            if(menuItem.getSodium() == sodium) {
//                found.add(menuItem);
//            }
//        }

        ArrayList<MenuItem> found = (ArrayList<MenuItem>) menuItems.stream().filter(menuItem -> menuItem.getSodium() == sodium).collect(Collectors.toList());

        return found;
    }

    /**
     * deletes a product from the products list by the given title
     * @param title - product's title that we want to delete
     */
    @Override
    public void deleteMenuItem(String title) {
        assert title != null : "Null title";
        MenuItem menuItem = null;
        for (MenuItem menuItem1 : menuItems) {
            if (menuItem1.getTitle().equals(title)) {
                menuItem = menuItem1;
                break;
            }
        }
        menuItems.remove(menuItem);
        serializator.serialization("menu.txt", menuItems);
    }

    /**
     * adds a base product into a composite product
     * @param menuItem1 - composite product
     * @param menuItem2 - base product to add into composite product
     */
    @Override
    public void addInComposite(MenuItem menuItem1, MenuItem menuItem2) {
        assert menuItem1 != null : "Null object";
        assert menuItem2 != null : "Null object";
        menuItem1.add(menuItem2);
        menuItem1.computeRating();
        menuItem1.computeCalories();
        menuItem1.computeFat();
        menuItem1.computeProtein();
        menuItem1.computeSodium();
        menuItem1.computePrice();
    }

    public static <T> Predicate<T> distinct(Function<? super T, Object> NameExtractor) {
        Map<Object, Boolean> s = new ConcurrentHashMap<>();
        return p -> s.putIfAbsent(NameExtractor.apply(p), Boolean.TRUE) == null;
    }

    /**
     * implements the "Import products" action for the administrator
     * @return a list of products
     */
    public ArrayList<MenuItem> importBaseProducts() {
        Function<String, BaseProduct> mapToItem = (line) -> {

            String[] l = line.split(",");

            BaseProduct item = new BaseProduct();
            item.setTitle(l[0]);
            item.setRating(Float.parseFloat(l[1]));
            item.setCalories(Integer.parseInt(l[2]));
            item.setProtein(Integer.parseInt(l[3]));
            item.setFat(Integer.parseInt(l[4]));
            item.setSodium(Integer.parseInt(l[5]));
            item.setPrice(Float.parseFloat(l[6]));

            return item;
        };

        ArrayList<BaseProduct> products;
        String inputFilePath = "D:\\tema_4\\products.csv";
        File inputF = new File(inputFilePath);
        InputStream inputFS = null;
        try {
            inputFS = new FileInputStream(inputF);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        products = (ArrayList<BaseProduct>) br.lines().skip(1).map(mapToItem).filter(distinct(MenuItem::getTitle))
                .collect(Collectors.toList());

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuItemHashSet.addAll(products);
        menuItems.addAll(menuItemHashSet);

        serializator.serialization("menu.txt", menuItems);
        return menuItems;
    }

    /**
     * adds an order with the contained products in the orders list
     * @param order - the order we want to add to the orders list
     * @param menuItems - the products contained in the order
     */
    @Override
    public void addOrder(Order order, ArrayList<MenuItem> menuItems) {
        assert order!=null : "Null order";
        orders.put(order, menuItems);
        serializator.serialization("orders.txt", orders);
    }

    /**
     * generates the report based on a starting hour and an ending hour
     * @param startHour - start hour
     * @param endHour - end hour
     */
    @Override
    public void firstReport(int startHour, int endHour) {
        assert startHour < 25 : "Invalid start hour";
        assert endHour < 25 : "Invalid end hour";
        List<Order> orderList = orders.keySet().stream().filter(order -> order.getOrderDate().getHour() >= startHour)
                .filter(order -> order.getOrderDate().getHour() < endHour).collect(Collectors.toList());
        ArrayList<Order> ord = new ArrayList<>(orderList);
        StringBuilder text = new StringBuilder();
        for(Order order : ord) {
            text.append("Order with id ").append(order.getOrderID()).append(" made by client with id ").append(order.getClientID())
                            .append(" on date ").append(dateTimeFormatter.format(order.getOrderDate())).append("\n");
            text.append("Products:").append("\n");
            for(MenuItem menuItem : order.getProducts()) {
                text.append(menuItem.toString());
            }
        }
        WriterForFile writerForFile = new WriterForFile();
        writerForFile.file("report1.txt", text.toString());
    }

    /**
     * generates the report based on a given number of times
     * @param noTimes - number of times
     */
    @Override
    public void secondReport(int noTimes) {
        assert noTimes > 0 : "Invalid number of times";
        ArrayList<MenuItem> ord;
        ArrayList<MenuItem> prod = new ArrayList<>();
        for(Map.Entry<Order, ArrayList<MenuItem>> entry : orders.entrySet()) {
            prod.addAll(entry.getValue());
        }
        ord = (ArrayList<MenuItem>) prod.stream().filter(p -> Collections.frequency(prod, p) >= noTimes)
                .distinct().collect(Collectors.toList());
        StringBuilder text= new StringBuilder();
        for(MenuItem menuItem : ord) {
            text.append(menuItem.getTitle()).append(", ").append(menuItem.getRating()).append(", ")
                    .append(menuItem.getCalories()).append(", ").append(menuItem.getPrice()).append(", ")
                    .append(menuItem.getFat()).append(", ").append(menuItem.getSodium()).append(", ")
                    .append(menuItem.getPrice()).append("\n");
        }
        WriterForFile writerForFile = new WriterForFile();
        writerForFile.file("report2.txt", text.toString());
    }

    /**
     * generates report based on a number of times and a given amount
     * @param noTimes - number of times
     * @param amount - amount
     */
    @Override
    public void thirdReport(int noTimes, double amount) {
        assert noTimes > 0 : "Invalid number of Times";
        assert amount > 0 : "Invalid amount";

        List<Account> acc = accounts.stream().filter(account -> orders.keySet().stream()
                .filter(order -> order.getClientID() == account.getId() && orders.get(order).stream()
                        .mapToDouble(MenuItem::computePrice).reduce(0, Double::sum) >= amount)
                .count() >= noTimes).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for(Account account : acc) {
            builder.append(account.getUsername()).append("\n");
        }
        WriterForFile writerForFile = new WriterForFile();
        writerForFile.file("report3.txt", builder.toString());
    }

    /**
     * generates report based on a given number of day
     * @param date - number of day
     */
    @Override
    public void forthReport(int date) {
        assert date > 0 && date < 32 : "Invalid date";
        List<MenuItem> prods = new ArrayList<>();
        orders.keySet().stream().filter(order -> order.getOrderDate().getDayOfMonth() == date)
                .map(order -> orders.get(order)).forEach(prods::addAll);
        Map<MenuItem, Integer> count = new HashMap<>();
        prods.stream().forEach(menuItem -> count.put(menuItem, count.get(menuItem) == null ? 1 : count.get(menuItem) + 1));
        Set<MenuItem> prodsSet = new HashSet<>(prods);
        StringBuilder text = new StringBuilder();
        for(MenuItem menuItem : prodsSet) {
            text.append(count.get(menuItem)).append(", ").append(menuItem.getTitle()).append("\n");
        }
        WriterForFile writerForFile = new WriterForFile();
        writerForFile.file("report4.txt", text.toString());
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * adds an observer to the observers list
     * @param observer - observer we want to add to the observers list
     */
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * removes an observer from the observers list
     * @param observer - observer we want to remove from the observers list
     */
    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * announce a change to all the observers
     */
    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
