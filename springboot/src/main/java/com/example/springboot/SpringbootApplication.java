package com.example.springboot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.bean.interfaces.IBean;
import com.example.springboot.bean.interfaces.IBeanWithDependency;
import com.example.springboot.bean.interfaces.IBeanWithProperties;
import com.example.springboot.components.interfaces.IComponent;
import com.example.springboot.entity.User;
import com.example.springboot.pojo.UserPojo;
import com.example.springboot.repository.interfaces.IUserRepository;
import com.example.springboot.service.UserService;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    private Log LOGGER = LogFactory.getLog(this.getClass());

    private IComponent component;
    private IBean bean;
    private IBeanWithDependency beanWithDependency;
    private IBeanWithProperties beanWithProperties;
    private IUserRepository userRepository;
    private UserService userService;
    private UserPojo userPojo;

    public SpringbootApplication(IComponent component, IBean bean, IBeanWithDependency beanWithDependency,
            IBeanWithProperties beanWithProperties, IUserRepository userRepository, UserPojo userPojo,
            UserService userService) {
        this.component = component;
        this.bean = bean;
        this.beanWithDependency = beanWithDependency;
        this.beanWithProperties = beanWithProperties;
        this.userRepository = userRepository;
        this.userPojo = userPojo;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ejemplosAnteriores();
        saveUsersInDatabase();
        getInformationJPQLFromUser();
        saveWithErrorTransactional();
    }

    private void saveWithErrorTransactional() {
        List<User> users = Arrays.asList(
                new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now()),
                new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now()),
                new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now()),
                new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now()));

        try {
            userService.saveTransactional(users);
        } catch (Exception e) {
            LOGGER.error("Esta es una excepcion dentro del metodo transational" + e);
        }
        userService.getAllUsers().forEach(LOGGER::info);
    }

    private void getInformationJPQLFromUser() {
        // try {
        // LOGGER.info("Usuario con el metodo findByEmail" +
        // userRepository.findByEmail("john@domain.com")
        // .orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
        // userRepository.findAndSort("user", Sort.by("id").descending())
        // .forEach(LOGGER::info);
        // userRepository.findByNameContainingIgnoreCase("USER").forEach(LOGGER::info);

        // LOGGER.info("Usuario encontrado por fecha y email: "
        // + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 3, 13),
        // "john@domain.com")
        // .orElseThrow(() -> new RuntimeException("Email y Fechas no encontrados")));

        // } catch (Exception e) {
        // LOGGER.error("No se encontro el usuario por email", e);
        // }
    }

    private void saveUsersInDatabase() {
        List<User> list = Arrays.asList(
                new User("John", "john@domain.com", LocalDate.of(2021, 3, 13)),
                new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8)),
                new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8)),
                new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18)),
                new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1)),
                new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7)),
                new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12)),
                new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27)),
                new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10)),
                new User("user1", "user1@domain.com", LocalDate.of(2021, 4, 10)),
                new User("user2", "user2@domain.com", LocalDate.of(2021, 4, 10)),
                new User("user3", "user3@domain.com", LocalDate.of(2021, 4, 10)),
                new User("user4", "user4@domain.com", LocalDate.of(2021, 4, 10)),
                new User("user5", "user5@domain.com", LocalDate.of(2021, 4, 10)));
        list.forEach(userRepository::save);
    }

    @SuppressWarnings("unused")
    private void ejemplosAnteriores() {
        component.saludar();
        bean.print();
        beanWithDependency.printWithDependency();
        System.out.println(beanWithProperties.function());
        System.out.println(userPojo.toString());
        LOGGER.error("Esto es un error en el aplicativo");
    }
}
