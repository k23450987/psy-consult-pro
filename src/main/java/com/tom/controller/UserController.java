package com.tom.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.model.User;
import com.tom.model.UserRole;
import com.tom.service.UserRoleService;
import com.tom.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/users")
    public Map<String, Object> data(Integer page, Integer rows, String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            PageHelper.startPage(page, rows);
            List<User> users = userService.findUsers();
            PageInfo pageInfo = new PageInfo(users);
            result.put("datas", users);
            result.put("total", pageInfo.getTotal());
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/user")
    public Map<String, Object> get(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", userService.get(id));
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/user")
    public Map<String, Object> add(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (userService.findByUsername(user.getUsername()) == null) {
                userService.insert(user);
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(2);
                userRoleService.insert(userRole);
                map.put("success", true);
                map.put("id", user.getId());
            } else {
                map.put("success", false);
                map.put("msg", "用户名已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @PutMapping("/user")
    public Map<String, Object> update(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.update(user);
            map.put("success", true);
            map.put("id", user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @DeleteMapping("/user")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }
}
