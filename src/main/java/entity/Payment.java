package entity;

import enums.PaymentStatus;

import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate = LocalDate.now();
    private Subscription subscriptionEditions;
    private PaymentStatus paymentStatus;

    public Payment(Subscription subscriptionEditions) {
        this.subscriptionEditions = subscriptionEditions;
        this.paymentStatus = PaymentStatus.WAITED;
    }

    public Subscription getSubscriptionEditions() {
        return subscriptionEditions;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", subscriptionEditions=" + subscriptionEditions +
                '}';
    }

}
