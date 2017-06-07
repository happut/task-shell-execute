package com.github.happut.controller.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@Controller
@RequestMapping("/ws")
@MessageMapping("console")
public class WebConsoleController {
    /**
     * 精准推送
     * @param msg
     * @param principal
     * @return
     */
    @MessageMapping("handle1")
    @SendToUser(value = "/topic/greetings1",broadcast = false)
    public String handle1(String msg,Principal principal) {

        return "精准推送，只推送到" + principal.getName();
    }


    /**
     * 广播推送
     * @param msg
     * @param principal
     * @return
     */
    @MessageMapping("handle2")
    @SendTo("topic/greetings2")
    public String handle2(String msg,Principal principal) {

        return "广播推送，所有用户都收得到";
    }
}
