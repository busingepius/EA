package app;

import domain.Customer;
import domain.Order;
import domain.OrderLine;
import domain.Product;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.DepartmentRepository;
import repositories.EmployeeRepository;
import repositories.PublisherRepository;

import domain.Department;
import domain.Employee;
import domain.Flight;
import domain.Passenger;
import domain.Book;
import domain.Publisher;
import domain.School;
import domain.Student;

import domain.Customer;
import domain.Order;
import domain.OrderLine;
import domain.Product;
import domain.Address;
import domain.CD;
import domain.DVD;
import domain.Bookp;


import repositories.BookRepository;
import repositories.PublisherRepository;
import repositories.FlightRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;
import repositories.StudentRepository;

import repositories.CustomerRepository;
import repositories.OrderRepository;
import repositories.OrderLineRepository;
import repositories.ProductRepository;
import repositories.AddressRepository;

import repositories.CDRepository;
import repositories.DVDRepository;
import repositories.BookpRepository;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import specifications.OrderSpecification;
import specifications.CustomerSpecification;
import specifications.CDSpecification;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CDRepository cdRepository;


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


// department and their employees
        Department department = new Department("IT");
        Employee employee = new Employee("John");

        department.setEmployees(employee);
        employee.setDepartment(department);

//        departmentRepository.save(department);
//        employeeRepository.save(employee);

        // book and its publisher
        Book book = new Book("1234", "Java", "John 17");
        Publisher publisher = new Publisher("John 17");


        book.setPublisher(publisher);
//        publisherRepository.save(publisher); // no need to save the publisher directly because it is saved when the book is saved
        bookRepository.save(book);

        // passenger and the flight they are on
        Passenger passenger = new Passenger("John");
        Flight flight = new Flight("1234", "Lagos", "London");

        passenger.setFlight(flight);
        flightRepository.save(flight);
        passengerRepository.save(passenger);

        // student and their schools
        School school = new School("University of Lagos");
        Student student = new Student("John", "Doe");

        school.setStudent(student);
        studentRepository.save(student);
        schoolRepository.save(school);

        // customer
        Customer customer = new Customer("John", "Doe", "Mainstreet 1", "New York", "43221", "USA");
        // product
        Product product = new Product("Java", "Java book", 35.50);
        // address
        Address address = new Address("Mainstreet 1", "New York", "43221", "USA");
        // order
        Order order = new Order("open");
        // orderline
        OrderLine orderLine = new OrderLine(2, product);

        customer.setAddress(address);
//        address.setCustomer(customer);
//        product.setOrderLine(orderLine);
        orderLine.setProduct(product);
        order.addOrderLine(orderLine);
        order.setCustomer(customer);
        customer.addOrder(order);

        // order matters save the entities in the right order
        addressRepository.save(address);

        productRepository.save(product);
        orderLineRepository.save(orderLine);
        customerRepository.save(customer);
        orderRepository.save(order);

        // inheritanced
        CD cd = new CD("Java", "John 17", 35.50, "John");
        DVD dvd = new DVD("Rocky3", "John 17", 35.50, "Action");
        Bookp bookp = new Bookp("Java Book", "John 17", 35.50, "12345");

        productRepository.save(cd);
        productRepository.save(dvd);
        productRepository.save(bookp);


        // Get all customers.
        customerRepository.findAll().forEach(System.out::println);
        // Get all CD’s from U2 with a price smaller than 10 euro
        cdRepository.findByPriceLessThan(10).forEach(System.out::println);
        // Get all customers with zip code 2389HJ
        customerRepository.findByZip("2389HJ").forEach(System.out::println);
        // Get all customers who ordered a DVD with the name Rocky3
        customerRepository.findByDVDName("Rocky3").forEach(System.out::println);
        // Give all customers from the USA.
        customerRepository.findByCountry("USA").forEach(System.out::println);
        // Give all CD’s from a certain artist
        cdRepository.findByArtist("John").forEach(System.out::println);
        // //    Give the ordernumbers of all orders with status ‘closed’
        orderRepository.findByStatus("closed").forEach(System.out::println);
        // Give the first and lastnames of all customers who live in Amsterdam.
        customerRepository.findByCity("Amsterdam").forEach(System.out::println);
        //Give the ordernumbers of all orders from customers who live in a certain city (city is parameter)
        orderRepository.findByCity("New York").forEach(System.out::println);
        // Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2)
        cdRepository.findByArtistAndPriceGreaterThan("John", 1).forEach(System.out::println);
        // Native Query. Give all addresses in Amsterdam.
        addressRepository.findByCity("Amsterdam").forEach(System.out::println);
//        // Native Query. Give all CD’s from U2
//        cdRepository.findByArtistt("John").forEach(System.out::println);

        // Using Specifications. Give the ordernumbers of all orders with status ‘closed’
        orderRepository.findAll(OrderSpecification.isClosedOrOpen("open")).forEach(System.out::println);

        // Using Specifications. Give all customers who live in Amsterdam.
        customerRepository.findAll(CustomerSpecification.fromCity("Amsterdam")).forEach(System.out::println);

        // Using Specifications. Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2)
        System.out.println("-".repeat(50));
        cdRepository.findAll(CDSpecification.isPriceGreaterThan(1)).forEach(System.out::println);
    }
}
