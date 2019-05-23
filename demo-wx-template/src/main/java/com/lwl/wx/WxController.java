package com.lwl.wx;

import com.lwl.wx.model.WxConfig;
import com.lwl.wx.model.WxRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/22 14:15
 */
@RestController
@Slf4j
public class WxController {
    @Autowired
    private WxService wxService;

    /**
     * 验证token的时候，微信会调用这个接口
     */
    @GetMapping("/valid/token")
    public String valid(WxRequest request) {
        return wxService.validToken(request);
    }

    /**
     * 获取签名，link表示当前页面
     */
    @GetMapping("/signature")
    public WxConfig signature(String link) {
        return wxService.getWxConfig(link);
    }
}
