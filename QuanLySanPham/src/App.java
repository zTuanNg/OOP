import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static <exception> void main(String[] args) {


        ProductService service = new ProductService();
        List<Product> lst = new ArrayList<>();

        // Add product
        service.addProduct(lst, new Product("Earphone","New",10, 110000L,"pcs"));
        service.addProduct(lst, new Product("Pen","New",20, 11000L,"pcs"));
        service.addProduct(lst, new Product("Cup","New",40, 510000L,"pcs"));

        while(true) {
            mainMenu();
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1:
                    System.out.println("=== List product ===");
                    service.showProduct(lst);
                    backToMain();
                    break;

                case 2:
                    System.out.println(" === Find list product by name ===");
                    System.out.println("Enter name's product you want to find: ");
                    String kw = sc.nextLine();
                    List<Product> rs = service.findProductByName(lst,kw);
//                    System.out.println("rs"+rs);
                    if(rs.size() != 0){
                        service.showProduct(rs);
                    }
                    else{
                        System.out.println("Can not found this name");
                    }
                    backToMain();
                    break;

                case 3:
                    System.out.println("=== Find product by ID ===");
                    System.out.println("Enter ID you want to find: ");
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                        Product p = service.findProductById(lst,choice);
                        if(p != null) {
                            System.out.println(p);
                            subMenu2();
                            choice = Integer.parseInt(sc.nextLine());
                            if(choice == 1){
                                service.removeProduct(lst,p);
                            }
                            if(choice == 2){
                                System.out.println("Enter new quantity: ");
                                int quantity = Integer.parseInt(sc.nextLine());
                                service.updateQuantity(p,quantity);
                                System.out.println(p);
                            }
                            if(choice == 3){
                                break;
                            }

                        }
                        else {
                            System.out.println("Can not find this ID");
                        }
                        backToMain();
                    }catch (Exception e) {
                        System.out.println("ID must be Integer");
                        backToMain();
                    }
                    break;
                case 4:
                    System.out.println("=== Find products with quantity less than 5 === ");

                    List<Product> rs1 = service.findProductWithQuantityLessThanX(lst,5);
                    if(rs1.size() != 0){
                        service.showProduct(rs1);
                    }else{
                        System.out.println("Can not find product with quantity < 5");
                    }
                    backToMain();
                    break;

                case 5:
                    System.out.println("=== Find products with price less than 50K === ");
                    List<Product> rs2 = service.findProductWithPriceLessThanX(lst,50000);
                    if(rs2.size() != 0){
                        service.showProduct(rs2);
                    }else{
                        System.out.println("Can not find product with price < 50K");
                    }
                    backToMain();
                    break;
                case 6:
                    System.out.println("=== Find products with price more than 100K === ");
                    List<Product> rs3 = service.findProductWithPriceMoreThanX(lst,100000);
                    if(rs3.size() != 0){
                        service.showProduct(rs3);
                    }else{
                        System.out.println("Can not find product with price > 100K");
                    }
                    backToMain();
                    break;

                case 7:
                    System.out.println("=== Find products with price more than 100K === ");
                    List<Product> rs4 = service.findProductWithPriceFromXToY(lst,50000,10000);
                    if(rs4.size() != 0){
                        service.showProduct(rs4);
                    }else{
                        System.out.println("Can not find product with price between 50K and 100K");
                    }
                    backToMain();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please try again!");
                    break;
            }
        }


    }

    public static void mainMenu(){
        System.out.println("--------------------------------");
        System.out.println("----- [MAIN MENU] -----");
        System.out.println("Select this Option: ");

        System.out.println("1 - Show list products");
        System.out.println("2 - Find products by Name");
        System.out.println("3 - Find product by ID");
        System.out.println("4 - Find products with quantity less than 5");
        System.out.println("5 - Find products with price less than 50K");
        System.out.println("6 - Find products with price more than 100K");
        System.out.println("7 - Find products with price from 50k to 100k");
        System.out.println("0 - Exit");
    }

    public static void subMenu(){
        System.out.println("Select this Option: ");
        System.out.println("1 - Remove product");
        System.out.println("2 - Update quantity");
        System.out.println("3 - Back to main menu");
    }

    public static void subMenu1(){
        System.out.println("--------------------------------");
        System.out.println("==>  Enter 0 to main menu");
    }

    public static void subMenu2(){
        System.out.println("1 - Remove this product");
        System.out.println("2 - Update quantity");
        System.out.println("3 - Back to main menu");
    }

    public static void backToMain() {
        subMenu1();
        System.out.println("Enter your choice: ");
        int choice = 0;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("You must choice Integer number");
            choice = 1;
        }

        while (choice != 0) {
            System.out.println("Please choice agian");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("You must choice Integer number");
                choice = 1;
            }
            if (choice == 0) {
                break;
            }
        }
    }



}
