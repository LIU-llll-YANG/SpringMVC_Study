package com.liuyang.springmvc.controller;

import com.liuyang.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SpringMvc {

    @RequestMapping("/testForRequestParameters")
    public String testForRequestParameters(@RequestParam(value = "username", required = false, defaultValue = "liuneng") String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/testForRequestParametersByPojo")
    public String testForRequestParametersByPojo(User user) {
        System.out.println("user = " + user);
        return "success";
    }

    /**
     * 测试域对象共享数据--> 使用ServletAPI向request域对象共享数据
     */
    //@RequestMapping("/testDataCanBeShar")
    //public String testDataCanBeShar(HttpServletRequest request){
    //    request.setAttribute("liuyang","123456");
    //    Object o = request.getAttribute("liuyang");
    //    System.out.println("o = " + o);
    //    return "success";
    //}

    /**
     * 测试域对象共享数据--> 使用ModelAndView向request域对象共享数据
     */
    //@RequestMapping("/testDataCanBeSharByModeAndView")
    //public ModelAndView testDataCanBeSharByModeAndView() {
    //    ModelAndView mav = new ModelAndView();
    //    mav.addObject("liuyang", "123456");
    //    ModelMap modelMap = mav.getModelMap();
    //    Object o = modelMap.get("liuyang");
    //    System.out.println("o = " + o);
    //    mav.setViewName("success");
    //    return mav;
    //}

    /**
     * 测试域对象共享数据--> 使用Model向request域对象共享数据
     */
    //@RequestMapping("/testDataCanBeSharByModel")
    //public String testDataCanBeSharByModel(Model model) {
    //    model.addAttribute("liuyang", "123456");
    //    System.out.println("model.getAttribute(\"liuyang\") = " + model.getAttribute("liuyang"));
    //    return "success";
    //}

    /**
     * 测试域对象共享数据--> 向session域共享数据
     */



    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        //session.setAttribute("liuyang","sessicon中的数据");
        //return "forward:/testApplication";
        //return "redirect:/testApplication";
        return "success";
    }
  /**
     * 测试域对象共享数据--> 向application域共享数据
     */
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        //ServletContext servletContext = session.getServletContext();
        //servletContext.setAttribute("liuyang","application中的数据");
        return "success";
    }

}
