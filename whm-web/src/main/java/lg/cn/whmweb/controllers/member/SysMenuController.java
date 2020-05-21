package lg.cn.whmweb.controllers.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import lg.cn.to.CommonResult;
import lg.cn.whmmember.entity.Menu;
import lg.cn.whmmember.entity.Role;
import lg.cn.whmmember.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    MenuService menuService;

    /**
     * 权限管理数据展示
     *
     * @param page
     * @param modelMap
     * @return
     */
    @GetMapping("menuHtml")
    public String menuHtml(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String pattern,
                           ModelMap modelMap) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(name))
            map.put("name", name);
        if (!StringUtils.isEmpty(pattern))
            map.put("pattern", pattern);
        Pageable pageable = PageRequest.of(page == null ? 0 : page, 2);
        Page<Menu> menusPage = menuService.getMenusPage(map, pageable);
        modelMap.addAttribute("menus", menusPage.getContent());
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("pattern", pattern);
        modelMap.addAttribute("pages", new String[menusPage.getTotalPages()]);
        return "admin/menu/menu";
    }


    @GetMapping(value = "menuaddHtml")
    public String addMenuHtml() {
        return "admin/menu/addMenu";
    }

    @GetMapping(value = "menuUpdateHtml/{id}")
    public String updateRoleHtml(Model model, @PathVariable Integer id) throws JsonProcessingException {
        model.addAttribute("menu", menuService.findById(id));
        return "admin/menu/updateMenu";
    }

    /**
     * 新增权限
     *
     * @return
     */
    @PostMapping("addMenu")
    public String addRole(Menu menu) {
        if (menuService.addMenu(menu) > 0) {
            return "redirect:/menu/menuHtml";
        }
        return "forward:/admin/menu/addMenu";
    }

    @PostMapping(value = "updateMenu")
    public String updateMenu(Menu menu) {
        if (menuService.updateMenu(menu) > 0) {
            return "redirect:/menu/menuHtml";
        }
        return "forward:/menu/menuUpdateHtml/" + menu.getId();
    }


    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @GetMapping("menuDelete")
    public String menuDelete(@RequestParam String id) {
        menuService.delMenu(Integer.parseInt(id));
        return "redirect:/menu/menuHtml";
    }
}
