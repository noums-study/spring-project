package noums.study.pizzahouse.food.maker.pizza;

import noums.study.pizzahouse.enums.Menus;
import org.springframework.stereotype.Component;

@Component
public class PotatoMaker implements PizzaMaker {

    @Override
    public Menus getMenu() {
        return Menus.POTATO_PIZZA;
    }

    @Override
    public String prepare() {
        return "포테이토 피자 준비";
    }

    @Override
    public String bake() {
        return "포테이토 피자 굽기";
    }

}
