package noums.study.pizzahouse.service;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.entity.OrderInfo;
import noums.study.pizzahouse.food.manager.KitchenManager;
import noums.study.pizzahouse.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    final private KitchenManager manager;
    final private PayService payService;
    final private OrderRepository repository;

    public String order(OrderRequest req) {
        OrderInfo order = new OrderInfo();
        order.setCount(req.getCount());
        order.setMenus(req.getMenus());
        order.setTotalPrice(req.getCount() * req.getMenus().getPrice());
        repository.save(order);
        // 주문
        // ...
        // 결제
        payService.pay(req.getPayMethod(), req.getMenus().getPrice());
        // 제조
        manager.makeFood(req.getMenus());
        return "complete";
    }

}
