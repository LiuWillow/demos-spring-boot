package com.lwl.rest.wx.controller;

import com.lwl.rest.wx.model.WxRequest;
import com.lwl.rest.wx.util.CheckUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * date  2019/5/21
 * author liuwillow
 **/
@RestController
public class ValidateController {
    @GetMapping("/wx")
    public void valid(HttpServletResponse response, WxRequest wxRequest) throws IOException {
        System.out.println("请求进入");
        String signature = wxRequest.getSignature();
        String timestamp = wxRequest.getTimestamp();
        String nonce = wxRequest.getNonce();
        String echostr = wxRequest.getEchostr();

        boolean success = CheckUtils.checkSignature(signature, timestamp, nonce);
        PrintWriter writer = response.getWriter();
        if (success){
            writer.print(echostr);
            writer.flush();
        }
        writer.close();
    }
}
