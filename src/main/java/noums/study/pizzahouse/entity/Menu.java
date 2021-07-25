package noums.study.pizzahouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noums.study.pizzahouse.bean.MenuDto;
import noums.study.pizzahouse.enums.Menus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {

    @Id
    @Enumerated(value = EnumType.STRING)
    private Menus menus;

    private int price;
    private String part;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public MenuDto toDto() {
        MenuDto dto = new MenuDto();
        dto.setMenu(this.menus.name());
        dto.setPart(this.part);
        dto.setPrice(this.price);
        return dto;
    }

}
