package businessLayer;

public class BaseProduct extends MenuItem {
    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private float price;

    public BaseProduct() {
    }

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, float price) {
        super(title, rating, calories, protein, fat, sodium, price);
    }

    public void setTitle(String title) {
        super.setTitle(title);
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
    public float computePrice() {
        return getPrice();
    }

    @Override
    public float computeRating() {
        return getRating();
    }

    @Override
    public int computeCalories() {
        return getCalories();
    }

    @Override
    public int computeProtein() {
        return getProtein();
    }

    @Override
    public int computeFat() {
        return getFat();
    }

    @Override
    public int computeSodium() {
        return getSodium();
    }

    @Override
    public void add(MenuItem p) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BaseProduct))
            return false;
        if (!super.equals(o))
            return false;
        BaseProduct that = (BaseProduct) o;
        return this.getTitle().equals(that.title);
    }

}