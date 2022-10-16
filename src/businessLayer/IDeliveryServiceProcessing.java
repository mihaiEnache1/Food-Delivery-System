package businessLayer;

import java.util.ArrayList;

public interface IDeliveryServiceProcessing {
    /**
     * adds a new account in the ArrayList of Accounts
     * @pre account!=null
     * @post accounts.size() >= accounts.size()@pre + 1
     */
    void addUser(Account account);

    /**
     * adds a new product in the ArrayList of MenuItems
     * @pre menuItem!=null
     * @post menuItems.size() >= menuItems.size()@pre + 1
     */
    void addProduct(MenuItem menuItem);

    /**
     *
     * @pre menuItems!=null
     * @pre title!=null
     * @post menuItems.size() == menuItems.size()@pre
     */
    void editMenuItem(ArrayList<MenuItem> menuItems, String title, String newTitle, float rating, int calories, int protein, int fat, int sodium, float price);

    /**
     *
     * @pre menuItems!=null
     * @pre title!=null
     * @post menuItems.size() == menuItems.size()@pre
     */
    MenuItem searchByTitle(ArrayList<MenuItem> menuItems, String title);

    /**
     *
     * @pre menuItems!=null
     * @pre rating>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchByRating(ArrayList<MenuItem> menuItems, float rating);

    /**
     *
     * @pre menuItems!=null
     * @pre calories>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchByCalories(ArrayList<MenuItem> menuItems, int calories);

    /**
     *
     * @pre menuItems!=null
     * @pre protein>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchByProtein(ArrayList<MenuItem> menuItems, int protein);

    /**
     *
     * @pre menuItems!=null
     * @pre fat>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchByFat(ArrayList<MenuItem> menuItems, int fat);

    /**
     *
     * @pre menuItems!=null
     * @pre sodium>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchBySodium(ArrayList<MenuItem> menuItems, int sodium);

    /**
     *
     * @pre menuItems!=null
     * @pre price>0
     * @post menuItems.size() == menuItems.size()@pre
     */
    ArrayList<MenuItem> searchByPrice(ArrayList<MenuItem> menuItems, float price);

    /**
     * @pre title!=null
     * @post menuItems.size() == menuItems.size()@pre - 1
     */
    void deleteMenuItem(String title);

    /**
     *
     * @pre menuItem1!=null
     * @pre menuItem2!=null
     * @post menuItems.size() = menuItems.size()@pre + 1
     */
    void addInComposite(MenuItem menuItem1, MenuItem menuItem2);

    /**
     *
     * @pre true
     * @post @nochange
     */
    ArrayList<MenuItem> importBaseProducts();

    /**
     *
     * @pre order!=null
     * @pre menuItems!=null
     * @post orders.size() = orders.size()@pre + 1
     */
    void addOrder(Order order, ArrayList<MenuItem> menuItems);

    void firstReport(int startHour, int endHour);

    /**
     *
     * @pre noTimes>0
     * @post @nochange
     */
    void secondReport(int noTimes);

    /**
     *
     * @pre noTimes>0
     * @pre amount>0
     */
    void thirdReport(int noTimes, double amount);

    /**
     *
     * @pre date>0 && date<32
     * @post @nochange
     */
    void forthReport(int date);
}
