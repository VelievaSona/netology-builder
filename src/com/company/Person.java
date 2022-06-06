package com.company;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this(name, surname, OptionalInt.empty(), null);
    }

    public Person(String name, String surname, int age) {
        this(name, surname, age, null);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, OptionalInt.of(age), address);
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must have a value");
        }

        if (surname == null || surname.equals("")) {
            throw new IllegalArgumentException("surname must have a value");
        }

        if (age.isPresent()) {
            int ageInt = age.getAsInt();
            if (ageInt < 0 || ageInt > 120) {
                throw new IllegalArgumentException("age must be more than 0 and less than 120");
            }
        }

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null && address != "";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isEmpty()) {
            return;
        }

        age = OptionalInt.of(age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
