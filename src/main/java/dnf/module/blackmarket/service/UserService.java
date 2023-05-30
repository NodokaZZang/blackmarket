package dnf.module.blackmarket.service;

import dnf.module.blackmarket.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    JmailService jmailService;

    @Autowired
    UserMapper userMapper;

    public Map<String, Object> emailCheckSend(Map<String, Object> param)
    {
        Map<String, Object> ret = new HashMap<>();
        try
        {
            String userEmail = param.get("useremail").toString();

            int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;
            String context = "인증번호 보내드립니다 [ " + authNo + " ] ";
            jmailService.SendEmail(context,"블랙마켓 인증번호 보내드립니다",userEmail);

            String AuthKey = UUID.randomUUID().toString();

            Map<String, String> authData=  new HashMap<>();
            authData.put("authKey", AuthKey);
            authData.put("authNo", String.valueOf(authNo));

            userMapper.saveAuthKey(authData);

            ret.put("authKey", AuthKey);
            ret.put("result", true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ret.put("result", false);
        }
        return ret;
    }
}
