package dbObjects;

import java.sql.Connection;
import java.util.List;

public class Subscriber {
    private Long id;
    private String name;
    private String refTariff;
//    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefTariff() {
        return refTariff;
    }

    public void setRefTariff(String refTariff) {
        this.refTariff = refTariff;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tariff=" + refTariff +
                '}';
    }

    //    public List<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(List<Payment> payments) {
//        this.payments = payments;
//    }

}
