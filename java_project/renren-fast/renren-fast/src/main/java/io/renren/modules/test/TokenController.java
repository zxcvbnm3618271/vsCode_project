package io.renren.modules.test;

import io.renren.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/token")
public class TokenController {
    @RequestMapping("/save")
    public R save(HttpServletRequest request){
        HttpSession session=request.getSession();
        String token= UUID.randomUUID().toString();
        session.setAttribute("token",token);
        return R.ok().put("token",token);
    }
    @RequestMapping("/remove")
    public R remove(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("token");
        return R.ok();
    }

}
