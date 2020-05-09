package com.zx.sys.dao;

import com.zx.sys.model.Achievement;
import com.zx.sys.model.AchievementExample;
import com.zx.sys.model.AchievementKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AchievementMapper {
    int countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    int deleteByPrimaryKey(AchievementKey key);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    List<Achievement> selectByExample(AchievementExample example);

    Achievement selectByPrimaryKey(AchievementKey key);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);
}