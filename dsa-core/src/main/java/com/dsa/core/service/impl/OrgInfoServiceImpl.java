package com.dsa.core.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.core.dao.OrgInfoDao;
import com.dsa.core.dto.OrgInfoInputDto;
import com.dsa.core.dto.OrgInfoOutputDto;
import com.dsa.core.dto.OrgInfoQueryDto;
import com.dsa.core.model.OrgInfo;
import com.dsa.core.model.OrgInfoUtil;
import com.dsa.core.service.OrgInfoService;
import com.dsa.utils.GenerateUtil;
import com.dsa.utils.node.Node;
import com.dsa.utils.node.NodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 组织结构业务逻辑实现层
 * @ClassName OrgInfoServiceImpl
 * @Description: TODO
 * @date 2019/5/25  14:56
 * @Version 1.0
 */
@Service
@Transactional
public class OrgInfoServiceImpl implements OrgInfoService {

    @Autowired
    OrgInfoDao orgInfoDao;

    @Override
    public ResponseBean getOrgTree(OrgInfoQueryDto orgInfoQueryDto) {
        OrgInfo orgInfo = new OrgInfo();
        BeanUtils.copyProperties(orgInfoQueryDto, orgInfo);
        List<OrgInfoOutputDto> orgInfoOutputDtoList = new ArrayList<>();
        List<OrgInfoOutputDto> orgInfoOutputDtoLists = new ArrayList<>();
        orgInfoOutputDtoList = orgInfoDao.findOrgInfoTreeList(orgInfo);
        orgInfoOutputDtoLists = OrgInfoUtil.toTreeList(orgInfoOutputDtoList,"0");
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), orgInfoOutputDtoLists, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean findTree(OrgInfoInputDto orgInfoInputDto) {
        List<Node> nodeList = new ArrayList<>();
        List<Node> nodeLists = new ArrayList<>();
        nodeList = orgInfoDao.findTree(orgInfoInputDto.getiFlag());
        nodeLists = NodeUtil.toTreeList(nodeList, "0");
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), nodeLists, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean get(OrgInfoInputDto orgInfoInputDto) {
        OrgInfo orgInfo = new OrgInfo();
        BeanUtils.copyProperties(orgInfoInputDto, orgInfo);
        List<OrgInfoOutputDto> orgInfoOutputDtoList = new ArrayList<>();
        orgInfoOutputDtoList = orgInfoDao.findOrgInfoTreeList(orgInfo);
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), orgInfoOutputDtoList.get(0), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean insert(OrgInfoInputDto orgInfoInputDto) {
        orgInfoInputDto.setOrgId(GenerateUtil.getGUID32());
        OrgInfo orgInfo = new OrgInfo();
        BeanUtils.copyProperties(orgInfoInputDto, orgInfo);
        orgInfoDao.insertOrgInfo(orgInfo);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean update(OrgInfoInputDto orgInfoInputDto) {
        OrgInfo orgInfo = new OrgInfo();
        BeanUtils.copyProperties(orgInfoInputDto, orgInfo);
        orgInfoDao.updateOrgInfo(orgInfo);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean deleteMultiple(OrgInfoInputDto orgInfoInputDto) {
        OrgInfo orgInfo = new OrgInfo();
        BeanUtils.copyProperties(orgInfoInputDto,orgInfo);
        orgInfo.setParentOrgId(orgInfo.getOrgId());
        Integer pidCount = orgInfoDao.countOrgInfo(orgInfo);
        if(pidCount !=null && pidCount != 0){
            return new ResponseBean(false, UnicomResponseEnums.UPDATE_DATA.getCode(), UnicomResponseEnums.UPDATE_DATA.getMsg()+": 请先删除组织下节点");
        }
        orgInfoDao.delOrgInfo(orgInfo); //删除组织
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }
}
