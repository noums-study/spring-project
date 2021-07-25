package noums.study.pizzahouse.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noums.study.pizzahouse.entity.Menu;
import noums.study.pizzahouse.enums.Menus;

@Getter
@Setter
@NoArgsConstructor
public class MenuDto {

    private String menu;
    private int price;
    private String part;

    public Menu toEntity() {
        Menu menu = new Menu();
        menu.setMenus(Menus.fromString(this.menu));
        menu.setPrice(this.price);
        menu.setPart(this.part);
        return menu;
    }

}
