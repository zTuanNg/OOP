import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    // Show list product
    public void showProduct(List<Product>p){
        p.forEach(h-> System.out.println(h));
    }

    // Add product
    public void addProduct(List<Product>lst, Product p) {
        lst.add(p);
    }

    // Find product by name
    public List<Product> findProductByName(List<Product>lst, String kw){

        try {
            return lst.stream().filter(p->p.getName().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }


    }

    // Find product by ID
    public Product findProductById(List<Product>lst, int id){
//        Product p = null;
        try {
            return lst.stream().filter(h->h.getId()==id).findAny().get();
        }
        catch (Exception e){
            return null;
        }


    }

    // Remove product
    public void removeProduct(List<Product>lst, Product p){
        lst.remove(p);
    }

    // Update product's quantity
    public void updateQuantity(Product p, int quantity){
        p.setQuantity(quantity);
    }

    // Find product with quantity < X
    public List<Product> findProductWithQuantityLessThanX(List<Product>lst,int x){
        try {
            return lst.stream().filter(p->p.getQuantity()<x).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

    // Find product by price

    public List<Product> findProductWithPriceLessThanX(List<Product>lst,long x){
        try{
            return lst.stream().filter(p->p.getPrice()<x).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Product> findProductWithPriceFromXToY(List<Product>lst, long x, long y){
        try {
            return lst.stream().filter(p-> p.getPrice() < y || p.getPrice()>=x).collect(Collectors.toList());
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Product> findProductWithPriceMoreThanX(List<Product>lst, long x){
        try {
            return lst.stream().filter(p-> p.getPrice()>x).collect(Collectors.toList());
        }
        catch (Exception e){
            return null;
        }
    }
}
