package com.muco;

import com.muco.service.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("t1") int t1, @RequestParam("t2") int t2, HttpServletRequest request, HttpServletResponse response) {

//        int t1 = Integer.parseInt(request.getParameter("t1"));
//        int t2 = Integer.parseInt(request.getParameter("t2"));
//        int sum = t1 + t2;

        int sum = AddService.add(t1, t2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display");
        modelAndView.addObject("result", sum);

        return modelAndView;
    }
}
