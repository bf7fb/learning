package com.wangzhen.spring;

import com.wangzhen.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wz
 * @ClassName controller
 * @date 2022/10/3 15:15
 * @Description TODO
 */
@Controller
public class controller {
    // 什么都不跳转 都不做 默认范围index.html
//    @RequestMapping("/")
//    public String index() {
//    //设置视图名称
//        return "index";
//    }
    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }

    @RequestMapping("/test/rest/{id}/{username}" )
    public String testForChar(@PathVariable("username") String username, @PathVariable("id") Integer id){
        System.out.println("username = " + username + "id = " + id);
        return "hi";
    }
    @RequestMapping("/param")
    public String getParm(String username,String password){
        System.out.println("username = " + username + " password = " + password );
        return "hi";
    }
    @RequestMapping("/param/pojo")
    public String getPojo(User user){
        System.out.println(user);
        return "hi";
    }

    @RequestMapping("/test/ModelAndView")
    public ModelAndView testForRequest(){
        // 创建对象
        ModelAndView mav = new ModelAndView();
        // 向域中共享值
        mav.addObject("modelAndViewrequestScope","hello modelAndView");
        // 跳转页面
        mav.setViewName("hi");
        return mav;
    }
    @RequestMapping("/test/Model")
    public String testForModel(Model model){
        model.addAttribute("modelRequestScope","hello model");
        return "hi";
    }
    @RequestMapping("/test/session")
    public String testForSession(HttpSession session){
        session.setAttribute("sessionScope","hello session");
        return "hi";
    }
    @RequestMapping("/test/Application")
    public String testForApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("applicationScope","hello application");
        return "hi";
    }
    @RequestMapping("/test/view/thymleafview")
    public String testForThymleafView(){
        return "hi";
    }

    @RequestMapping("/test/donwload")
    public ResponseEntity<byte[]> donwload (HttpSession session) throws Exception {
        // 获取servletcont对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中真实路径
        String realPath = servletContext.getRealPath("/img/a.jpg");
        System.out.println("realpath = " + realPath);
        // 创建输入流
        FileInputStream fis = new FileInputStream(realPath);
        // 创建字节数组 长度为文件字节大小
        byte[] bytes = new byte[fis.available()];
        // 将文件读入到bytes数组中
        fis.read(bytes);
        // 创建httpheaders
        MultiValueMap<String,String> httpHeaders = new HttpHeaders();
        // 设置下载方式以及下载的文件名称
        httpHeaders.add("Content-Disposition", "attachment;filename=a.jpg");
        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, statusCode);
        // 关闭流
        fis.close();
        // 返回
        return responseEntity;


    }

    @RequestMapping("/test/up")
    public String up(MultipartFile photo, HttpSession session) throws IOException {
        // 获取上传的文件名称
        String fileName = photo.getOriginalFilename();
        // 处理文件同名问题  .jpg
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        // fileName = b0e9c110-e742-4165-a659-5b63233118cc.jpg
//        System.out.println("fileName = " + fileName);
        // 获取服务器中photo目录  默认在webapp下
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        //    photoPath = D:\code java\SSM\springMVC_helloworld\src\main\webapp\photo
//        System.out.println("photoPath = " + photoPath);
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
//        finalPath = D:\code java\SSM\springMVC_helloworld\src\main\webapp\photo\b0e9c110-e742-4165-a659-5b63233118cc.jpg
//        System.out.println("finalPath = " + finalPath);
        // 实现上传
        photo.transferTo(new File(finalPath));
        // 跳转页面
        return "hi";

    }




}
