package io.renren.modules.test;

import io.renren.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/demo_1")
    public String demo_1(){
        return "page1";
    }

    @RequestMapping("/demo_2")
    public R demo_2(HttpServletRequest request,
                    @RequestParam Map<String,Object> params){
        HttpSession session=request.getSession();
        String token="";
        if(session.getAttribute("token")!=null){
            token=session.getAttribute("token").toString();
        }
        if(!token.equals(params.get("token").toString())){
            return R.error("token error");
        }
        session.removeAttribute("token");
        // code
        return R.ok();
    }

    @RequestMapping("/demo_3")
    public R demo_3(@RequestParam Map<String,Object> params){
        String username=params.get("username").toString();
        String password=params.get("password").toString();
        return R.ok().put("username",username).put("password",password);
    }
}
