package businessLayer;

import java.io.Serializable;
import java.util.Objects;

public abstract class MenuItem implements Serializable {
    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private float price;

    public MenuItem() {
    }

    public MenuItem(String title, float rating, int calories, int protein, int fat, int sodium, float price) {
        this.setTitle(title);
        this.setRating(rating);
        this.setCalories(calories);
        this.setProtein(protein);
        this.setFat(fat);
        this.setSodium(sodium);
        this.setPrice(price);
    }

    public abstract float computePrice();

    public abstract float computeRating();

    public abstract int computeCalories();

    public abstract int computeProtein();

    public abstract int computeFat();

    public abstract int computeSodium();

    public abstract void add(MenuItem p);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return getTitle() + " " + getRating() + " " + getCalories() + " " + getProtein() + " " + getFat() + " "
                + getSodium() + " " + getPrice() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MenuItem))
            return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(title, menuItem.title);
    }

}