package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Donqiuxote
 * @data 2018/2/26 10:59
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

/*    @Autowired
    private WxMpConfigStorage wxMpConfigStorage;

   @GetMapping("/hello")
   public String hello(){
       String msg = wxMpConfigStorage.getAppId() + "***********" + wxMpConfigStorage.getSecret();
       System.out.println(msg);
       return msg;
   }*/


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法");
        log.info("code={}", code);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxefdae6d2e8be5a9b&secret=ec60515bb692a83aaa687be0ded23b62&code="+code+"&grant_type=authorization_code";
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);



    }
}
