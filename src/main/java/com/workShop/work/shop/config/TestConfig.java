package com.workShop.work.shop.config;

import com.workShop.work.shop.model.CategoryModel;
import com.workShop.work.shop.model.OrderModel;
import com.workShop.work.shop.model.ProductModel;
import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.model.enums.OrderStatus;
import com.workShop.work.shop.repositories.CategoryRepository;
import com.workShop.work.shop.repositories.OrderRepository;
import com.workShop.work.shop.repositories.ProductRepository;
import com.workShop.work.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        UserModel u1 = new UserModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserModel u2 = new UserModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        OrderModel o1 = new OrderModel(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        OrderModel o2 = new OrderModel(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        OrderModel o3 = new OrderModel(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        CategoryModel cat1 = new CategoryModel(null, "Electronics");
        CategoryModel cat2 = new CategoryModel(null, "Books");
        CategoryModel cat3 = new CategoryModel(null, "Computers");

        ProductModel p1 = new ProductModel(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductModel p2 = new ProductModel(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductModel p3 = new ProductModel(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductModel p4 = new ProductModel(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductModel p5 = new ProductModel(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4,p5));
    }
}
