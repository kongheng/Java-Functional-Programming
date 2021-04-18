package util;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dob;

    public Customer(String customerName, String customerPhone) {
        this.name = customerName;
        this.email = customerPhone;
    }

    private Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Customer() {}

    public Supplier<List<Customer>> customerList = () ->
            List.of(
              new Customer("sok", "sok@gmail.com", "+0123456", LocalDate.of(1995, 3, 7)),
              new Customer("soa", "soa@gmail.com", "+01235648787", LocalDate.of(2000, 3, 7)),
              new Customer("dara", "dara@gmail.com", "0235648787", LocalDate.of(2007, 3, 7))
            );

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }

    private static class CustomerHelper {
        private static final Customer customerInstance = new Customer();
    }
    public static Supplier<Customer> createInstance = () -> CustomerHelper.customerInstance;
}
