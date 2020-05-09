package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.ModuleInputDto;
import com.dsa.sys.dto.ModuleGroupInputDto;
import com.dsa.sys.model.Module;


public interface ModuleService {
    /**
     * 获取树形模块列表
     *
     * @return
     */
    ResponseBean findModuleTreeList();

    ResponseBean findModuleSearch(ModuleInputDto moduleInputDto);

    /**
     * 获取 模块列表 非树
     *
     * @return
     */
    ResponseBean findModule(Module module);

    /**
     * 修改模块
     *
     * @param moduleInputDto
     * @return
     */
    ResponseBean updateModuleByModuleId(ModuleInputDto moduleInputDto);

    /**
     * 删除模块
     *
     * @param moduleInputDto
     * @return
     */
    ResponseBean deleteModule(ModuleInputDto moduleInputDto);

    /**
     * 新增模块
     *
     * @param moduleInputDto
     * @return
     */
    ResponseBean insertModuleInfo(ModuleInputDto moduleInputDto);


    /**
     * 查询模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    ResponseBean findModuleGroup(ModuleGroupInputDto moduleGroupInputDto);

    /**
     * 树形模块组
     * @return
     */
    ResponseBean findModuleGroupTree();

    /**
     * 新增模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    ResponseBean insertModuleGroupInfo(ModuleGroupInputDto moduleGroupInputDto);

    /**
     * 修改模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    ResponseBean updateModuleGroup(ModuleGroupInputDto moduleGroupInputDto);

    /**
     * 删除模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    ResponseBean delModuleGroup(ModuleGroupInputDto moduleGroupInputDto);


}
