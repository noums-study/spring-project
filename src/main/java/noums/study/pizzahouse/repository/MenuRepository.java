package noums.study.pizzahouse.repository;

import noums.study.pizzahouse.entity.Menu;
import noums.study.pizzahouse.entity.OrderInfo;
import noums.study.pizzahouse.enums.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByMenus(Menus menus);

    void deleteByMenus(Menus menus);
}
