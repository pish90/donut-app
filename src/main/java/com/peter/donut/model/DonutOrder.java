package com.peter.donut.model;

public class DonutOrder {
    private String firstName;
    private String surname;
    private String orderDate;
    private String collectionDate;
    private int numberOfDonuts;
    private int cinnamonCount;
    private int jamCount;
    private int creamCount;
    private int sprinklesCount;

    public DonutOrder() {
    }

    public DonutOrder(String firstName, String surname, String orderDate, String collectionDate, int numberOfDonuts) {
        this.firstName = firstName;
        this.surname = surname;
        this.orderDate = orderDate;
        this.collectionDate = collectionDate;
        this.numberOfDonuts = numberOfDonuts;
    }

    public DonutOrder(String firstName, String surname, String collectionDate, int numberOfDonuts) {
        this.firstName = firstName;
        this.surname = surname;
        this.collectionDate = collectionDate;
        this.numberOfDonuts = numberOfDonuts;
    }

    public DonutOrder(String firstName, String surname, String orderDate, String collectionDate, int cinnamonCount, int jamCount, int creamCount, int sprinklesCount) {
        this.firstName = firstName;
        this.surname = surname;
        this.orderDate = orderDate;
        this.collectionDate = collectionDate;
        this.cinnamonCount = cinnamonCount;
        this.jamCount = jamCount;
        this.creamCount = creamCount;
        this.sprinklesCount = sprinklesCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public int getNumberOfDonuts() {
        return numberOfDonuts;
    }

    public void setNumberOfDonuts(int numberOfDonuts) {
        this.numberOfDonuts = numberOfDonuts;
    }

    public int getCinnamonCount() {
        return cinnamonCount;
    }

    public void setCinnamonCount(int cinnamonCount) {
        this.cinnamonCount = cinnamonCount;
    }

    public int getJamCount() {
        return jamCount;
    }

    public void setJamCount(int jamCount) {
        this.jamCount = jamCount;
    }

    public int getCreamCount() {
        return creamCount;
    }

    public void setCreamCount(int creamCount) {
        this.creamCount = creamCount;
    }

    public int getSprinklesCount() {
        return sprinklesCount;
    }

    public void setSprinklesCount(int sprinklesCount) {
        this.sprinklesCount = sprinklesCount;
    }

    @Override
    public String toString() {
        return collectionDate + ',' +
                firstName + ' ' +
                surname + ',' +
                cinnamonCount + ',' +
                jamCount + ',' +
                creamCount + ',' +
                sprinklesCount + '\n';
    }
}
