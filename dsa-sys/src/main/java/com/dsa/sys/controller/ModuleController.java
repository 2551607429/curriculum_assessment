package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.ModuleInputDto;
import com.dsa.sys.dto.ModuleGroupInputDto;
import com.dsa.sys.service.ModuleService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GUOJIKANG
 * @Title: 模块配置Api 控制器
 * @ClassName ModuleController
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys_module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/find_module_tree")
    public ResponseBean findModuleTree(@RequestBody ModuleInputDto moduleInputDto) {
        if ("0".equals(moduleInputDto.getIsSearch())) {
            return moduleService.findModuleTreeList();
        } else if ("1".equals(moduleInputDto.getIsSearch())) { // 条件查询
            return moduleService.findModuleSearch(moduleInputDto);
        } else {
            return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": isSearch参数不合法");
        }
    }

    /**
     * 新增或修改模块
     *
     * @param moduleInputDto
     * @return
     */
    @PostMapping("/save_module")
    public ResponseBean saveModule(@RequestBody ModuleInputDto moduleInputDto) {
        if (StringUtil.isEmpty(moduleInputDto.getVcCaption())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": vcCaption参数不合法");
        }
        if (moduleInputDto.getModuleType() == null) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": moduleType参数不合法");
        }
        if (StringUtil.isEmpty(moduleInputDto.getVcExecuteObject())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": vcExecuteObject参数不合法");
        }
        if (moduleInputDto.getiSort() == null) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": iSort参数不合法");
        }
        if ("0".equals(moduleInputDto.getIsSave())) {//约定参数 0 新增 1  修改
            return moduleService.insertModuleInfo(moduleInputDto);
        } else if ("1".equals(moduleInputDto.getIsSave())) {
            if (moduleInputDto.getModuleId() == null) {
                return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": moduleId参数不合法");
            }
            if (moduleInputDto.getiIsEnable() == null) {
                return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": iIsEnable参数不合法");
            }
            return moduleService.updateModuleByModuleId(moduleInputDto);
        } else {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": isSave参数不合法");
        }
    }

    /**
     * 启用禁用模块或模块组
     *
     * @param moduleInputDto
     * @return
     */
    @PostMapping("/moduleIsEnable")
    public ResponseBean moduleIsEnable(@RequestBody ModuleInputDto moduleInputDto) {
        if (moduleInputDto.getiIsEnable() == null) {
            return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": iIsEnable不合法");
        }
        if ("0".equals(moduleInputDto.getModuleIsEnable())) {
            if (moduleInputDto.getModuleId() == null) {
                return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": moduleId不合法");
            }
            return moduleService.updateModuleByModuleId(moduleInputDto);
        } else if ("1".equals(moduleInputDto.getModuleIsEnable())) {
            if (moduleInputDto.getModuleGroupId() == null) {
                return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": moduleId不合法");
            }
            ModuleGroupInputDto moduleGroupInputDto = new ModuleGroupInputDto();
            moduleGroupInputDto.setModuleGroupId(moduleInputDto.getModuleGroupId());
            moduleGroupInputDto.setiIsEnable(moduleInputDto.getiIsEnable());
            return moduleService.updateModuleGroup(moduleGroupInputDto);
        } else {
            return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": moduleIsEnable不合法");
        }

    }

    /**
     * 删除模块
     *
     * @param moduleInputDto
     * @return
     */
    @PostMapping("/del_module")
    public ResponseBean deleteModule(@RequestBody ModuleInputDto moduleInputDto) {
        if (moduleInputDto.getModuleId() == null) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": moduleId参数不合法");
        }
        return moduleService.deleteModule(moduleInputDto);
    }


    /**
     * 获取模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    @PostMapping("/find_module_group")
    public ResponseBean findModuleGroup(@RequestBody ModuleGroupInputDto moduleGroupInputDto) {
        return moduleService.findModuleGroup(moduleGroupInputDto);
    }

    /**
     * 保存或修改模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    @PostMapping("/save_module_group")
    public ResponseBean saveModuleGroupInfo(@RequestBody ModuleGroupInputDto moduleGroupInputDto) {
        if (moduleGroupInputDto.getParentId() == null) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": parentId参数不合法");
        }

        if ("0".equals(moduleGroupInputDto.getIsSave())) {//约定参数 0新增 1修改
            return moduleService.insertModuleGroupInfo(moduleGroupInputDto);
        } else if ("1".equals(moduleGroupInputDto.getIsSave())) {
            if (moduleGroupInputDto.getModuleGroupId() == null) {
                return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": moduleGroupId参数不合法");
            }
            return moduleService.updateModuleGroup(moduleGroupInputDto);
        } else {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": isSave参数不合法");
        }
    }


    /**
     * 删除模块组
     *
     * @param moduleGroupInputDto
     * @return
     */
    @PostMapping("/del_module_group")
    public ResponseBean delModuleGroup(@RequestBody ModuleGroupInputDto moduleGroupInputDto) {
        if (moduleGroupInputDto.getModuleGroupId() == null) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": moduleGroupId参数不合法");
        }
        return moduleService.delModuleGroup(moduleGroupInputDto);
    }

    /**
     * 树形模块组
     *
     * @return
     */
    @PostMapping("/find_group_tree")
    public ResponseBean findModuleGroupTree() {
        return moduleService.findModuleGroupTree();
    }

}
