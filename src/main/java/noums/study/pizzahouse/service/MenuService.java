package noums.study.pizzahouse.service;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.MenuDto;
import noums.study.pizzahouse.entity.Menu;
import noums.study.pizzahouse.enums.Menus;
import noums.study.pizzahouse.exception.ErrorCode;
import noums.study.pizzahouse.exception.PizzahouseException;
import noums.study.pizzahouse.repository.MenuRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;

    @PostConstruct
    public void init() {
        Menus[] values = Menus.values();
        for (Menus m : values) {
            Menu menu = new Menu();
            menu.setMenus(m);
            menu.setPart(m.getPart());
            menu.setPrice(m.getPrice());
            repository.save(menu);
        }
    }

    // 캐시 있으면 캐시 읽고, 없으면 생성
    @Cacheable(value = "menuList", key = "'test'")
    public List<Menu> getMenus() {
        return repository.findAll();
    }

    // 캐시 업데이트
    @CachePut(value = "menuList", key = "'test'")
    public List<Menu> updateMenus(MenuDto dto) {
        Menus menus = Menus.fromString(dto.getMenu());
        Menu menu = repository.findByMenus(menus)
                .orElseThrow(() -> new PizzahouseException(ErrorCode.INVALID_MENU));
        menu.setPart(dto.getPart());
        menu.setPrice(dto.getPrice());
        repository.save(menu);
        return repository.findAll();
    }

    // 캐시 없애기
    @Transactional
    @CacheEvict(value = "menuList", allEntries = true)
    public void deleteMenu(String menuName) {
        Menus menus = Menus.fromString(menuName);
        repository.deleteByMenus(menus);
    }

}
