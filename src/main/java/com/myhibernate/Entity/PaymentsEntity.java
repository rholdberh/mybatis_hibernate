package com.myhibernate.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAYMENTS", schema = "SCHEMA_TEST_ROMAN", catalog = "")
public class PaymentsEntity {
    private long id;
    private long refSubscriber;
    private long summa;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REF_SUBSCRIBER", nullable = false, precision = 0)
    public long getRefSubscriber() {
        return refSubscriber;
    }

    public void setRefSubscriber(long refSubscriber) {
        this.refSubscriber = refSubscriber;
    }

    @Basic
    @Column(name = "SUMMA", nullable = false, precision = 0)
    public long getSumma() {
        return summa;
    }

    public void setSumma(long summa) {
        this.summa = summa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentsEntity that = (PaymentsEntity) o;
        return id == that.id &&
                refSubscriber == that.refSubscriber &&
                summa == that.summa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refSubscriber, summa);
    }
}
