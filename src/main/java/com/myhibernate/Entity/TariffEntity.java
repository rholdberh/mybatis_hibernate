package com.myhibernate.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TARIFF", schema = "SCHEMA_TEST_ROMAN", catalog = "")
public class TariffEntity {
    private long id;
    private String descr;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCR", nullable = false, length = 255)
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TariffEntity that = (TariffEntity) o;
        return id == that.id &&
                Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descr);
    }
}
