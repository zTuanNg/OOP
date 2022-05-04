import java.math.BigDecimal;
import java.util.List;

public class Product {

    private int id;
    private String name;
    private String desc;
    private String price;
    private int quantity;
    private int sold;
    private String company;
    private List<String> category;

    public Product(){};

    public Product(int id, String name, String desc,String price, int quantity, int sold, String company, List<String> category) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
        this.company = company;
        this.category = category;
    }

    @Override
    public String toString() {
        return "--Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                ", sold=" + sold +
                ", company='" + company + '\'' +
                ", category=" + category +
                '}';
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
