package me.xiaoyuu.dao;

import me.xiaoyuu.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DollMapperTest extends BaseTest {
    @Autowired
    DollMapper dollMapper;
    @Test
    public void test(){
        System.out.println(dollMapper.getDollByUserId("oW0EawIGGrI2bvmyNf4V0P8jY26k"));
    }
}