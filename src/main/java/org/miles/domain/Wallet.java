package org.miles.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "wallet")
public class Wallet extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 255)
    @Column(name = "total_balance")
    private String totalBalance;
    
    @Size(max = 255)
    @Column(name = "wallet_address")
    private String walletAddress;
    
    @OneToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    private List<Payment> payments;
    
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Card> cards;
    
    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Wallet{" + "totalBalance=" + totalBalance + ", walletAddress=" + walletAddress + ", userAccount=" + userAccount + ", payments=" + payments + ", cards=" + cards + '}';
    }
    
}
