package me.xiaoyuu.dao;

import me.xiaoyuu.pojo.Doll;
import org.apache.ibatis.annotations.Param;

public interface DollMapper {

    int insert(Doll record);

    Doll getOneDoll(int sex);

    Doll getDollByUserId(String userId);

    int checkUserId(String userId);

    int updateSex(@Param("userId") String userId, @Param("sex") Integer sex);

    int updateMessage(@Param("userId") String userId, @Param("message") String message);

    int updateContact(@Param("userId") String userId, @Param("contact") String contact);

    int updatePickChance(String userId);

    int updateBePickedChance(@Param("userId")String userId,@Param("bePickedChance")Integer bePickedChance);

    int updateCntByUserId(@Param("userId") String userId, @Param("cnt") Integer cnt);

    int updatePickStatusByUserId(@Param("userId") String userId, @Param("pickStatus") Integer pickStatus);

}