package dnf.module.blackmarket.controller;

import dnf.module.blackmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/emailCheckSend")
    public Map<String, Object> emailCheckSend(@RequestBody Map<String, Object> param)
    {
        return userService.emailCheckSend(param);
    }
}
