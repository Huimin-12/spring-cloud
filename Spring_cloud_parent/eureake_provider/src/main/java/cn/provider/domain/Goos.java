package cn.provider.domain;

public class Goos {

    private int id ;
    private String name;
    private int money;
    private int sale;

    public Goos() {
    }

    public Goos(int id, String name, int money, int sale) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
