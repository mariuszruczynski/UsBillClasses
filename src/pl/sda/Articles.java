package pl.sda;

public class Articles {
    private String name;
    private int number;
    private double cost;

    public Articles(String name, int number, double cost) {
        this.name = name;
        this.number = number;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
