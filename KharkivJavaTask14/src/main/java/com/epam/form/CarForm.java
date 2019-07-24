package com.epam.form;

public class CarForm {

    private Integer idCar;
    private Integer days;

    public CarForm() {
    }

    public CarForm(Integer idCar, Integer days) {
        this.idCar = idCar;
        this.days = days;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

}
