import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {

    static Scanner sc;
    static ProductService service;
    static List<Product> products;

    public ProductController() {
        sc = new Scanner(System.in);
        service = new ProductService();
        products = service.readData();
    }

    public static void run(){
        while(true) {
            menu();
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    showInfoByCategory();
                    break;
                case 2:
                    showProductByCompany();
                    break;

                case 3:
                    showProductByCategoryAndPrice();
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
                    break;
            }
        }

    }

    public static void menu(){
        System.out.println("Choice this option: ");
        System.out.println("1 - In thông tin dựa trên danh mục");
        System.out.println("2 - In thông tin các sản phẩm dựa theo hãng và số sản phẩm của hãng");
        System.out.println("3 - In thông tin sản phẩm dựa trên mức giá và danh mục");
        System.out.println("0 - Exit");
    }

    public static void submenu(){
        System.out.println("Choice this option: ");
        System.out.println("1 - Điện thoại");
        System.out.println("2 - Laptop");
        System.out.println("3 - Apple");
        System.out.println("4 - Phụ kiện");
    }

    public static void submenu1(){
        System.out.println("Choice this option: ");
        System.out.println("1 - Apple");
        System.out.println("2 - Samsung");
        System.out.println("3 - Belkin");
        System.out.println("4 - Asus");
        System.out.println("5 - HP");
        System.out.println("4 - ESR");

    }

    public static void priceMenu(){
        System.out.println("Các mức giá:");
        System.out.println("1 - Dưới 2 triệu");
        System.out.println("2 - Từ 2 - 4 triệu");
        System.out.println("3 - Từ 4 - 7 triệu");
        System.out.println("4 - Từ 7 - 13 triệu");
        System.out.println("5 - Trên 13 triệu");

    }

    public static int input(){
        System.out.println("Enter input: ");
        int input = Integer.parseInt(sc.nextLine());
        return input;
    }
    public static void showInfoByCategory(){
        submenu();
        System.out.println("Enter your choice: ");
        int input = input();
        List<Product> result = new ArrayList<>();
        switch (input){
            case 1:
                result = service.findProductByCategory(products,"Điện thoại");
                service.show(result);
                break;
            case 2:
                result = service.findProductByCategory(products,"Laptop");
                service.show(result);
                break;
            case 3:
                result = service.findProductByCategory(products,"Apple");
                service.show(result);
                break;
            case 4:
                result = service.findProductByCategory(products,"Phụ kiện");
                service.show(result);
                break;
            default:
                System.out.println("Khong co lua chon nay");
                break;
        }
    }

    public static void showProductByCompany(){

        submenu1();
        System.out.println("Enter your choice: ");
        int input = input();
        List<Product> result = new ArrayList<>();
        switch (input){
            case 1:
                result = service.findProductByCompany(products,"Apple");
                System.out.printf("Apple co %s loai san pham\n",result.size());
                service.show(result);
                break;
            case 2:
                result = service.findProductByCategory(products,"Samsung");
                System.out.printf("Samsung co %s loai san pham\n",result.size());
                service.show(result);
                break;
            case 3:
                result = service.findProductByCategory(products,"Belkin");
                System.out.printf("Belkin co %s loai san pham\n",result.size());
                service.show(result);
                break;
            case 4:
                result = service.findProductByCategory(products,"Asus");
                System.out.printf("Asus co %s loai san pham\n",result.size());
                service.show(result);
                break;
            case 5:
                result = service.findProductByCategory(products,"HP");
                System.out.printf("HP co %s loai san pham\n",result.size());
                service.show(result);
                break;
            case 6:
                result = service.findProductByCategory(products,"ESR");
                System.out.printf("ESR co %s loai san pham\n",result.size());
                service.show(result);
                break;
            default:
                System.out.println("Khong co lua chon nay");
                break;
        }
    }

    public static void showProductByCategoryAndPrice(){
        submenu1();
        System.out.println("Enter category: ");
        String category = sc.nextLine();
        priceMenu();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(sc.nextLine());
        List<Product> result;
        switch (price){
            case 1:
                result = service.findProductByCategory(products,category);
                result = service.findProductByLowerPrice(result,new BigDecimal(2000000));
                service.show(result);
                break;
            case 2:
                result = service.findProductByCategory(products,category);
                result = service.findProductByPrice(result,new BigDecimal(2000000),new BigDecimal(4000000));
                service.show(result);
                break;
            case 3:
                result = service.findProductByCategory(products,category);
                result = service.findProductByPrice(result,new BigDecimal(4000000),new BigDecimal(7000000));
                service.show(result);
                break;
            case 4:
                result = service.findProductByCategory(products,category);
                result = service.findProductByPrice(result,new BigDecimal(7000000),new BigDecimal(13000000));
                service.show(result);
                break;
            case 5:
                result = service.findProductByCategory(products,category);
                result = service.findProductByUpperPrice(result,new BigDecimal(13000000));
                System.out.println(result.size());
                service.show(result);
                break;
            default:
                System.out.println("Khong co lua chon nay");
                break;
        }

    }

}
