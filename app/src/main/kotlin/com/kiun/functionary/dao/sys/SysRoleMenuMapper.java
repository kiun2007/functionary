package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.SysRoleMenu;
import com.kiun.functionary.dao.sys.entity.SysRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper extends com.kiun.functionary.base.BaseExampleMapper<SysRoleMenuExample, SysRoleMenu> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_menu
     * 2023-07-23 22:37:00
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("menuId") String menuId);

    List<SysRoleMenu> selectByRoleId(String roleId);

    List<SysRoleMenu> selectByMenuId(String menuId);
}