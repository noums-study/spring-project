package noums.study.pizzahouse.controller;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.domain.OrderEntity;
import noums.study.pizzahouse.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders/menu")
public class MenuController {

    final private MenuService menuService;

    @GetMapping
    public List<OrderEntity> getMenu(){
        // 캐시가 있으면 캐시에서 읽고, 캐시 없으면 생성
        System.out.println(">>> MenuController");
        List<OrderEntity> menu =  menuService.getOrderMenu();
//        String result = menu.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
//        System.out.println(">>> getMenu :: "+result);
        return menu;
    }

    @PostMapping
    public void menuUpdate(@RequestBody OrderRequest menuRequest){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setPrice(menuRequest.getMenu().getPrice());
        orderEntity.setMenu(menuRequest.getMenu());
        orderEntity.setCount(menuRequest.getCount());

        System.out.println(">>> MenuController : menuUpdate");
        OrderEntity menu = menuService.updateMenu(orderEntity);
        System.out.println(">>> MenuController : " + menu.toString());
    }

    @DeleteMapping
    public String deleteMenu(){
       String result =  menuService.deleteMenu();
       return result;
    }


}
