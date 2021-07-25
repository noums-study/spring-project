package noums.study.pizzahouse.controller;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.MenuDto;
import noums.study.pizzahouse.service.MenuService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;


    @GetMapping("")
    public ResponseEntity<?> getMenus() {
        return ResponseEntity.ok(service.getMenus());
    }


    @PostMapping("")
    public ResponseEntity<?> updateMenus(@RequestBody MenuDto dto) {
        return ResponseEntity.ok(service.updateMenus(dto));
    }


    @DeleteMapping("")
    public ResponseEntity<?> deleteMenu(@RequestParam String menuName) {
        service.deleteMenu(menuName);
        return ResponseEntity.ok("ok");
    }


}
