package org.miles.lang.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "card")
public class Card extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 255)
    @Column(name = "card_number")
    private String cardNumber;
    
    @Size(max = 255)
    @Column(name = "expiry_date")
    private String expiryDate;
    
    @Size(max = 255)
    private String cvv;
    
    @Size(max = 255)
    private String pin;
    
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Payment> payments;
    
    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Card{" + "cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", pin=" + pin + ", payments=" + payments + ", wallet=" + wallet + '}';
    }
    
    
}
