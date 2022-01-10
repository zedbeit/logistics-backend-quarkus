package org.miles.lang.entity;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.miles.company.entity.Company;
import org.miles.generaluser.entity.GeneralUser;
import org.miles.lang.enums.RequestStatus;

@Entity
@Table(name = "request")
public class Request extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    
    @Size(max = 255)
    @Column(name = "sender_first_name")
    private String senderFirstName;
    
    @Size(max = 255)
    @Column(name = "sender_last_name")
    private String senderLastName;
    
    @Size(max = 255)
    @Column(name = "reciever_first_name")
    private String recieverFirstName;
    
    @Size(max = 255)
    @Column(name = "reciever_last_name")
    private String recieverLastName;
    
    @Size(max = 255)
    @Column(name = "sender_email")
    private String senderEmail;
    
    @Size(max = 255)
    @Column(name = "sender_phone")
    private String senderPhone;
    
    @Size(max = 255)
    @Column(name = "reciever_email")
    private String recieverEmail;
    
    @Size(max = 255)
    @Column(name = "reciever_phone")
    private String recieverPhone;
    
    @Size(max = 255)
    @Column(name = "delivery_source_address")
    private String deliverySourceAddress;
    
    @Size(max = 255)
    @Column(name = "delivery_destination_address")
    private String deliveryDestinationAddress;
    
    private BigDecimal amount;
    
    @Size(max = 45)
    @Column(name = "payment_type")
    private String paymentType;
    
    @Size(max = 255)
    @Column(name = "sender_address")
    private String senderAddress;
    
    @Size(max = 255)
    @Column(name = "reciever_address")
    private String recieverAddress;
    
    @Column(name = "is_paid")
    private Boolean isPaid;
    
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name = "general_user_id", referencedColumnName = "id")
    private GeneralUser generalUser;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "request")
    private Trip trip;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "request")
    private Payment payment;
    
    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getRecieverFirstName() {
        return recieverFirstName;
    }

    public void setRecieverFirstName(String recieverFirstName) {
        this.recieverFirstName = recieverFirstName;
    }

    public String getRecieverLastName() {
        return recieverLastName;
    }

    public void setRecieverLastName(String recieverLastName) {
        this.recieverLastName = recieverLastName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getRecieverEmail() {
        return recieverEmail;
    }

    public void setRecieverEmail(String recieverEmail) {
        this.recieverEmail = recieverEmail;
    }

    public String getRecieverPhone() {
        return recieverPhone;
    }

    public void setRecieverPhone(String recieverPhone) {
        this.recieverPhone = recieverPhone;
    }

    public String getDeliverySourceAddress() {
        return deliverySourceAddress;
    }

    public void setDeliverySourceAddress(String deliverySourceAddress) {
        this.deliverySourceAddress = deliverySourceAddress;
    }

    public String getDeliveryDestinationAddress() {
        return deliveryDestinationAddress;
    }

    public void setDeliveryDestinationAddress(String deliveryDestinationAddress) {
        this.deliveryDestinationAddress = deliveryDestinationAddress;
    }

    

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public GeneralUser getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(GeneralUser generalUser) {
        this.generalUser = generalUser;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Request{" + "status=" + status + ", senderFirstName=" + senderFirstName + ", senderLastName=" + senderLastName + ", recieverFirstName=" + recieverFirstName + ", recieverLastName=" + recieverLastName + ", senderEmail=" + senderEmail + ", senderPhone=" + senderPhone + ", recieverEmail=" + recieverEmail + ", recieverPhone=" + recieverPhone + ", deliverySourceAddress=" + deliverySourceAddress + ", deliveryDestinationAddress=" + deliveryDestinationAddress + ", amount=" + amount + ", paymentType=" + paymentType + ", senderAddress=" + senderAddress + ", recieverAddress=" + recieverAddress + ", isPaid=" + isPaid + ", company=" + company + ", generalUser=" + generalUser + ", trip=" + trip + ", payment=" + payment + '}';
    }
}
