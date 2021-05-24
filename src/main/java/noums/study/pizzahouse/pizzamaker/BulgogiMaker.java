package noums.study.pizzahouse.pizzamaker;

import noums.study.pizzahouse.enums.Menu;
import org.springframework.stereotype.Component;

@Component
public class BulgogiMaker implements Maker{
    @Override
    public Menu getMenu() {
        return Menu.BULGOGI_PIZZA;
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