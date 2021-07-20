package noums.study.pizzahouse.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noums.study.pizzahouse.enums.FoodMenu;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FoodMenu menu;

    private int price;
    private int count;


}
