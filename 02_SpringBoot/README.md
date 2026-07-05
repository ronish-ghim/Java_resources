# Module 02 — Spring Boot

## Sub-programs

### 1. e-commerce

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/StoreApplication.java`

```java
package com.codewithmosh.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/entities/Address.java`

```java
package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/entities/Category.java`

```java
package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

    public Category(byte id) {
        this.id = id;
    }
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/entities/Product.java`

```java
package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/entities/Profile.java`

```java
package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private User user;
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/entities/User.java`

```java
package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Profile profile;

    @ManyToMany
    @JoinTable(
        name = "wishlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> favoriteProducts = new HashSet<>();

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/repositories/AddressRepository.java`

```java
package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/repositories/CategoryRepository.java`

```java
package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/repositories/ProductRepository.java`

```java
package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/repositories/ProfileRepository.java`

```java
package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
```

**Path:** `e-commerce/src/main/java/com/codewithmosh/store/repositories/UserRepository.java`

```java
package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
```

### 2. store

**Path:** `store/store/src/main/java/com/ronss/store/HomeController.java`

```java
package com.ronss.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    // @Value("${spring.application.name}")
    // private String appName;

    // @Value("${server.port}")
    // private String serverPortFromApplicationDotProperties;

    @GetMapping("/")
    public String Index() {
        // System.out.println("Entered in Index controller");
        String viewName = getViewName();
        return viewName;
    }

    private String getViewName() {
        return "index.html";
    }
}
```

**Path:** `store/store/src/main/java/com/ronss/store/OrderService.java`

```java
package com.ronss.store;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired // use @Autowired to inject PaymentService in case of multiple constructors
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public OrderService() {
    }

    public void placeOrder() {

        paymentService.processPayment(100);
    }
}
```

**Path:** `store/store/src/main/java/com/ronss/store/PaymentService.java`

```java
package com.ronss.store;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void processPayment(double amount);

}
```

**Path:** `store/store/src/main/java/com/ronss/store/PaypalPaymentService.java`

```java
package com.ronss.store;

import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPAL");
        System.out.println("Processing PayPal payment of $" + amount);
    }

}
```

**Path:** `store/store/src/main/java/com/ronss/store/StoreApplication.java`

```java
package com.ronss.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(StoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		// orderService.setPaymentService(context.getBean(PaymentService.class));
		// var orderService = new OrderService(new PaypalPaymentService());

		orderService.placeOrder();
	}

}
```

**Path:** `store/store/src/main/java/com/ronss/store/StripePaymentService.java`

```java
package com.ronss.store;

// @Service
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.printf("Amount: %.2f ", amount);
    }
}
```
