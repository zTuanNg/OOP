import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    //Read Data
    public List<Product> readData(){
        Gson gson = new Gson();
        List<Product> lst = new ArrayList<>();
        try {
            FileReader reader = new FileReader("FPT_shop/data.json");
            lst = gson.fromJson(reader,new TypeToken<List<Product>>(){}.getType());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return lst;
    }
    // Show info
    public void show(List<Product> lst){
        lst.forEach(System.out::println);
    }

    // find product by category
    public List<Product> findProductByCategory(List<Product>lst,String kw){
//          List<Product> rs = new ArrayList<>();
          kw = kw.substring(0,1).toUpperCase()+ kw.substring(1).toLowerCase();
        System.out.println(kw);
          try{
              String finalKw = kw;
              return lst.stream().filter(p->p.getCategory().contains(finalKw)).collect(Collectors.toList ());
          }catch (Exception e){
              return null;
          }

        }


    // find product by company
    public List<Product> findProductByCompany(List<Product>lst, String kw){
        try {
            return lst.stream().filter(p->p.getCompany().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    // find product by price
    public List<Product> findProductByPrice(List<Product>lst, BigDecimal lowerPrice, BigDecimal upperPrice){
        try{
            return lst.stream().filter(p->new BigDecimal(p.getPrice()).compareTo(lowerPrice)>=0 && new BigDecimal(p.getPrice()).compareTo(upperPrice)<=0).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public List<Product> findProductByLowerPrice(List<Product>lst, BigDecimal price){
        try{
            return lst.stream().filter(p->new BigDecimal(p.getPrice()).compareTo(price)<=0).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public List<Product> findProductByUpperPrice(List<Product>lst, BigDecimal price){
        try{
            return lst.stream().filter(p->(new BigDecimal(p.getPrice())).compareTo(price)>=0).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
    public List<Product> findProductByName(List<Product>lst, String kw){
        try {
            return lst.stream().filter(p->p.getName().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public Map<String,Integer> countProductByCompany(List<Product>lst){
        List<String>l1 = new ArrayList<>();
        for(Product p : lst){
            l1.add(p.getCompany());
        }
        Set<String> set = new HashSet(l1);
        Map<String, Integer> map = new HashMap<>();
        for(String company : set){
            int count = (int) lst.stream().filter(m->m.getCompany().toLowerCase().contains(company.toLowerCase())).count();
            map.put(company, count);
        }
        return map;
    }





}
