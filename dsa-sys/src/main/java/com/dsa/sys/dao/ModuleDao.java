package com.dsa.sys.dao;


import com.dsa.sys.model.Module;
import com.dsa.sys.model.ModuleGroup;
import com.dsa.sys.dto.ModuleGroupOutputDto;
import com.dsa.sys.dto.ModuleOutputDto;
import com.dsa.utils.node.Node;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ModuleDao {

    /**
     * 获取树形模块列表
     *
     * @return
     */
    List<ModuleOutputDto> findModuleTreeList(Module module);

    /**
     * 获取 模块列表 非树
     *
     * @return
     */
    List<Module> findModule(Module module);

    /**
     * 修改模块
     *
     * @param module
     * @return
     */
    Integer updateModuleByModuleID(Module module);

    /**
     * 删除模块
     *
     * @param module
     * @return
     */
    Integer deleteModule(Module module);

    /**
     * 新增模块
     *
     * @param module
     * @return
     */
    Integer insertModuleInfo(Module module);

    /**
     * 统计模块
     *
     * @param module
     * @return
     */
    Integer countModel(Module module);

    /**
     * 新增或修改时判断用户名是否存在
     * @param module
     * @return
     */
    Integer findVcNameCount(Module module);

    /**
     * 获取最大的ModuleID实现代码自增
     *
     * @return
     */
    String findMaxModuleId();

    /**
     * 查询模块组
     *
     * @param moduleGroup
     * @return
     */
    List<ModuleGroupOutputDto> findModuleGroup(ModuleGroup moduleGroup);

    /**
     * 情况特殊 递归遍历父节点所用
     * @param parentId 父级ID
     * @return
     */
    ModuleOutputDto findModuleGroupTreeParentId(@Param("parentId") String parentId);

    /**
     * 树形模块组
     * @return
     */
    List<Node> findModuleGroupTree();

    /**
     * 新增模块组
     *
     * @param moduleGroup
     * @return
     */
    Integer insertModuleGroupInfo(ModuleGroup moduleGroup);

    /**
     * 修改模块组
     *
     * @param moduleGroup
     * @return
     */
    Integer updateModuleGroup(ModuleGroup moduleGroup);

    /**
     * 删除模块组
     *
     * @param moduleGroup
     * @return
     */
    Integer delModuleGroup(ModuleGroup moduleGroup);

    /**
     * 统计模块组
     *
     * @param moduleGroup
     * @return
     */
    Integer countModelGroup(ModuleGroup moduleGroup);

    /**
     * 获取最大的ModuleGroupId实现代码自增
     *
     * @return
     */
    String findMaxModuleGroupId();

    /**
     * 新增或修改时判断组名是否重复
     * @param moduleGroup
     * @return
     */
    Integer findGroupVcNameCount(ModuleGroup moduleGroup);
}
