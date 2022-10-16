package presentationLayer;

import businessLayer.*;

import javax.swing.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Controller {
    private final AdministratorGUI administratorGUI;
    private final LogInView logInView;
    private final AddBaseProductView addBaseProductView;
    private final EditProductView editProductView;
    private final ClientGUI clientGUI;
    private final AddCompositeProductView addCompositeProductView;
    private final FirstReportView firstReportView;
    private final SecondReportView secondReportView;
    private final ThirdReportView thirdReportView;
    private final ForthReportView forthReportView;
    private final OrderView orderView;
    private final EmployeeGUI employeeGUI;
    private ArrayList<Account> accounts;
    private ArrayList<MenuItem> menuItems;
    private final ArrayList<MenuItem> orderItems;
    private HashMap<Order, ArrayList<MenuItem>> orders;
    private Account currentClientAccount;

    int id = 0;
    int idOrder = 0;

    public Controller(AdministratorGUI administratorGUI, LogInView logInView, AddBaseProductView addBaseProductView, EditProductView editProductView,
                      ClientGUI clientGUI, AddCompositeProductView addCompositeProductView,
                      FirstReportView firstReportView, SecondReportView secondReportView,
                      ThirdReportView thirdReportView, ForthReportView forthReportView, OrderView orderView,
                      EmployeeGUI employeeGUI, DeliveryService deliveryService) {
        this.administratorGUI = administratorGUI;
        this.logInView = logInView;
        this.addBaseProductView = addBaseProductView;
        this.editProductView = editProductView;
        this.clientGUI = clientGUI;
        this.addCompositeProductView = addCompositeProductView;
        this.firstReportView = firstReportView;
        this.secondReportView = secondReportView;
        this.thirdReportView = thirdReportView;
        this.forthReportView = forthReportView;
        this.orderView = orderView;
        this.employeeGUI = employeeGUI;
        this.accounts = new ArrayList<>();
        this.menuItems = new ArrayList<>();
        this.orderItems = new ArrayList<>();
        this.orders = new HashMap<>();
        deliveryService.isWellFormed();

        this.logInView.logButtonListener(e -> {
            if(e.getSource() == this.logInView.getLogButton()) {
                accounts = deliveryService.getAccounts();
                if(Objects.equals(this.logInView.getComboBox().getSelectedItem(), "Administrator")) {
                    boolean found = false;
                    for(Account account : accounts) {
                        if(account.getType() == Type.ADMINISTRATOR) {
                            if (this.logInView.getUsername().equals(account.getUsername()) && this.logInView.getPassword().equals(account.getPassword())) {
                                this.administratorGUI.setVisible(true);
                                this.logInView.setVisible(false);
                                found = true;
                                break;
                            }
                        }
                    }
                    if(!found) {
                        JOptionPane.showMessageDialog(this.logInView, "Wrong credentials");
                        this.logInView.refresh();
                    }
                } else if(Objects.equals(this.logInView.getComboBox().getSelectedItem(), "Client")) {
                    boolean found = false;
                    for(Account account : accounts) {
                        if(account.getType() == Type.CLIENT) {
                            if(this.logInView.getUsername().equals(account.getUsername()) && this.logInView.getPassword().equals(account.getPassword())) {
                                this.currentClientAccount =  new Account(account.getUsername(), account.getPassword(), account.getId(), account.getType());
                                this.logInView.setVisible(false);
                                this.clientGUI.setVisible(true);
                                found = true;
                                break;
                            }
                        }
                    }
                    if(!found) {
                        JOptionPane.showMessageDialog(this.logInView, "Wrong credentials");
                        this.logInView.refresh();
                    }
                } else {
                    boolean found = false;
                    for(Account account : accounts) {
                        if(account.getType() == Type.EMPLOYEE) {
                            if(this.logInView.getUsername().equals(account.getUsername()) && this.logInView.getPassword().equals(account.getPassword())) {
                                this.employeeGUI.setVisible(true);
                                found = true;
                                break;
                            }
                        }
                    }
                    if(!found) {
                        JOptionPane.showMessageDialog(this.logInView, "Wrong credentials");
                        this.logInView.refresh();
                    }
                }
            }
        });

        this.logInView.registerButtonListener(e -> {
            if(e.getSource() == this.logInView.getRegisterButton()) {
                accounts = deliveryService.getAccounts();
                id = accounts.size();
                Type type;
                if(Objects.equals(this.logInView.getComboBox().getSelectedItem(), "Administrator")) {
                    type = Type.ADMINISTRATOR;
                } else if(Objects.equals(this.logInView.getComboBox().getSelectedItem(), "Employee")) {
                    type = Type.EMPLOYEE;
                } else {
                    type = Type.CLIENT;
                }
                Account account = new Account(this.logInView.getUsername(), this.logInView.getPassword(), id, type);
                deliveryService.addUser(account);
                JOptionPane.showMessageDialog(this.logInView, "Successful registration");
            }
        });

        this.administratorGUI.backButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getBackButton()) {
                this.administratorGUI.setVisible(false);
                this.logInView.setVisible(true);
            }
        });

        this.administratorGUI.importButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getImportButton()) {
                menuItems = deliveryService.importBaseProducts();
                System.out.println(menuItems.size());
            }
        });

        this.administratorGUI.showButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getShowButton()) {
                menuItems = deliveryService.getMenuItems();
                System.out.println(menuItems.size());
                this.administratorGUI.getDefaultTableModel().getDataVector().removeAllElements();
                this.administratorGUI.getDefaultTableModel().fireTableDataChanged();
                for(MenuItem menuItem : menuItems) {
                    this.administratorGUI.getDefaultTableModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.administratorGUI.addButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getAddButton()) {
                this.administratorGUI.setVisible(false);
                this.addBaseProductView.setVisible(true);
            }
        });

        this.administratorGUI.deleteButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getDeleteButton()) {
                MenuItem menuItem = menuItems.get(this.administratorGUI.getTable().getSelectedRow());
                deliveryService.deleteMenuItem(menuItem.getTitle());
                this.administratorGUI.getDefaultTableModel().removeRow(this.administratorGUI.getTable().getSelectedRow());
                JOptionPane.showMessageDialog(this.administratorGUI, "Product deleted successfully");
            }
        });

        this.administratorGUI.editButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getEditButton()) {
                this.administratorGUI.setVisible(false);
                this.editProductView.setVisible(true);
                this.editProductView.getModel().getDataVector().removeAllElements();
                this.editProductView.getModel().fireTableDataChanged();
                for(MenuItem menuItem : menuItems) {
                    this.editProductView.getModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.administratorGUI.report1ButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getReport1Button()) {
                this.administratorGUI.setVisible(false);
                this.firstReportView.setVisible(true);
            }
        });

        this.administratorGUI.report2ButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getReport2Button()) {
                this.administratorGUI.setVisible(false);
                this.secondReportView.setVisible(true);
            }
        });

        this.administratorGUI.report3ButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getReport3Button()) {
                this.administratorGUI.setVisible(false);
                this.thirdReportView.setVisible(true);
            }
        });

        this.administratorGUI.report4ButtonListener(e -> {
            if(e.getSource() == this.administratorGUI.getReport4Button()) {
                this.administratorGUI.setVisible(false);
                this.forthReportView.setVisible(true);
            }
        });

        this.firstReportView.backButtonListener(e -> {
            if(e.getSource() == this.firstReportView.getBackButton()) {
                this.administratorGUI.setVisible(true);
                this.firstReportView.setVisible(false);
            }
        });

        this.firstReportView.reportButtonListener(e -> {
            if(e.getSource() == this.firstReportView.getReportButton()) {
                deliveryService.firstReport(this.firstReportView.getStartHour(), this.firstReportView.getEndHour());
            }
        });

        this.secondReportView.backListener(e -> {
            if(e.getSource() == this.secondReportView.getBackButton()) {
                this.administratorGUI.setVisible(true);
                this.secondReportView.setVisible(false);
            }
        });

        this.secondReportView.reportListener(e -> {
            if(e.getSource() == this.secondReportView.getReportButton()) {
                deliveryService.secondReport(this.secondReportView.getValue());
            }
        });

        this.thirdReportView.backListener(e -> {
            if(e.getSource() == this.thirdReportView.getBackButton()) {
                this.thirdReportView.setVisible(false);
                this.administratorGUI.setVisible(true);
            }
        });

        this.thirdReportView.reportListener(e -> {
            if(e.getSource() == this.thirdReportView.getReportButton()) {
                deliveryService.thirdReport(this.thirdReportView.getNoTimes(), this.thirdReportView.getAmount());
            }
        });

        this.forthReportView.backListener(e -> {
            if(e.getSource() == this.forthReportView.getBackButton()) {
                this.forthReportView.setVisible(false);
                this.administratorGUI.setVisible(true);
            }
        });

        this.forthReportView.reportListener(e -> {
            if(e.getSource() == this.forthReportView.getReportButton()) {
                deliveryService.forthReport(this.forthReportView.getDay());
            }
        });

        this.addBaseProductView.backButtonListener(e -> {
            if(e.getSource() == this.addBaseProductView.getBackButton()) {
                this.administratorGUI.setVisible(true);
                this.addBaseProductView.setVisible(false);
            }
        });

        this.addBaseProductView.compositeProductButtonListener(e -> {
            if(e.getSource() == this.addBaseProductView.getAddCompositeProductButton()) {
                this.addBaseProductView.setVisible(false);
                this.addCompositeProductView.setVisible(true);
                this.addCompositeProductView.getModel().getDataVector().removeAllElements();
                this.addCompositeProductView.getModel().fireTableDataChanged();
                for(MenuItem menuItem : menuItems) {
                    this.addCompositeProductView.getModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.addBaseProductView.baseProductButtonListener(e -> {
            if (e.getSource() == this.addBaseProductView.getAddBaseProductButton()) {
                try {
                    String title = this.addBaseProductView.getTitle();
                    float rating = this.addBaseProductView.getRating();
                    int calories = this.addBaseProductView.getCalories();
                    int protein = this.addBaseProductView.getProtein();
                    int fat = this.addBaseProductView.getFat();
                    int sodium = this.addBaseProductView.getSodium();
                    float price = this.addBaseProductView.getPrice();

                    BaseProduct baseProduct = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
                    deliveryService.addProduct(baseProduct);
                    for(MenuItem menuItem : menuItems) {
                        if (menuItem.getTitle().equals(baseProduct.getTitle())) {
                            System.out.println("found");
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(this.addBaseProductView, "Product added successfully");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this.addBaseProductView, "Could not add the product");
                }
            }
        });

        this.addCompositeProductView.backButtonListener(e -> {
            if(e.getSource() == this.addCompositeProductView.getBackButton()) {
                this.addCompositeProductView.setVisible(false);
                this.addBaseProductView.setVisible(true);
            }
        });

        this.addCompositeProductView.addButtonListener(e -> {
            if(e.getSource() == this.addCompositeProductView.getAddButton()) {
                MenuItem menuItem = deliveryService.searchByTitle(menuItems, this.addCompositeProductView.getCompositeName());
                System.out.println(menuItem);
                if(menuItem == null) {
                    CompositeProduct compositeProduct = new CompositeProduct(this.addCompositeProductView.getCompositeName());
                    System.out.println(compositeProduct);
                    deliveryService.addProduct(compositeProduct);
                    for(MenuItem m : menuItems) {
                        if(m.getTitle().equals(compositeProduct.getTitle())) {
                            System.out.println("found");
                            break;
                        }
                    }
                    menuItem = deliveryService.searchByTitle(menuItems, this.addCompositeProductView.getCompositeName());
                    System.out.println(menuItem);
                }
                int index = this.addCompositeProductView.getTable().getSelectedRow();
                String title = menuItems.get(index).getTitle();
                MenuItem menuItem1 = deliveryService.searchByTitle(menuItems, title);
                deliveryService.addInComposite(menuItem, menuItem1);
            }
        });

        this.editProductView.editButtonListener(e -> {
            if(e.getSource() == this.editProductView.getEditButton()) {
                try {
                    menuItems = deliveryService.getMenuItems();

                    int index = this.editProductView.getTable().getSelectedRow();
                    String title = menuItems.get(index).getTitle();
                    String newTitle = this.editProductView.getNewTitle();
                    float rating = this.editProductView.getRating();
                    int calories = this.editProductView.getCalories();
                    int protein = this.editProductView.getProtein();
                    int fat = this.editProductView.getFat();
                    int sodium = this.editProductView.getSodium();
                    float price = this.editProductView.getPrice();

                    index = 0;
                    for(int i=0; i<menuItems.size(); i++) {
                        if(menuItems.get(i).getTitle().equals(title)) {
                            index = i;
                            break;
                        }
                    }

                    deliveryService.editMenuItem(menuItems, title, newTitle, rating, calories, protein, fat, sodium, price);
                    this.editProductView.getModel().setValueAt(newTitle, index, 0);
                    this.editProductView.getModel().setValueAt(rating, index, 1);
                    this.editProductView.getModel().setValueAt(calories, index, 2);
                    this.editProductView.getModel().setValueAt(protein, index, 3);
                    this.editProductView.getModel().setValueAt(fat, index, 4);
                    this.editProductView.getModel().setValueAt(sodium, index, 5);
                    this.editProductView.getModel().setValueAt(price, index, 6);

                    this.administratorGUI.getDefaultTableModel().setValueAt(newTitle, index, 0);
                    this.administratorGUI.getDefaultTableModel().setValueAt(rating, index, 1);
                    this.administratorGUI.getDefaultTableModel().setValueAt(calories, index, 2);
                    this.administratorGUI.getDefaultTableModel().setValueAt(protein, index, 3);
                    this.administratorGUI.getDefaultTableModel().setValueAt(fat, index, 4);
                    this.administratorGUI.getDefaultTableModel().setValueAt(sodium, index, 5);
                    this.administratorGUI.getDefaultTableModel().setValueAt(price, index, 6);
                    JOptionPane.showMessageDialog(this.editProductView, "Product edited successfully");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this.editProductView, "Could not edit the product");
                    exception.printStackTrace();
                }
            }
        });

        this.editProductView.backButtonListener(e -> {
            if(e.getSource() == this.editProductView.getBackButton()) {
                this.administratorGUI.setVisible(true);
                this.editProductView.setVisible(false);
            }
        });

        this.clientGUI.showButtonListener(e -> {
            if(e.getSource() == this.clientGUI.getShowButton()) {
                menuItems = deliveryService.getMenuItems();
                this.clientGUI.getDefaultTableModel().getDataVector().removeAllElements();
                this.clientGUI.getDefaultTableModel().fireTableDataChanged();
                for(MenuItem menuItem : menuItems) {
                    this.clientGUI.getDefaultTableModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.clientGUI.searchButtonListener(e -> {
            if(e.getSource() == this.clientGUI.getSearchButton()) {
                ArrayList<MenuItem> all = new ArrayList<>();
                if(!(this.clientGUI.getTitleField().equals(""))) {
                    MenuItem menuItemTitle = deliveryService.searchByTitle(menuItems, this.clientGUI.getTitleField());
                    all.add(menuItemTitle);
                }
                if(!(this.clientGUI.getRating().equals(""))) {
                    ArrayList<MenuItem> ratings = deliveryService.searchByRating(menuItems, this.clientGUI.getRatingFiled());
                    all.addAll(ratings);
                }
                if(!(this.clientGUI.getCalories().equals(""))) {
                    ArrayList<MenuItem> calories = deliveryService.searchByCalories(menuItems, this.clientGUI.getCaloriesField());
                    all.addAll(calories);
                }
                if(!(this.clientGUI.getProtein().equals(""))) {
                    ArrayList<MenuItem> proteins = deliveryService.searchByProtein(menuItems, this.clientGUI.getProteinField());
                    all.addAll(proteins);
                }
                if(!(this.clientGUI.getFat().equals(""))) {
                    ArrayList<MenuItem> fats = deliveryService.searchByFat(menuItems, this.clientGUI.getFatField());
                    all.addAll(fats);
                }
                if(!(this.clientGUI.getSodium().equals(""))) {
                    ArrayList<MenuItem> sodium = deliveryService.searchBySodium(menuItems, this.clientGUI.getSodiumField());
                    all.addAll(sodium);
                }
                if(!(this.clientGUI.getPrice().equals(""))) {
                    ArrayList<MenuItem> prices = deliveryService.searchByPrice(menuItems, this.clientGUI.getPriceField());
                    all.addAll(prices);
                }
                this.clientGUI.getDefaultTableModel().getDataVector().removeAllElements();
                this.clientGUI.getDefaultTableModel().fireTableDataChanged();
                for(MenuItem menuItem : all) {
                    System.out.println(menuItem);
                    this.clientGUI.getDefaultTableModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.clientGUI.orderButton(e -> {
            if(e.getSource() == this.clientGUI.getOrderButton()) {
                this.clientGUI.setVisible(false);
                this.orderView.setVisible(true);
                this.orderView.getDefaultTableModel().getDataVector().removeAllElements();
                this.orderView.getDefaultTableModel().fireTableDataChanged();
                for(MenuItem menuItem : menuItems) {
                    this.orderView.getDefaultTableModel().addRow(
                            new Object[]{menuItem.getTitle(), menuItem.getRating(), menuItem.getCalories(), menuItem.getProtein(),
                                    menuItem.getFat(), menuItem.getSodium(), menuItem.getPrice()});
                }
            }
        });

        this.clientGUI.backButtonListener(e -> {
            if(e.getSource() == this.clientGUI.getBackButton()) {
                this.clientGUI.setVisible(false);
                this.logInView.setVisible(true);
            }
        });

        this.orderView.addButtonListener(e -> {
            if(e.getSource() == this.orderView.getAddButton()) {
                int index = this.orderView.getTable().getSelectedRow();
                String title = menuItems.get(index).getTitle();
                MenuItem menuItem = deliveryService.searchByTitle(menuItems, title);
                orderItems.add(menuItem);
            }
        });

        this.orderView.backButtonListener(e -> {
            if(e.getSource() == this.orderView.getBackButton()) {
                this.orderView.setVisible(false);
                this.clientGUI.setVisible(true);
            }
        });

        this.orderView.orderButtonListener(e -> {
            if(e.getSource() == this.orderView.getOrderButton()) {
                orders = deliveryService.getOrders();
                idOrder = orders.size();
                idOrder++;

                float totalPrice = 0;
                for(MenuItem menuItem : orderItems) {
                    totalPrice += menuItem.computePrice();
                }

                Order order = new Order(idOrder, currentClientAccount.getId(), LocalDateTime.now(), totalPrice, orderItems);
                deliveryService.addOrder(order, orderItems);

                try {
                    FileWriter fileWriter = new FileWriter("bill" + order.getOrderID() + ".txt");
                    StringBuilder text = new StringBuilder("Order with id " + order.getOrderID() + " for client with id " + order.getClientID()
                            + " in total of " + totalPrice + " on date: " + order.getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
                            + "\n" + "Products: \n");
                    for(MenuItem menuItem : orderItems) {
                        text.append(menuItem.getTitle()).append("\n");
                    }
                    fileWriter.write(text.toString());

                    JOptionPane.showMessageDialog(this.orderView, "Order placed successfully");

                    this.employeeGUI.update();
                    this.employeeGUI.setTextArea(text.toString());

                    fileWriter.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this.orderView, "Some error occurred");
                    exception.printStackTrace();
                }

                orderItems.removeAll(orderItems);
            }
        });
    }

    public static void main(String[] args) {
        AdministratorGUI administratorGUI = new AdministratorGUI();
        LogInView logInView = new LogInView();
        AddBaseProductView addBaseProductView = new AddBaseProductView();
        EditProductView editProductView = new EditProductView();
        ClientGUI clientGUI = new ClientGUI();
        AddCompositeProductView addCompositeProductView = new AddCompositeProductView();
        FirstReportView firstReportView = new FirstReportView();
        SecondReportView secondReportView = new SecondReportView();
        ThirdReportView thirdReportView = new ThirdReportView();
        ForthReportView forthReportView = new ForthReportView();
        OrderView orderView = new OrderView();
        EmployeeGUI employeeGUI = new EmployeeGUI();
        DeliveryService deliveryService = new DeliveryService();
        logInView.setVisible(true);
        new Controller(administratorGUI, logInView, addBaseProductView, editProductView, clientGUI, addCompositeProductView,
                firstReportView, secondReportView, thirdReportView, forthReportView, orderView, employeeGUI, deliveryService);
    }
}
