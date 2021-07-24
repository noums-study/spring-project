package noums.study.pizzahouse.food.manager;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.enums.Menus;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class KitchenManager {

    final private ApplicationContext applicationContext;

    private Map<String, FoodManager> managers = new HashMap<>();

    @PostConstruct
    public void init() {
        Collection<FoodManager> managerCollection = applicationContext.getBeansOfType(FoodManager.class).values();
        for (FoodManager manager : managerCollection) {
            if (managers.put(manager.getPart(), manager) != null) {
                throw new IllegalArgumentException("managers put 과정에서 에러 발생");
            }
        }
    }

    public String makeFood(Menus menus) {

        FoodManager manager = managers.get(menus.getPart());
        return manager.makeFood(menus);
    }

}
