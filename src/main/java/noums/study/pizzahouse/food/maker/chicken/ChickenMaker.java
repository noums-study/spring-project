package noums.study.pizzahouse.food.maker.chicken;

import noums.study.pizzahouse.enums.Menus;

public interface ChickenMaker {

    public Menus getMenu();

    public String prepare();

    public String frying();

}
