package mongodb.orders.db;

import mongodb.orders.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/20 22:29
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByCustomer(String customer);

    List<Order> findByCustomerLike(String customer);

    List<Order> findByCustomerAndType(String customer, String type);

    List<Order> getByType(String type);

    @Query("{customer:'Chuck Wagon'}")
    List<Order> findChucksOrders();

}
