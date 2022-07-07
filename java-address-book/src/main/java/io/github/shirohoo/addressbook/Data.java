package io.github.shirohoo.addressbook;

import java.util.Objects;
import java.util.UUID;

public final class Data {
    public final String id;
    public final String name;
    public final String gender;
    public final int age;
    public final String phoneNumber;
    public final String address;

    private Data(
            String id,
            String name,
            String gender,
            int age,
            String phoneNumber,
            String address
    ) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public static DataBuilder builder() {
        return new DataBuilder();
    }

    @Override
    public String toString() {
        return """
                {"id": "%s", "name": "%s", "gender": "%s", "age": %d, "phoneNumber": "%s", "address": "%s"}
                """.formatted(id, name, gender, age, phoneNumber, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data that = (Data) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, phoneNumber, address);
    }

    public final static class DataBuilder {
        private String id;
        private String name;
        private String gender;
        private int age;
        private String phoneNumber;
        private String address;

        public DataBuilder id(UUID id) {
            if (id == null) {
                this.id = UUID.randomUUID().toString();
                return this;
            }
            this.id = id.toString();
            return this;
        }

        public DataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DataBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public DataBuilder age(int age) {
            this.age = age;
            return this;
        }

        public DataBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DataBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Data build() {
            return new Data(id, name, gender, age, phoneNumber, address);
        }
    }
}
