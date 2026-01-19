package cz.alzbeta.cryptoportfolio.model;

public class Crypto {

    private Integer id;
    private String name;
    private String symbol;
    private Double price;
    private Double quantity;


    public Crypto() {
    }

    public Crypto(Integer id, String name, String symbol, Double quantity, Double price) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
