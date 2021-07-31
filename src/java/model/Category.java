package model;

public class Category {

    int ID;
    String category;

    public Category() {
    }

    public Category(String[] parts) {
        this(parts[0], parts[1]);
    }

    public Category(String ID, String category) {
        this.ID = Integer.parseInt(ID.trim());
        this.category = category.trim();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
