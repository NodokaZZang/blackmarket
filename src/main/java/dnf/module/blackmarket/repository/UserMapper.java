package dnf.module.blackmarket.repository;

import dnf.module.blackmarket.dto.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    UserInfo getUserInfo(String insertedId);

    void saveAuthKey(Map<String, String> authData);
}
