package com.muco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.muco.dao.QuestionDao;
import com.muco.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class QuestionController
{
    @Autowired
    QuestionDao qDao;

    @RequestMapping("/question.htm")
    public String question() {

        return "question.jsp";
    }

    @RequestMapping("saveQuestion.htm")
    public ModelAndView saveQuestion(@ModelAttribute Question q) {
        ModelAndView mv = new ModelAndView("printQuestions.jsp");
        qDao.saveQuestion(q);
        return mv;
    }

    @RequestMapping("getQuestions")
    @ResponseBody
    public List<Question> getQuestions()
    {
        List<Question> questions = qDao.getTestQuestions();

        System.out.println(questions);

        return questions;
    }

    @RequestMapping("/test.htm")
    public ModelAndView test()
    {
        ModelAndView mv = new ModelAndView("test.jsp");

        return mv;
    }

//    @RequestMapping("/verify.htm")
//    public ModelAndView verify(@ModelAttribute Quest quest)
//    {
//        ModelAndView mv = new ModelAndView("result.jsp");
//        System.out.println(qid1);
//        return mv;
//    }
}