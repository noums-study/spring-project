package noums.study.pizzahouse.manager;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.enums.FoodMenu;
import noums.study.pizzahouse.makers.chickenmaker.ChickenMaker;
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

    private Map<FoodMenu, ChickenMaker> makers = new HashMap<>();

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
    public String getPart() {
        return "chicken";
    }

    @Override
    public String makeFood(FoodMenu foodMenu) {
        ChickenMaker chickenMaker = makers.get(foodMenu);
        chickenMaker.prepare();
        chickenMaker.make();
        return "Chicken";
    }
}