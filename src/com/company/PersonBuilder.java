package com.company;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder() {
        age = OptionalInt.empty();
    }

    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }

        if (name.equals("")) {
            throw new IllegalArgumentException("name is empty");
        }

        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("surname is null");
        }

        if (surname.equals("")) {
            throw new IllegalArgumentException("surname is empty");
        }

        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age must be more than 0");
        }

        if (age > 120) {
            throw new IllegalArgumentException("age must be less than 120");
        }

        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.equals("")) {
            throw new IllegalStateException("name must have a value");
        }

        if (surname == null || surname.equals("")) {
            throw new IllegalStateException("surname must have a value");
        }

        return new Person(name, surname, age, address);
    }
}
