package org.miles.lang.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.miles.lang.enums.TripStatus;

@Entity
@Table(name = "trip")
public class Trip extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TripStatus status;
    
    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    private Request request;
    
    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id")
    private Rider rider;
    
    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public String toString() {
        return "Trip{" + "status=" + status + ", request=" + request + ", rider=" + rider + '}';
    }
}
