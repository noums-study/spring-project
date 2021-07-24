package noums.study.pizzahouse.food.maker.chicken;

import noums.study.pizzahouse.enums.Menus;
import org.springframework.stereotype.Component;

@Component
public class GarlicMaker implements ChickenMaker {
    @Override
    public Menus getMenu() {
        return Menus.GARLIC_CHICKEN;
    }

    @Override
    public String prepare() {
        return "갈릭 치 준비";
    }

    @Override
    public String frying() {
        return "갈릭 치킨 튀기기";
   }

    
}
