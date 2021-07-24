package noums.study.pizzahouse.food.maker.pizza;

import noums.study.pizzahouse.enums.Menus;
import org.springframework.stereotype.Component;

@Component
public class BulgogiMaker implements PizzaMaker {
    @Override
    public Menus getMenu() {
        return Menus.BULGOGI_PIZZA;
    }

    @Override
    public String prepare() {
        return "불고기 피자 준비";
    }

    @Override
    public String bake() {
        return "불고기 피자 굽기";
    }

    
}
