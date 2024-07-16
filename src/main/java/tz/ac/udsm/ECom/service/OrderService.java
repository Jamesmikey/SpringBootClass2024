package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.*;
import tz.ac.udsm.ECom.repository.OrderLineRepository;
import tz.ac.udsm.ECom.repository.OrderRepository;
import tz.ac.udsm.ECom.repository.ProductRepository;
import tz.ac.udsm.ECom.repository.UserRepository;

import java.util.List;

@Service
public class OrderService {


    private final OrderRepository repository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final OrderLineRepository orderLineRepository;

    public OrderService(OrderRepository repository, UserRepository userRepository, ProductRepository productRepository, OrderLineRepository orderLineRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
    }



    @Transactional
    public Order save(Order order) throws DataNotFoundException {

        //Check customer if exists
        User customer=userRepository.findById(order.getCustomer().getId()).orElseThrow(() -> new DataNotFoundException("Customer not found"));

        order.setCustomer(customer);

        Order savedOrder= repository.save(order);

        //Check products if exists in the database
        for(OrderLine orderLine:order.getOrderLines()){
            Product dbProduct=productRepository.findById(orderLine.getProduct().getId()).orElseThrow(() -> new DataNotFoundException("Product with ID "+orderLine.getProduct().getId()+" not found"));
            orderLine.setPrice(dbProduct.getPrice());
            orderLine.setProduct(dbProduct);
            orderLine.setOrder(savedOrder);
        }

        orderLineRepository.saveAll(order.getOrderLines());

        return savedOrder;

    }

    public Page<Order> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void update(Long id, Order updateOrder) throws DataNotFoundException {
        //Find order by id
        Order order=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Order not found"));

        //Check products if exists in the database
//        List<Product> dbProducts=new ArrayList<>();
//        for(Product product:order.getProducts()){
//            Product dbProduct=productRepository.findById(product.getId()).orElseThrow(() -> new DataNotFoundException("Product with ID "+product.getId()+" not found"));
//            dbProducts.add(dbProduct);
//        }
//
//        order.setProducts(dbProducts);

        repository.save(order);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find order by id
        Order order=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Order not found"));

        repository.delete(order);
    }

    public Order findById(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Order not found"));
    }

    public List<OrderLine> findAllOrderLines(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        Order order = repository.findById(id).orElseThrow(()->new DataNotFoundException("Order not found"));

        return order.getOrderLines();

    }

}
