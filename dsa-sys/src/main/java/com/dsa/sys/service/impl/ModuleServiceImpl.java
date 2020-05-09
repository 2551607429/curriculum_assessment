package com.dsa.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dao.ModuleDao;
import com.dsa.sys.dto.ModuleInputDto;
import com.dsa.sys.dto.ModuleGroupInputDto;
import com.dsa.sys.model.Module;
import com.dsa.sys.model.ModuleGroup;
import com.dsa.sys.model.ModuleUtil;
import com.dsa.sys.service.ModuleService;
import com.dsa.sys.dto.ModuleGroupOutputDto;
import com.dsa.sys.dto.ModuleOutputDto;
import com.dsa.utils.node.Node;
import com.dsa.utils.node.NodeUtil;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public ResponseBean findModuleTreeList() {
        List<ModuleOutputDto> moduleList = new ArrayList<>();
        List<ModuleOutputDto> moduleLists = new ArrayList<>();
        moduleList = moduleDao.findModuleTreeList(new Module());
        moduleLists = ModuleUtil.toTreeList(moduleList, "GP_0");
        logger.info(JSON.toJSONString(moduleLists));
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), moduleLists, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean findModuleSearch(ModuleInputDto moduleInputDto) {
        List<ModuleOutputDto> modulesList = new ArrayList<>();
        List<ModuleOutputDto> modulesLists = new ArrayList<>();
        List<ModuleOutputDto> modulesListTest = new ArrayList<>();

        Module module = new Module();
        BeanUtils.copyProperties(moduleInputDto, module);
        modulesList = moduleDao.findModuleTreeList(module);
        modulesListTest.addAll(modulesList);
        for (int i = 0; i < modulesList.size(); i++) {
            modulesListTest = getParent(modulesListTest, modulesList.get(i));
        }
        if (modulesList.size() <= 1) {
            modulesLists = ModuleUtil.toTreeList(modulesListTest, "GP_0");
        } else {
            //去重之后转换tree
            modulesLists = ModuleUtil.toTreeList(removeDuplicateCase(modulesListTest), "GP_0");
        }
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), modulesLists, UnicomResponseEnums.SUCCESS.getMsg());
    }

    /**
     * 递归遍历父节点
     *
     * @param modulesList
     * @param modules
     * @return
     */
    public List<ModuleOutputDto> getParent(List<ModuleOutputDto> modulesList, ModuleOutputDto modules) {
        modules = moduleDao.findModuleGroupTreeParentId(modules.getpId().substring(3));
        if (null != modules && null != modules.getId() && modules.getpId() != null) {
            modulesList.add(modules);
        }
        if (null != modules) {
            if (!"GP_0".equals(modules.getpId())) {
                List<ModuleOutputDto> pid = getParent(modulesList, modules);
            } else {
                return modulesList;
            }
        }
        return modulesList;
    }

    /**
     * 去重
     *
     * @param cases
     * @return
     */
    private List<ModuleOutputDto> removeDuplicateCase(List<ModuleOutputDto> cases) {
        Set<ModuleOutputDto> set = new TreeSet<>(new Comparator<ModuleOutputDto>() {
            public int compare(ModuleOutputDto o1, ModuleOutputDto o2) {
                //字符串,则按照asicc码升序排列
                int x = o1.getText().compareTo(o2.getText());
                int y = o1.getpId().compareTo(o2.getpId());
                if (x == 0 && y == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        set.addAll(cases);
        return new ArrayList<>(set);
    }


    @Override
    public ResponseBean findModule(Module module) {
        List<Module> moduleList = new ArrayList<>();
        moduleList = moduleDao.findModule(module);
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), moduleList, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean updateModuleByModuleId(ModuleInputDto moduleInputDto) {
        ModuleInputDto m = new ModuleInputDto();
        m.setModuleId(moduleInputDto.getModuleId());
        int count = isModule(m);
        if (count == 0) {
            return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg());
        }
        if (null != moduleInputDto.getVcCaption()) {
            count = isModuleVcName(moduleInputDto);
            if (count != 0) {
                return new ResponseBean(false, UnicomResponseEnums.REPEAT_DATA.getCode(), UnicomResponseEnums.REPEAT_DATA.getMsg() + ":同级目录下名称不能重复 ");
            }
        }
        Module module = new Module();
        BeanUtils.copyProperties(moduleInputDto, module);
        moduleDao.updateModuleByModuleID(module);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean deleteModule(ModuleInputDto moduleInputDto) {
        int count = isModule(moduleInputDto);
        if (count == 0) {
            return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg());
        }
        Module module = new Module();
        BeanUtils.copyProperties(moduleInputDto, module);
        moduleDao.deleteModule(module);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    /**
     * 修改或删除时验证用户是否存在
     *
     * @param moduleInputDto
     * @return
     */
    public int isModule(ModuleInputDto moduleInputDto) {
        Module module = new Module();
        BeanUtils.copyProperties(moduleInputDto, module);
        int count = moduleDao.countModel(module);
        return count;
    }


    /**
     * 新增或修改时验证用户名是否存在
     *
     * @param moduleInputDto
     * @return
     */
    public int isModuleVcName(ModuleInputDto moduleInputDto) {
        Module m = new Module();
        BeanUtils.copyProperties(moduleInputDto, m);
        int count = moduleDao.findVcNameCount(m);
        return count;
    }

    @Override
    public ResponseBean insertModuleInfo(ModuleInputDto moduleInputDto) {
        ModuleInputDto m = new ModuleInputDto();
        m.setVcCaption(moduleInputDto.getVcCaption());
        m.setModuleGroupId(moduleInputDto.getModuleGroupId());
        int count = isModuleVcName(m);
        if (count != 0) {
            return new ResponseBean(false, UnicomResponseEnums.REPEAT_DATA.getCode(), UnicomResponseEnums.REPEAT_DATA.getMsg() + ":同级目录下名称不能重复 ");
        }
        // 暂定用代码实现自增
        String moduleIdString = moduleDao.findMaxModuleId();
        if (StringUtil.isEmpty(moduleIdString)) {
            moduleInputDto.setModuleId(1);
        } else {
            int moduleId = Integer.parseInt(moduleIdString) + 1;
            moduleInputDto.setModuleId(moduleId);
        }
//        moduleInputDto.setiIsEnable(1);
        moduleInputDto.setiFlag(0);
        Module module = new Module();
        BeanUtils.copyProperties(moduleInputDto, module);
        moduleDao.insertModuleInfo(module);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }


    @Override
    public ResponseBean findModuleGroup(ModuleGroupInputDto moduleGroupInputDto) {
        ModuleGroup moduleGroup = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, moduleGroup);
        List<ModuleGroupOutputDto> moduleGroupList = moduleDao.findModuleGroup(moduleGroup);
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), moduleGroupList, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean findModuleGroupTree() {
        List<Node> nodeList = new ArrayList<>();
        List<Node> nodeLists = new ArrayList<>();
        nodeList = moduleDao.findModuleGroupTree();
        nodeLists = NodeUtil.toTreeList(nodeList, "0");
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), nodeLists, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean insertModuleGroupInfo(ModuleGroupInputDto moduleGroupInputDto) {
        if (StringUtil.isEmpty(moduleGroupInputDto.getVcName())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg() + ": vcName参数不合法");
        }
        int count = isModuleGroupVcName(moduleGroupInputDto);
        if (count != 0) {
            return new ResponseBean(false, UnicomResponseEnums.REPEAT_DATA.getCode(), UnicomResponseEnums.REPEAT_DATA.getMsg() + ":vcName不能重复 ");
        }
        // 暂定用代码实现自增
        String moduleGroupIdString = moduleDao.findMaxModuleGroupId();
        if (StringUtil.isEmpty(moduleGroupIdString)) {//如果库里一条数据都没有
            moduleGroupInputDto.setModuleGroupId(1);
        } else {
            int moduleGroupId = Integer.parseInt(moduleGroupIdString) + 1;
            moduleGroupInputDto.setModuleGroupId(moduleGroupId);
        }
        ModuleGroup moduleGroup = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, moduleGroup);
        moduleDao.insertModuleGroupInfo(moduleGroup);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean updateModuleGroup(ModuleGroupInputDto moduleGroupInputDto) {
        ModuleGroupInputDto m = new ModuleGroupInputDto();
        m.setModuleGroupId(moduleGroupInputDto.getModuleGroupId());
        int count = isModuleGroup(m);//数据验证
        if (count == 0) {//操作数据不存在
            return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg() + ":所选数据不存在 ");
        }
        if (StringUtil.isNotEmpty(moduleGroupInputDto.getVcName())) {
            int vcNameCount = isModuleGroupVcName(moduleGroupInputDto);
            if (vcNameCount != 0) {//组名称重复
                return new ResponseBean(false, UnicomResponseEnums.REPEAT_DATA.getCode(), UnicomResponseEnums.REPEAT_DATA.getMsg() + ":vcName不能重复 ");
            }
        }
        ModuleGroup moduleGroup = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, moduleGroup);
        moduleDao.updateModuleGroup(moduleGroup);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean delModuleGroup(ModuleGroupInputDto moduleGroupInputDto) {
        int count = isModuleGroup(moduleGroupInputDto);
        if (count == 0) {//操作用户不存在
            return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg() + ":所选数据不存在 ");
        }
        Module module = new Module();
        module.setModuleGroupId(moduleGroupInputDto.getModuleGroupId());
        int moduleCount = moduleDao.countModel(module);
        if (moduleCount != 0) {
            return new ResponseBean(false, UnicomResponseEnums.UPDATE_DATA.getCode(), UnicomResponseEnums.UPDATE_DATA.getMsg() + ":请先删除模块组下模块 ");
        }
        ModuleGroup moduleGroup = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, moduleGroup);
        moduleDao.delModuleGroup(moduleGroup);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    /**
     * 验证模块组唯一性
     *
     * @param moduleGroupInputDto
     * @return
     */
    public int isModuleGroup(ModuleGroupInputDto moduleGroupInputDto) {
        ModuleGroup m = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, m);
        Integer count = moduleDao.countModelGroup(m);
        return count;
    }

    /**
     * 新增或修改时判断组名是否重复
     *
     * @param moduleGroupInputDto
     * @return
     */
    public int isModuleGroupVcName(ModuleGroupInputDto moduleGroupInputDto) {
        ModuleGroup m = new ModuleGroup();
        BeanUtils.copyProperties(moduleGroupInputDto, m);
        int count = moduleDao.findGroupVcNameCount(m);
        return count;
    }

}
