package noums.study.pizzahouse.service;

import noums.study.pizzahouse.domain.OrderEntity;
import noums.study.pizzahouse.domain.OrderJpaRepository;
import noums.study.pizzahouse.enums.FoodMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderJpaRepository repository;

    @Test
    public void getMenu(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCount(1);
        orderEntity.setMenu(FoodMenu.BULGOGI_PIZZA);
        orderEntity.setPrice(FoodMenu.BULGOGI_PIZZA.getPrice());
        //orderEntity.setId(1234);
        repository.save(new OrderEntity());
        List<OrderEntity> menu = menuService.getOrderMenu();

        System.out.println(menuService.getOrderMenu());
        System.out.println(menuService.getOrderMenu());
        System.out.println(menuService.getOrderMenu());

        assertEquals(1, menu.size());
    }

    @Test
    public void update(){


    }
}