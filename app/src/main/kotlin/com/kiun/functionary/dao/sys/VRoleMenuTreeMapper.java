package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.VRoleMenuTree;
import com.kiun.functionary.dao.sys.entity.VRoleMenuTreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VRoleMenuTreeMapper extends com.kiun.functionary.base.BaseExampleMapper<VRoleMenuTreeExample, VRoleMenuTree> {
    List<VRoleMenuTree> selectByMenuName(String menuName);

    List<VRoleMenuTree> selectByParentId(String parentId);

    List<VRoleMenuTree> selectByDisplayId(Integer displayId);

    List<VRoleMenuTree> selectByMenuType(String menuType);

    List<VRoleMenuTree> selectByRemark(String remark);

    List<VRoleMenuTree> selectByOrderNum(Integer orderNum);

    List<VRoleMenuTree> selectByRoleId(String roleId);

    List<VRoleMenuTree> selectByMenuId(String menuId);

    List<VRoleMenuTree> selectByModuleId(String moduleId);

    List<VRoleMenuTree> selectByActive(String active);
}