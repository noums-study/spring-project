package noums.study.pizzahouse.controller;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.enums.Menu;
import noums.study.pizzahouse.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RequiredArgsConstructor
@RestController
public class OrderController {

    final private OrderService service;

    @PostMapping()
    public ResponseEntity<?> order(@RequestBody OrderRequest req) {
        return ResponseEntity.ok(service.order(req));
    }

    @GetMapping()
    public ResponseEntity<?> orderTest() {
        OrderRequest req = new OrderRequest();
        req.setMenu(Menu.FRIED_CHICKEN);
        return ResponseEntity.ok(service.order(req));
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException() {
        System.out.println("##### [error] OrderController Runtime Exception !");
        return "error/RuntimeException";
    }
}
