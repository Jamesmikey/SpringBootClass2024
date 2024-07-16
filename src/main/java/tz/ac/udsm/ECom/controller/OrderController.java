package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.order.CreateOrderDTO;
import tz.ac.udsm.ECom.dto.order.FetchListOrderDTO;
import tz.ac.udsm.ECom.dto.order.OrderDetailDTO;
import tz.ac.udsm.ECom.dto.order.UpdateOrderDTO;
import tz.ac.udsm.ECom.dto.product.FetchListProductDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Order;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService service;

    private final ModelMapper modelMapper;

    public OrderController(OrderService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public OrderDetailDTO create(@RequestBody @Valid CreateOrderDTO createOrderDTO) throws DataNotFoundException {

        Order order=modelMapper.map(createOrderDTO,Order.class);

        return modelMapper.map(service.save(order),OrderDetailDTO.class);
    }

    @GetMapping
    public Page<FetchListOrderDTO> findAll(Pageable pageable){

        Page<Order> orders= service.findAll(pageable);

        return orders.map(category -> modelMapper.map(category, FetchListOrderDTO.class));

    }

    @GetMapping("/{id}/products")
    public List<FetchListProductDTO> findAllProducts(@PathVariable Long id) throws DataNotFoundException {

        List<Product> products= service.findAllProducts(id);

        return products.stream().map(product -> modelMapper.map(product, FetchListProductDTO.class)).collect(Collectors.toList());

    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Long id, @RequestBody @Valid UpdateOrderDTO updateOrderDTO) throws DataNotFoundException {

        Order order=modelMapper.map(updateOrderDTO,Order.class);

        service.update(id,order);

        return "Order updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "Order deleted successfully";
    }

    @GetMapping("/{id}")
    public OrderDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
        return modelMapper.map(service.findById(id),OrderDetailDTO.class);
    }

}
