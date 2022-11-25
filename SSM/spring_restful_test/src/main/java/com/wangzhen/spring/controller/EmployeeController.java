package com.wangzhen.spring.controller;

import com.wangzhen.spring.dao.EmployeeDao;
import com.wangzhen.spring.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author wz
 * @ClassName EmployeeController
 * @date 2022/10/13 18:08
 * @Description TODO
 */
@Controller
public class EmployeeController {
    // 创建dao实例
    EmployeeDao dao = new EmployeeDao();

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String selectAll(Model model){
        // 查询所有
        Collection<Employee> employees = dao.getAll();
        // 向域中共享数据
        model.addAttribute("allEmployee",employees);
        // 查询所有
        return "employee_list";

    }

    /**
     * 添加employee
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        // 调取dao  完成添加
        dao.save(employee);
        // 重定向页面
        return "redirect:/employee";
    }

    /**
     * 根据id回显数据
     * @param
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        // 查询要回显的employee
        Employee employee = dao.get(id);
        if(employee == null){
            model.addAttribute("message","修改失败~用户不存在");
            return "employee_update";
        }
        // 回显查询的数据
        model.addAttribute("employee",employee);
        // 跳转到修改页面
        return "employee_update";
    }

    /**
     * 根据employee对象实现修改，修改后跳转到查询所有
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployeeByName(Employee employee){

        // 实现添加
        dao.save(employee);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") Integer id, Model model){
        Employee employee = dao.get(id);
        if(employee == null){
            model.addAttribute("message","删除失败~");
            return "redirect:/employee";
        }
        dao.delete(id);
        return "redirect:/employee";
    }

}
