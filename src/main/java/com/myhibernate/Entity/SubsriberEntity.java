package com.myhibernate.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SUBSRIBER", schema = "SCHEMA_TEST_ROMAN", catalog = "")
public class SubsriberEntity {
    private long id;
    private String name;
    private String refTariff;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "REF_TARIFF", nullable = true, length = 10)
    public String getRefTariff() {
        return refTariff;
    }

    public void setRefTariff(String refTariff) {
        this.refTariff = refTariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubsriberEntity that = (SubsriberEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(refTariff, that.refTariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, refTariff);
    }
}
