package com.harry.controller;

import com.harry.bean.User;
import com.harry.util.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * 实现简单的增删改查
 */
@Controller
public class UserController {
    /**
     * 查找所有用户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        HashMap<String, User> allUser = DataUtil.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("allUser", allUser);
        mv.setViewName("user_list");
        return mv;
    }

    @RequestMapping("/create.do")
    public String create(User user) throws Exception {
        DataUtil.create(user);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = DataUtil.findUserById(id);
        HashMap<String, User> allUser = new HashMap<>();
        allUser.put(id, user);
        mv.addObject("id", id);
        mv.addObject("allUser", allUser);
        mv.setViewName("user_list");
        return mv;
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete.do")
    public String delete(String id) throws Exception{
        DataUtil.delete(id);
        return "redirect:findAll.do";
    }

    /**
     * 用户跳转到修养用户页面
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/goUpdate.do")
    public ModelAndView goUpdate(String id) throws Exception{
        User user = DataUtil.findUserById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("id", id);
        mv.setViewName("user_update");
        return mv;
    }

    @RequestMapping("/update")
    public String update(String id, User user) throws Exception{
        DataUtil.update(id,user);
        return "redirect:findAll.do";
    }
}
