package noums.study.pizzahouse.bean;

import lombok.Getter;
import lombok.Setter;
import noums.study.pizzahouse.enums.Menus;
import noums.study.pizzahouse.enums.PayMethod;

@Getter
@Setter
public class OrderRequest {

    private Menus menus;
    private int count;
    private PayMethod payMethod;

}
