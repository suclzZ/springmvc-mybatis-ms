package com.sucl.smms.system.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sucl.smms.system.model.User;
import com.sucl.smms.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sucl
 * @since 2019/3/25
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public List<User> getUsers(){
//        return userService.getUsers();
//    }

    @GetMapping
    public List<User> getUsers(User user){
        return userService.getUsers(user);
    }

    @GetMapping(params = {"pageNum","pageSize"})
    public PageInfo<User> getPageUser(Page<User> page){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> users = userService.getUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.selectByPrimaryKey(id);
    }

    @PostMapping
    public User save(User user){
        userService.insert(user);
        return user;
    }

    @PostMapping(params = "id")
    public User update(User user){
        userService.updateById(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.deleteById(id);
    }

}
