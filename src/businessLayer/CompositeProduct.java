package businessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {
    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private float price;
    private final ArrayList<MenuItem> list = new ArrayList<>();

    public CompositeProduct(String title) {
        super(title, 0, 0, 0, 0, 0, 0);
    }

    public float computePrice() {
        float x = 0;
        for (MenuItem menuItem : list) {
            x += menuItem.getPrice();
        }
        super.setPrice(x);
        return x;
    }

    @Override
    public  float computeRating() {
        int x = 0;
        int i=0;
        for (MenuItem menuItem : list) {
            x += menuItem.getRating();
            i++;
        }
        super.setRating(x/i);
        return x;
    }


    @Override
    public  int computeCalories(){
        int x = 0;
        for (MenuItem menuItem : list) {
            x += menuItem.getCalories();
        }
        super.setCalories(x);
        return x;
    }
    @Override
    public  int computeProtein(){
        int x = 0;
        for (MenuItem menuItem : list) {
            x += menuItem.getProtein();
        }
        super.setProtein(x);
        return x;
    }
    @Override
    public  int computeFat(){
        int x = 0;
        for (MenuItem menuItem : list) {
            x += menuItem.getFat();
        }
        super.setFat(x);
        return x;
    }
    @Override
    public  int computeSodium(){
        int x = 0;
        for (MenuItem menuItem : list) {
            x += menuItem.getSodium();
        }
        super.setSodium(x);
        return x;
    }


    public void setPrice(float price) {
        super.setPrice(price);
    }

    public void setRating(float rating) {
        super.setRating(rating);
    }

    public void setCalories(int calories) {
        super.setCalories(calories);
    }

    public void setProtein(int protein) {
        super.setProtein(protein);
    }

    public void setFat(int fat) {
        super.setFat(fat);
    }

    public void setSodium(int sodium) {
        super.setSodium(sodium);
    }

    @Override
    public void add(MenuItem p) {
        list.add(p);
    }
}