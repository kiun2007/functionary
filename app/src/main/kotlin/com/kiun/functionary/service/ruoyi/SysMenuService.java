package com.kiun.functionary.service.ruoyi;

import com.kiun.functionary.base.Ztree;
import com.kiun.functionary.dao.ruoyi.RuoyiSysMenuMapper;
import com.kiun.functionary.dao.ruoyi.RuoyiSysRoleMenuMapper;
import com.kiun.functionary.dao.sys.SysMenuMapper;
import com.kiun.functionary.dao.sys.entity.SysMenu;
import com.kiun.functionary.dao.sys.entity.SysMenuExample;
import com.kiun.functionary.dao.sys.entity.SysRole;
import com.kiun.functionary.dao.sys.entity.SysUser;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysMenuService
{
    @Resource
    private RuoyiSysMenuMapper ruoyiSysMenuMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private RuoyiSysRoleMenuMapper roleMenuMapper;

    /**
     * 根据用户查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenusByUser(SysUser user)
    {
        List<SysMenu> menus = ruoyiSysMenuMapper.selectMenusByUserId(user.getUserId());
        return getChildPerms(menus, 0);
    }

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    public List<SysMenu> selectMenuList(SysMenu menu)
    {
        return ruoyiSysMenuMapper.selectMenuList(menu);
    }

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    public List<SysMenu> selectMenuAll()
    {
        return ruoyiSysMenuMapper.selectMenuAll();
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(String userId)
    {
        List<String> perms = ruoyiSysMenuMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (StringUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleMenuTreeData(SysRole role)
    {
        String roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysMenu> menuList = ruoyiSysMenuMapper.selectMenuAll();
        if (StringUtils.isNotEmpty(roleId))
        {
            List<String> roleMenuList = ruoyiSysMenuMapper.selectMenuTree(roleId);
            ztrees = initZtree(menuList, roleMenuList, true);
        }
        else
        {
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    /**
     * 查询所有菜单
     *
     * @return 菜单列表
     */
    public List<Ztree> menuTreeData()
    {
        List<SysMenu> menuList = ruoyiSysMenuMapper.selectMenuAll();
        return initZtree(menuList);
    }

    /**
     * 查询系统所有权限
     *
     * @return 权限列表
     */
    public LinkedHashMap<String, String> selectPermsAll()
    {
        LinkedHashMap<String, String> section = new LinkedHashMap<>();
        List<SysMenu> permissions = ruoyiSysMenuMapper.selectMenuAll();
        return section;
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysMenu> menuList)
    {
        return initZtree(menuList, null, false);
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @param roleMenuList 角色已存在菜单列表
     * @param permsFlag 是否需要显示权限标识
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysMenu> menuList, List<String> roleMenuList, boolean permsFlag)
    {
        List<Ztree> ztrees = new ArrayList<>();
        boolean isCheck = roleMenuList != null;
        for (SysMenu menu : menuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getMenuId());
            ztree.setpId(menu.getParentId());
            ztree.setName(transMenuName(menu, roleMenuList, permsFlag));
            ztree.setTitle(menu.getMenuName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    public String transMenuName(SysMenu menu, List<String> roleMenuList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        return sb.toString();
    }

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(String menuId)
    {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysMenu selectMenuById(String menuId)
    {
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    /**
     * 查询子菜单数量
     *
     * @param parentId 父级菜单ID
     * @return 结果
     */
    public int selectCountMenuByParentId(String parentId)
    {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return (int) sysMenuMapper.countByExample(example);
    }

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int selectCountRoleMenuByMenuId(String menuId)
    {
        return roleMenuMapper.selectCountRoleMenuByMenuId(menuId);
    }

    /**
     * 新增保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu)
    {
        return sysMenuMapper.insertOne(menu);
    }

    /**
     * 修改保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu)
    {
        return sysMenuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public String checkMenuNameUnique(SysMenu menu)
    {
        SysMenu nowMenu = sysMenuMapper.selectByPrimaryKey(menu.getMenuId());

        if (nowMenu != null && Objects.equals(menu.getMenuName(), nowMenu.getMenuName())){
            return "0";
        }

        SysMenu info = ruoyiSysMenuMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());
        if (info != null)
        {
            return "1";
        }
        return "0";
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId)
    {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext();)
        {
            SysMenu t = (SysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId().equals(String.valueOf(parentId)))
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysMenu> list, SysMenu t)
    {
        // 得到子节点列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysMenu> it = childList.iterator();
                while (it.hasNext())
                {
                    SysMenu n = (SysMenu) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t)
    {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext())
        {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().equals(t.getMenuId()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
