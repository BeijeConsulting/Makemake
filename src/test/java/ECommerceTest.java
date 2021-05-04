import it.beije.makemake.myDatabase.JPAManager;
import it.beije.makemake.myDatabase.ecommerce.ECommerce;
import it.beije.makemake.myDatabase.ecommerce.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ECommerceTest {

    public static void main(String[] args) {
        ECommerce.printProductList();
        System.out.println();
        ECommerce.printUserList();

        //testing order creation
//        HashMap<Integer, Integer> orderData = new HashMap<>();
//        orderData.put(2,3);
//        orderData.put(3, 5);
//        ECommerce.createNewOrder(1, orderData);

        //testing getOrderDetails(Order order)
        System.out.println(ECommerce.getOrderDetails(2));
    }

}
