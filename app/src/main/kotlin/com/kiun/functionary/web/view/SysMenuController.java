package com.kiun.functionary.web.view;

import com.kiun.functionary.base.DataWrap;
import com.kiun.functionary.base.Ztree;
import com.kiun.functionary.dao.sys.entity.SysMenu;
import com.kiun.functionary.dao.sys.entity.SysRole;
import com.kiun.functionary.service.ruoyi.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController
{
    private String prefix = "system/menu";

    @Autowired
    private SysMenuService menuService;

    @GetMapping()
    public String menu()
    {
        return "system/menu/menu";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<SysMenu> list(SysMenu menu)
    {
        List<SysMenu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }

    /**
     * 删除菜单
     */
    @GetMapping("/remove/{menuId}")
    @ResponseBody
    public DataWrap<Integer> remove(@PathVariable("menuId") String menuId)
    {
        if (menuService.selectCountMenuByParentId(menuId) > 0)
        {
            return DataWrap.fail("存在子菜单,不允许删除");
        }
        return DataWrap.success(menuService.deleteMenuById(menuId));
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
    {
        SysMenu menu = null;
        if (!"0".equals(parentId))
        {
            menu = menuService.selectMenuById(parentId);
        }
        else
        {
            menu = new SysMenu();
            menu.setMenuId("0");
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return "system/menu/add";
    }

    /**
     * 新增保存菜单
     */
    @PostMapping("/add")
    @ResponseBody
    public DataWrap<Integer> addSave(SysMenu menu)
    {
        return DataWrap.success(menuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") String menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return "system/menu/edit";
    }

    /**
     * 修改保存菜单
     */
    @PostMapping("/edit")
    @ResponseBody
    public DataWrap<Integer> editSave(SysMenu menu)
    {
        return DataWrap.success(menuService.updateMenu(menu));
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon()
    {
        return "system/menu/icon";
    }

    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu)
    {
        return menuService.checkMenuNameUnique(menu);
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(SysRole role)
    {
        return menuService.roleMenuTreeData(role);
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData(SysRole role)
    {
        return menuService.menuTreeData();
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") String menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return "system/menu/tree";
    }
}
