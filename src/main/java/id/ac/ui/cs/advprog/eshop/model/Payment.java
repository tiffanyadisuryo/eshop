package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class Payment {
    String id;
    String method;
    Map<String, String> paymentData;
    Order order;
    String status;

    public Payment(String id, String method, Order order,  Map<String, String>paymentData){
        this(method, order, paymentData);
        this.id = id;
    }

    public Payment(String method, Order order, Map<String, String>paymentData){
        this.id = UUID.randomUUID().toString();
        this.method = method;
        this.order = order;
        this.setStatus(order.getStatus());
        this.setPaymentData(paymentData);
    }

    public void setStatus(String status){
        if(PaymentStatus.contains(status)){
            if(status.equals("REJECTED")){
                this.status ="FAILED";
                return;
            }
            this.status=status;
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void setPaymentData(Map<String, String> paymentData){
        if(PaymentMethod.contains(this.method)){
            this.paymentData=paymentData;
        }else{
            throw new IllegalArgumentException();
        }
    }
}