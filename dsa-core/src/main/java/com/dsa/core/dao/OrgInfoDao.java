package com.dsa.core.dao;

import com.dsa.core.dto.OrgInfoOutputDto;
import com.dsa.core.model.OrgInfo;
import com.dsa.utils.node.Node;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 组织结构 数据链路层
 * @ClassName UnitInfoDao
 * @Description: TODO
 * @date 2019/5/25  13:53
 * @Version 1.0
 */
@Repository
public interface OrgInfoDao {
    /**
     * 获取组织结构树
     *
     * @param orgInfo
     * @return
     */
    List<OrgInfoOutputDto> findOrgInfoTreeList(OrgInfo orgInfo);

    /**
     * 获取组织树
     * @param treeFlag 组织结构底层标记
     * @return
     */
    List<Node> findTree(@Param("treeFlag") Integer treeFlag);

    /**
     * 新增组织结构
     *
     * @param orgInfo
     * @return
     */
    Integer insertOrgInfo(OrgInfo orgInfo);

    /**
     * 修改组织结构
     *
     * @param orgInfo
     * @return
     */
    Integer updateOrgInfo(OrgInfo orgInfo);

    /**
     * 删除组织结构
     *
     * @param orgInfo
     * @return
     */
    Integer delOrgInfo(OrgInfo orgInfo);

    /**
     * 统计
     * @param orgInfo
     * @return
     */
    Integer countOrgInfo(OrgInfo orgInfo);


}
