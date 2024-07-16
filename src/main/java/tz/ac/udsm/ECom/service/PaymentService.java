package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.exception.InvalidAmountException;
import tz.ac.udsm.ECom.model.Order;
import tz.ac.udsm.ECom.model.OrderLine;
import tz.ac.udsm.ECom.model.Payment;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.repository.OrderRepository;
import tz.ac.udsm.ECom.repository.PaymentRepository;

@Service
public class PaymentService {


    private final PaymentRepository repository;

    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }


    public Payment save(Payment payment) throws DataNotFoundException, InvalidAmountException {

        Order order = orderRepository.findById(payment.getOrder().getId()).orElseThrow(() -> new DataNotFoundException("Order not found"));

        double total=0;
        for(OrderLine orderLine:order.getOrderLines()){
            total=(orderLine.getPrice()* orderLine.getQuantity())+total;
        }

        //Check amount to pay
        if(payment.getAmount()<total){
            throw new InvalidAmountException("Amount provided is less than required: "+total);
        }

        return repository.save(payment);

    }

    public Page<Payment> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void update(Long id, Payment updatePayment) throws DataNotFoundException {
        //Find payment by id
        Payment payment=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Payment not found"));


        repository.save(payment);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find payment by id
        Payment payment=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Payment not found"));

        repository.delete(payment);
    }

    public Payment findById(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Payment not found"));
    }

}
