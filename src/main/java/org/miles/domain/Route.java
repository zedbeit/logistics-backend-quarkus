package org.miles.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "route")
public class Route extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Size(max = 255)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Route{" + "name=" + name + ", state=" + state + '}';
    }
    
}
