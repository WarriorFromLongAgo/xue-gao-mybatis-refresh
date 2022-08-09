package com.xuegao.mybatisdemo.business.demo.mapper;

import com.xuegao.mybatisdemo.business.demo.model.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> list();
}
