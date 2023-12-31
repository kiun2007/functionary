package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.SysMenu;
import com.kiun.functionary.dao.sys.entity.SysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper extends com.kiun.functionary.base.BaseExampleMapper<SysMenuExample, SysMenu> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     * 2023-08-02 00:18:30
     */
    int deleteByPrimaryKey(String menuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     * 2023-08-02 00:18:30
     */
    SysMenu selectByPrimaryKey(String menuId);

    List<SysMenu> selectByMenuId(String menuId);

    List<SysMenu> selectByModuleId(String moduleId);

    List<SysMenu> selectByMenuName(String menuName);

    List<SysMenu> selectByParentId(String parentId);

    List<SysMenu> selectByDisplayId(Integer displayId);

    List<SysMenu> selectBySqlId(String sqlId);

    List<SysMenu> selectByLinkUrl(String linkUrl);

    List<SysMenu> selectByImg(String img);

    List<SysMenu> selectByStatus(String status);

    List<SysMenu> selectByMenuType(String menuType);

    List<SysMenu> selectByRemark(String remark);

    List<SysMenu> selectByCode(String code);

    List<SysMenu> selectByOrderNum(Integer orderNum);

    List<SysMenu> selectByVisible(String visible);

    List<SysMenu> selectByAddUserId(String addUserId);

    List<SysMenu> selectByAddUserNm(String addUserNm);

    List<SysMenu> selectByAddTime(java.util.Date addTime);

    List<SysMenu> selectByUpdUserId(String updUserId);

    List<SysMenu> selectByUpdUserNm(String updUserNm);

    List<SysMenu> selectByUpdTime(java.util.Date updTime);

    List<SysMenu> selectByUpdTerminalIp(String updTerminalIp);
}