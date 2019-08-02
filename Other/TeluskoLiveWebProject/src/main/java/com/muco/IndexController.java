package com.muco;

import com.muco.dao.FeedbackDao;
import com.muco.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    FeedbackDao fdao;

    @RequestMapping("/")
    public String home() {

        return "index.jsp";
    }

    @RequestMapping("/feedback.htm")
    public String feedback() {

        return "feedback.jsp";
    }

    @RequestMapping("/addFeedback")
    public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {

        fdao.addFeedback(feedback);
        return "index.jsp";
    }

    @RequestMapping("/getFeedbacks.htm")
    public ModelAndView getFeedbacks() {

        ModelAndView modelAndView = new ModelAndView("feedbacks.jsp");

        modelAndView.addObject("feedbacks", fdao.getFeedbacks());
        return modelAndView;
    }
}
