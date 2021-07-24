package noums.study.pizzahouse.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import noums.study.pizzahouse.exception.ErrorCode;
import noums.study.pizzahouse.exception.PizzahouseException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Menus {

    BULGOGI_PIZZA(10000, "PIZZA"),
    CHEESE_PIZZA(8000, "PIZZA"),
    POTATO_PIZZA(11000, "PIZZA"),

    GARLIC_CHICKEN(15000, "CHICKEN"),
    FRIED_CHICKEN(12000, "CHICKEN")
    ;

    private static Map<String, Menus> FORMAT_MAP = Stream
            .of(Menus.values())
            .collect(Collectors.toMap(s -> s.name(), Function.identity()));

    private int price;
    private String part;

    Menus(int price, String part) {
        this.price = price;
        this.part = part;
    }

    @JsonCreator // This is the factory method and must be static
    public static Menus fromString(String string) {
        System.out.println("json creator");
        return Optional
                .ofNullable(FORMAT_MAP.get(string))
                .orElseThrow(() -> new PizzahouseException(ErrorCode.INVALID_MENU));
    }


}
