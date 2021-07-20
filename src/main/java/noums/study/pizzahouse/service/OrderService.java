package noums.study.pizzahouse.service;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.domain.OrderEntity;
import noums.study.pizzahouse.domain.OrderJpaRepository;
import noums.study.pizzahouse.manager.KitchenManager;
import noums.study.pizzahouse.manager.PizzaManager;
import noums.study.pizzahouse.pay.PayManager;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    final private KitchenManager kitchenManager;
    final private PayManager payManager;
    final private OrderJpaRepository repository;

    public String order(OrderRequest req) {
        // 주문
    	OrderEntity orderEntity = new OrderEntity();
    	int cnt = req.getCount();
    	orderEntity.setMenu(req.getMenu());
    	orderEntity.setCount(cnt);
    	orderEntity.setPrice(req.getMenu().getPrice() * cnt);
    	repository.save(orderEntity);
        // 결제
        payManager.doPayProcess(req.getPay(), req.getMenu().getPrice());
        // 제조
        kitchenManager.makeFood(req.getMenu());
        return "complete";
    }


}
