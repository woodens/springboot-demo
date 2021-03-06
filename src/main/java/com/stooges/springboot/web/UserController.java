package com.stooges.springboot.web;

import com.stooges.springboot.domain.User;
import com.stooges.springboot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 用户控制类
 * @author 张超
 * @date 2017/3/14.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    // 创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    @Autowired
    private UserService userService;

    /**
     * 获取用户基本信息
     * @return
     */
    @ApiOperation(value = "获取用户列表",notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = userService.findUserList();
        return r;
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户",notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体User",required = true,dataType = "User")
    @RequestMapping(value={""}, method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        userService.create(user.getName(),user.getAge());
        return "success";
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    /**
     * 更新用户详细信息
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
