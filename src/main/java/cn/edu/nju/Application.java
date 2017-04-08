package cn.edu.nju;

import cn.edu.nju.utility.Customer;
import cn.edu.nju.dataservice.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Qiang
 * @since 07/04/2017
 */
@EnableScheduling
@SpringBootApplication
public class Application{

//    private final CustomerRepository repository;
//
//    @Autowired
//    public Application(CustomerRepository repository) {
//        this.repository = repository;
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        this.repository.deleteAll();
//        saveCustomers();
//        fetchAllCustomers();
//        fetchIndividualCustomers();
//    }
//
//    private void saveCustomers() {
//        this.repository.save(new Customer("Alice", "Smith"));
//        this.repository.save(new Customer("Bob", "Smith"));
//    }
//
//    private void fetchAllCustomers() {
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Customer customer : this.repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//    }
//
//    private void fetchIndividualCustomers() {
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(this.repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : this.repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }
//    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}