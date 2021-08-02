package org.miles.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authority")
public class Authority extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Size(max = 45)
    private String name;
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Authority)) {
            return false;
        }
        return Objects.equals(name, ((Authority) o).name);
    }

    @Override
    public String toString() {
        return "Authority{" + "name=" + name + '}';
    }
}
