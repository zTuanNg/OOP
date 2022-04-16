public class Product {

    private static int cnt;
    private int id;
    private String name;
    private String desc;
    private int quantity;
    private Long price;
    private String unit;

    {
        id = ++cnt;
    }

    public Product(String name, String desc, int quantity, Long price, String unit) {

        this.name = name;
        this.desc = desc;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
    }

    // toString

    @Override
    public String toString() {
        return String.format("--ID: %d\nName: %s\nDesc: %s\nQuantity: %s\nPrice: %s\nUnit: %s",
                this.id, this.name, this.desc, this.quantity, this.price, this.unit);
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
