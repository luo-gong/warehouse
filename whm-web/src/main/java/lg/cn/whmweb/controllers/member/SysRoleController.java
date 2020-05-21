package lg.cn.whmweb.controllers.member;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.to.CommonResult;
import lg.cn.whmmember.entity.Role;
import lg.cn.whmmember.service.MenuService;
import lg.cn.whmmember.service.RoleService;
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
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;


    /**
     * 角色管理数据展示
     *
     * @param page
     * @param nameZh
     * @param remarks
     * @param modelMap
     * @return
     */
    @GetMapping("roleHtml")
    public String roleHtml(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) String nameZh,
                           @RequestParam(required = false) String remarks,
                           ModelMap modelMap) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(nameZh))
            map.put("nameZh", nameZh);
        if (!StringUtils.isEmpty(remarks))
            map.put("remarks", remarks);
        Pageable pageable = PageRequest.of(page == null ? 0 : page, 2);
        Page<Role> rolesPage = roleService.getRolesPage(map, pageable);
        modelMap.addAttribute("roles", rolesPage.getContent());
        modelMap.addAttribute("nameZh", nameZh);
        modelMap.addAttribute("remarks", remarks);
        modelMap.addAttribute("pages", new String[rolesPage.getTotalPages()]);
        return "admin/role/role";
    }


    @GetMapping(value = "addRoleHtml")
    public String addRoleHtml(Model model) {
        model.addAttribute("menus", menuService.getMenuAll());
        return "admin/role/addRole";
    }

    @GetMapping(value = "updateRoleHtml/{rid}")
    public String updateRoleHtml(Model model, @PathVariable Integer rid) throws JsonProcessingException {
        model.addAttribute("role", roleService.getRoleById(rid));
        model.addAttribute("menus", menuService.getMenuAll());
        return "admin/role/updateRole";
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @PostMapping("addRole")
    public String addRole(Role role) {
        if (roleService.addRole(role) > 0) {
            return "redirect:/role/roleHtml";
        }
        return "forward:/admin/role/addRole";
    }


    @PostMapping(value = "updateRole")
    public Object updateRole(Role role) {
        if (roleService.updateRole(role) > 0) {
            return "redirect:/role/roleHtml";
        }
        return "forward:/role/updateRoleHtml";
    }

    /**
     * 删除角色
     *
     * @param rid
     * @return
     */
    @GetMapping(value = "roleDelete")
    public String roleDelete(@RequestParam Integer rid) {
        roleService.updateRoleIsDelete(rid);
        return "redirect:/role/roleHtml";
    }
}
