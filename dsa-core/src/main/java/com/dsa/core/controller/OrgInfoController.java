package com.dsa.core.controller;

import com.dsa.common.config.exception.NotEmptyException;
import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.OrgInfoInputDto;
import com.dsa.core.dto.OrgInfoQueryDto;
import com.dsa.core.service.OrgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 * @author GUOJIKANG
 * @Title: 组织结构控制器
 * @ClassName OrgInfoController
 * @Description: TODO
 * @date 2019/5/25  13:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/org")
public class OrgInfoController {

    @Autowired
    OrgInfoService orgInfoService;

    /**
     * 获取运维班 管理单元组织结构树
     *
     * @return
     */
    @PostMapping("/find_org_tree")
    public ResponseBean findOrgInfoList(@RequestBody OrgInfoQueryDto orgInfoQueryDto) {
        return orgInfoService.getOrgTree(orgInfoQueryDto);
    }

    /**
     * 获取单条
     *
     * @param orgInfoInputDto
     * @return
     */
    @RequestMapping("/get_org")
    public ResponseBean getOrgInfo(@RequestBody @Validated({OrgInfoInputDto.UPDATE.class}) OrgInfoInputDto orgInfoInputDto) {
        return orgInfoService.get(orgInfoInputDto);
    }


    /**
     * 新增组织结构信息
     *
     * @return
     */
    @PostMapping("/save_org")
    public ResponseBean saveOrgInfo(@RequestBody @Validated({OrgInfoInputDto.INSERT.class}) OrgInfoInputDto orgInfoInputDto) {
        return orgInfoService.insert(orgInfoInputDto);
    }

    /**
     * 修改组织结构信息
     *
     * @return
     */
    @PostMapping("/update_org")
    public ResponseBean updateOrgInfo(@RequestBody @Validated({OrgInfoInputDto.INSERT.class, OrgInfoInputDto.UPDATE.class}) OrgInfoInputDto orgInfoInputDto) {
        return orgInfoService.update(orgInfoInputDto);
    }

    /**
     * 修改状态
     *
     * @return
     */
    @PostMapping("/set_status")
    public ResponseBean setStatus(@RequestBody @Validated({OrgInfoInputDto.INSERT.class, OrgInfoInputDto.UPDATE.class}) OrgInfoInputDto orgInfoInputDto) {
        if(orgInfoInputDto.getiIsEnable() == null){
            throw new NotEmptyException("iIsEnable不能为空");
        }
        return orgInfoService.update(orgInfoInputDto);
    }


    /**
     * 删除组织结构信息
     *
     * @return
     */
    @PostMapping("/del_org")
    public ResponseBean delOrgInfo(@RequestBody @Validated({OrgInfoInputDto.UPDATE.class}) OrgInfoInputDto orgInfoInputDto) {
        return orgInfoService.deleteMultiple(orgInfoInputDto);
    }


    /**
     * 根据标记获取组织树
     *
     * @return
     */
    @PostMapping("/find_tree")
    public ResponseBean findTree(@RequestBody OrgInfoInputDto orgInfoInputDto) {
        if (orgInfoInputDto.getiFlag() == null) {
            throw new NotEmptyException("iFlag不能为空");
        }
        return orgInfoService.findTree(orgInfoInputDto);
    }

}
