package main.java;
public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getID() { return ID; }
    public double getCost() { return cost; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

    // Methods
    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }

    public String toJSON() {
        return "{ \"name\": \"" + name + "\", \"description\": \"" + description + "\", \"ID\": \"" + ID + "\", \"cost\": " + cost + " }";
    }

    public String toXML() {
        return "<Product><name>" + name + "</name><description>" + description + "</description><ID>" + ID + "</ID><cost>" + cost + "</cost></Product>";
    }

    @Override
    public String toString() {
        return name + " (" + ID + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.cost, cost) == 0 && name.equals(product.name) && description.equals(product.description) && ID.equals(product.ID);
    }
}
