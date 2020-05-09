package com.dsa.sys.model;


import com.dsa.sys.dto.ModuleOutputDto;
import com.dsa.utils.DealString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleUtil {
    /**
     * tree的初始化
     * @param modulesList
     * @param rootSuperId
     * @return
     */
    public static List<ModuleOutputDto> toTreeList(List<ModuleOutputDto> modulesList, String rootSuperId) {
        List<ModuleOutputDto> modules = new ArrayList<ModuleOutputDto>();
        //String id = null;
        String superId = null;
        Map<String, ModuleOutputDto> map = getMapNode(modulesList).get(0);
        for(ModuleOutputDto module : modulesList){
            //id = node.getId();
            superId = module.getpId();
            if(map.containsKey(superId)){
                map.get(superId).getChildren().add(module);
            }
            else{
                if(!"".equals(DealString.toString(rootSuperId)) && superId.equals(rootSuperId)){
                    modules.add(module);
                }
                else if("".equals(DealString.toString(rootSuperId))){
                    modules.add(module);
                }
                //map.put(id, node);
            }
        }
        return modules;
    }


    /**
     * 遍历选择中数据的展示
     * @param all
     *
     * @param checkedId
     * @param rootSuperId
     * @return
     */
    public static List<ModuleOutputDto> toTreeList(List<ModuleOutputDto> all, String checkedId, String rootSuperId){
        List<ModuleOutputDto> Modules = new ArrayList<ModuleOutputDto>();
        //String id = null;
        String superId = null;
        Map<String, ModuleOutputDto> map = getMapNode(all).get(0);
        for(ModuleOutputDto module : all){
            //id = node.getId();
            if(checkedId.equals(module.getId())){
                module.setChecked(true);
            }
            superId = module.getpId();
            if(map.containsKey(superId)){
                map.get(superId).getChildren().add(module);
            }
            else{
                if(!"".equals(DealString.toString(rootSuperId)) && superId.equals(rootSuperId)){

                    Modules.add(module);
                }
                else if("".equals(DealString.toString(rootSuperId))){
                    Modules.add(module);
                }
                //map.put(id, node);
            }
        }
        return Modules;
    }

    /**
     * 数据筛选
     * @param modules
     * @return
     */
    private static List<Map<String, ModuleOutputDto>> getMapNode(List<ModuleOutputDto> modules) {
        Map<String, ModuleOutputDto> map = new HashMap<String, ModuleOutputDto>();
        Map<String, ModuleOutputDto> superMap = new HashMap<String, ModuleOutputDto>();
        List<Map<String, ModuleOutputDto>> list = new ArrayList<Map<String, ModuleOutputDto>>();
        for(ModuleOutputDto module : modules){

            if(!map.containsKey(module.getId())){
                map.put(module.getId(), module);
                superMap.put(module.getpId(), module);
            }
        }
        list.add(map);
        list.add(superMap);
        return list;
    }
}
