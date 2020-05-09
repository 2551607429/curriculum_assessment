package com.dsa.core.model;


import com.dsa.core.dto.OrgInfoOutputDto;
import com.dsa.utils.DealString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgInfoUtil {
    /**
     * tree的初始化
     * @param orgInfoOutputDtoList
     * @param rootSuperId
     * @return
     */
    public static List<OrgInfoOutputDto> toTreeList(List<OrgInfoOutputDto> orgInfoOutputDtoList, String rootSuperId) {
        List<OrgInfoOutputDto> modules = new ArrayList<OrgInfoOutputDto>();
        //String id = null;
        String superId = null;
        Map<String, OrgInfoOutputDto> map = getMapNode(orgInfoOutputDtoList).get(0);
        for(OrgInfoOutputDto o : orgInfoOutputDtoList){
            //id = node.getId();
            superId = o.getpId();
            if(map.containsKey(superId)){
                map.get(superId).getChildren().add(o);
            }
            else{
                if(!"".equals(DealString.toString(rootSuperId)) && superId.equals(rootSuperId)){
                    modules.add(o);
                }
                else if("".equals(DealString.toString(rootSuperId))){
                    modules.add(o);
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
    public static List<OrgInfoOutputDto> toTreeList(List<OrgInfoOutputDto> all, String checkedId, String rootSuperId){
        List<OrgInfoOutputDto> Modules = new ArrayList<OrgInfoOutputDto>();
        //String id = null;
        String superId = null;
        Map<String, OrgInfoOutputDto> map = getMapNode(all).get(0);
        for(OrgInfoOutputDto module : all){
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
     * @param orgInfoOutputDtoList
     * @return
     */
    private static List<Map<String, OrgInfoOutputDto>> getMapNode(List<OrgInfoOutputDto> orgInfoOutputDtoList) {
        Map<String, OrgInfoOutputDto> map = new HashMap<String, OrgInfoOutputDto>();
        Map<String, OrgInfoOutputDto> superMap = new HashMap<String, OrgInfoOutputDto>();
        List<Map<String, OrgInfoOutputDto>> list = new ArrayList<Map<String, OrgInfoOutputDto>>();
        for(OrgInfoOutputDto module : orgInfoOutputDtoList){

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
