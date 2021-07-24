package noums.study.pizzahouse.food.maker.chicken;


import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.enums.Menus;
import noums.study.pizzahouse.food.manager.FoodManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ChickenManager implements FoodManager {

    final private ApplicationContext applicationContext;

    private Map<Menus, ChickenMaker> makers = new HashMap<>();

    @PostConstruct
    public void init() {
        Collection<ChickenMaker> makerCollection = applicationContext.getBeansOfType(ChickenMaker.class).values();
        for (ChickenMaker maker : makerCollection) {
            if (makers.put(maker.getMenu(), maker) != null) {
                throw new IllegalArgumentException("makers put 과정에서 에러 발생");
            }
        }
    }

    @Override
    public String makeFood(Menus menus) {
        ChickenMaker maker = makers.get(menus);
        maker.prepare();
        maker.frying();
        return "chicken";
    }

    @Override
    public String getPart() {
        return "CHICKEN";
    }

}
