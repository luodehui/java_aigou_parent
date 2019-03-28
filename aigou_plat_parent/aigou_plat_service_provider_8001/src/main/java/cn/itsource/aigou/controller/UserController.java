package cn.itsource.aigou.controller;

import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.plat.domain.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){  //@RequestBody将前台提交到Body的参数封装到user对象
        //通过前台用户名和密码，来从数据库查询，如果数据是对的，否则就是错误
        if (user!=null&& !StringUtils.isEmpty(user.getName())&&!StringUtils.isEmpty(user.getPassword())){
            if ("admin".equals(user.getName())&&"admin".equals(user.getPassword())){
                return AjaxResult.me().setMsg("登录成功");
            }else {
                return AjaxResult.me().setSuccess(false).setMsg("登录失败");
            }
        }
        return AjaxResult.me().setSuccess(false).setMsg("登录失败");
    }
}
