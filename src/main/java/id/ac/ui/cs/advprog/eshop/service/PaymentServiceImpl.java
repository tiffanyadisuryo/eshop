package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData){
        if (paymentRepository.findById(order.getId()) == null){
            Payment payment = new Payment(order.getId(), method, order, paymentData);
            paymentRepository.save(payment);
            return payment;
        }
        return null;
    }
    @Override
    public Payment setStatus(Payment payment, String status){
        payment.setStatus(status);
        if (payment.getStatus().equals(PaymentStatus.SUCCESS.getValue())){
            payment.getOrder().setStatus(OrderStatus.SUCCESS.getValue());
        }else if(payment.getStatus().equals(PaymentStatus.REJECTED.getValue())){
            payment.getOrder().setStatus(OrderStatus.FAILED.getValue());
        }
        return payment;
    }
    @Override
    public Payment getPayment(String id){
        return paymentRepository.findById(id);
    }
    @Override
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

}
