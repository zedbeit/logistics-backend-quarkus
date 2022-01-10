package org.miles.service.dto;

import java.math.BigDecimal;
import org.miles.lang.enums.RequestStatus;

public class RequestDTO {
    public RequestStatus status;
    public String senderFirstName;
    public String senderLastName;
    public String recieverFirstName;
    public String recieverLastName;
    public String senderEmail;
    public String senderPhone;
    public String recieverEmail;
    public String recieverPhone;
    public String deliverySourceAddress;
    public String deliveryDestinationAddress;
    public BigDecimal amount;
    public String paymentType;
    public String senderAddress;
    public String recieverAddress;
    public Boolean isPaid;
}
