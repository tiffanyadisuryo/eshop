package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
    @Spy
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;
    List<Order> orders;
    List<Product> products;

    @BeforeEach
    void setUp(){
        products = new ArrayList<>();
        orders = new ArrayList<>();
        payments = new ArrayList<>();

        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductQuantity(3);
        product.setProductName("Sampo Cap Bambang");
        products.add(product);

        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products,
                1708560000L, "Safira Sudarajat");
        orders.add(order);

        Map<String, String> paymentDataVoucher = new HashMap<>();
        paymentDataVoucher.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER", orders.get(0),
                paymentDataVoucher);
        payments.add(payment1);

        Map<String, String> paymentDataBank = new HashMap<>();
        paymentDataBank.put("bankName", "ABC");
        paymentDataBank.put("referenceCode","123");
        Payment payment2 = new Payment("13652556-012a-4c07-b546-54eb1396d79b","BANK", orders.get(0),
                paymentDataBank);
        payments.add(payment2);
    }

    @Test
    void testAddPaymentVoucher(){
        Payment payment =  payments.get(1);
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result  = paymentService.addPayment(payments.get(1).getOrder(), PaymentMethod.VOUCHER.getValue(), payment.getPaymentData());
        assertSame(payment.getId(), result.getId());
    }

    @Test
    void testAddPaymentBank(){
        Payment payment =  payments.get(1);
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result  = paymentService.addPayment(payments.get(1).getOrder(), PaymentMethod.BANK.getValue(), payment.getPaymentData());
        assertSame(payment.getId(), result.getId());
    }

    @Test
    void testSetStatus(){
        Payment payment = payments.get(1);
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment newPayment = new Payment("13652556-012a-4c07-b546-54eb1396d79b","VOUCHER",
                orders.get(0), paymentData);

        Payment result = paymentService.setStatus(payment, PaymentStatus.SUCCESS.getValue());

        assertEquals(payment.getId(), result.getId());
        assertEquals(PaymentStatus.SUCCESS.getValue(), result.getStatus());
    }

    @Test
    void testGetPaymentByIdIfIdNotFound(){
        doReturn(null).when(paymentRepository).findById("zczc");
        assertNull(paymentService.getPayment("zczc"));
    }

    @Test
    void testGetAllPayment(){
        doReturn(payments).when(paymentRepository).findAll();
        List<Payment> payment = paymentService.getAllPayments();
        assertSame(payments,payment);
    }

}
