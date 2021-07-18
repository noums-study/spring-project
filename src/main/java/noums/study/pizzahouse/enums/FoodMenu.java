package noums.study.pizzahouse.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum FoodMenu {

    FRIED_CHICKEN(10000, "chicken"),
    OVEN_CHICKEN(12000, "chicken"),
    HOTSOURCE_CHICKEN(15000, "chicken"),

    BULGOGI_PIZZA(10000, "pizza"),
    CHEESE_PIZZA(8000, "pizza"),
    POTATO_PIZZA(11000, "pizza");

    private int price;
    private String part;

    FoodMenu(int price, String part) { this.price = price; this.part = part;}

    @JsonCreator
    public static FoodMenu fromJson(String menu){
        System.out.println(">>>>>> JsonCreater :: "+ menu);
        for (FoodMenu foodMenu : FoodMenu.values()) {
            if ( foodMenu.toString().equals(menu) ) {
                System.out.println(">>>>>> correct !");
                return foodMenu;
            }
        }
        return null;
    }

}
