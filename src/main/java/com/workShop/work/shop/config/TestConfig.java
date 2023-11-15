package com.workShop.work.shop.config;

import com.workShop.work.shop.model.CategoryModel;
import com.workShop.work.shop.model.OrderModel;
import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.model.enums.OrderStatus;
import com.workShop.work.shop.repositories.CategoryRepository;
import com.workShop.work.shop.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {
        UserModel u1 = new UserModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserModel u2 = new UserModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        OrderModel o1 = new OrderModel(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        OrderModel o2 = new OrderModel(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        OrderModel o3 = new OrderModel(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);

        CategoryModel cat1 = new CategoryModel(null, "Electronics");
        CategoryModel cat2 = new CategoryModel(null, "Books");
        CategoryModel cat3 = new CategoryModel(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
