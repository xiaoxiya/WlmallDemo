package mongodb;

import mongodb.orders.Item;
import mongodb.orders.Order;
import mongodb.orders.config.MongoConfig;
import mongodb.orders.db.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/20 22:36
 */
@ContextConfiguration(classes = MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoDbTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    MongoOperations mongoOps;

    @Before
    public void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    public void testMongoRepository() {
        Assert.assertEquals(0, orderRepository.count());
        Order order = createAnOrder();

        Order saveOrder = orderRepository.save(order);
        Assert.assertEquals(1, orderRepository.count());

        Order foundOrder = orderRepository.findOne(saveOrder.getId());
        Assert.assertEquals("Chuck Wagon", foundOrder.getCustomer());
        Assert.assertEquals(2, foundOrder.getItems().size());

        List<Order> chuckOrders = orderRepository.findByCustomer("Chuck Wagon");
        Assert.assertEquals(1, chuckOrders.size());
        Assert.assertEquals("Chuck Wagon", chuckOrders.get(0).getCustomer());
        Assert.assertEquals(2, chuckOrders.get(0).getItems().size());

        List<Order> chuckLikeOrders = orderRepository.findByCustomerLike("Chuck");
        Assert.assertEquals(1, chuckLikeOrders.size());
        Assert.assertEquals("Chuck Wagon", chuckLikeOrders.get(0).getCustomer());
        Assert.assertEquals(2, chuckLikeOrders.get(0).getItems().size());

        List<Order> chucksWebOrders = orderRepository.findByCustomerAndType("Chuck Wagon", "WEB");
        Assert.assertEquals(1, chucksWebOrders.size());
        Assert.assertEquals("Chuck Wagon", chucksWebOrders.get(0).getCustomer());
        Assert.assertEquals(2, chucksWebOrders.get(0).getItems().size());

        List<Order> chucksPhoneOrders = orderRepository.findByCustomerAndType("Chuck Wagon", "PHONE");
        Assert.assertEquals(0, chucksPhoneOrders.size());

        List<Order> chucksOrders2 = orderRepository.findChucksOrders();
        Assert.assertEquals(1, chucksOrders2.size());
        Assert.assertEquals("Chuck Wagon", chucksOrders2.get(0).getCustomer());
        Assert.assertEquals(2, chucksOrders2.get(0).getItems().size());

    }

    private Order createAnOrder() {
        Order order = new Order();
        order.setCustomer("Chuck Wagon");
        order.setType("WEB");
        Item item1 = new Item();
        item1.setProduct("Spring in Action");
        item1.setQuantity(2);
        item1.setPrice(29.99);
        Item item2 = new Item();
        item2.setProduct("Module Java");
        item2.setQuantity(31);
        item2.setPrice(29.35);
        order.setItems(Arrays.asList(item1, item2));
        return order;
    }

}
