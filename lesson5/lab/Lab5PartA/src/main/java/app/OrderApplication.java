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
        Customer customer = new Customer("John", "Doe", "Mainstreet 1", "New York", "43221");
        // product
        Product product = new Product("Java", "Java book", 35.50);
        // address
        Address address = new Address("Mainstreet 1", "New York", "43221");
        // order
        Order order = new Order( "open");
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
        CD cd = new CD( "Java", "John 17", 35.50, "John");
//        DVD dvd = new DVD( "Java", "John 17", 35.50, "Action");
//        Bookp bookp = new Bookp( "Java", "John 17", 35.50, "12345");

        productRepository.save(cd);
	}
}
