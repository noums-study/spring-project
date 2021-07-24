package noums.study.pizzahouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noums.study.pizzahouse.enums.Menus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Enumerated(value = EnumType.STRING)
    private Menus menus;

    private int count;
    private int totalPrice;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

}
