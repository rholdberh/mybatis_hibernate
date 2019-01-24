package com.mybatis;

public class Payment {
    private Long id;
    private Integer summa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSumma() {
        return summa;
    }

    public void getSumma(Integer summa) {
        this.summa = summa;
    }
}
