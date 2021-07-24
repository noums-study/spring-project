package noums.study.pizzahouse.food.maker.chicken;

import noums.study.pizzahouse.enums.Menus;
import org.springframework.stereotype.Component;

@Component
public class FriedMaker implements ChickenMaker {

    @Override
    public Menus getMenu() {
        return Menus.FRIED_CHICKEN;
    }

    @Override
    public String prepare() {
        return "후라이드 치 준비";
    }

    @Override
    public String frying() {
        return "후라이드 치킨 튀기기";
    }

}
