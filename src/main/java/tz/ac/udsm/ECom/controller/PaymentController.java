package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.payment.CreatePaymentDTO;
import tz.ac.udsm.ECom.dto.payment.FetchListPaymentDTO;
import tz.ac.udsm.ECom.dto.payment.PaymentDetailDTO;
import tz.ac.udsm.ECom.dto.payment.UpdatePaymentDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.exception.InvalidAmountException;
import tz.ac.udsm.ECom.model.Payment;
import tz.ac.udsm.ECom.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {


    private final PaymentService service;

    private final ModelMapper modelMapper;

    public PaymentController(PaymentService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public PaymentDetailDTO create(@RequestBody @Valid CreatePaymentDTO createPaymentDTO) throws DataNotFoundException, InvalidAmountException {

        Payment payment=modelMapper.map(createPaymentDTO,Payment.class);

        return modelMapper.map(service.save(payment),PaymentDetailDTO.class);
    }

    @GetMapping
    public Page<FetchListPaymentDTO> findAll(Pageable pageable){

        Page<Payment> payments= service.findAll(pageable);

        return payments.map(category -> modelMapper.map(category, FetchListPaymentDTO.class));

    }

//    @PutMapping("/{id}")
//    public String edit(@PathVariable Long id, @RequestBody @Valid UpdatePaymentDTO updatePaymentDTO) throws DataNotFoundException {
//
//        Payment payment=modelMapper.map(updatePaymentDTO,Payment.class);
//
//        service.update(id,payment);
//
//        return "Payment updated successfully";
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "Payment deleted successfully";
    }

    @GetMapping("/{id}")
    public PaymentDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
        return modelMapper.map(service.findById(id),PaymentDetailDTO.class);
    }

}
