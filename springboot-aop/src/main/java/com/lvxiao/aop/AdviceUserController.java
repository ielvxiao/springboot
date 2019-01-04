package com.lvxiao.aop;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author lvxiao
 * Date 2019-01-05 00:56
 * Description: 控制器通知 给控制器加通知
 * Version V1.0
 */
@ControllerAdvice(
        //指定被拦截的包
        basePackages = {"com.lvxiao.web.AdviceConstroller"}
        //指定只有@Controller才会被拦截
, annotations = Controller.class)
public class AdviceUserController {

    //绑定格式化、参数转换规则和增加验证器等
    @InitBinder
    public void initDataBinder(WebDataBinder binder) {
        //自定义日期编辑器
        CustomDateEditor dateEditor =
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    //在执行控制器前执行,可以初始化数据模型
    @ModelAttribute
    public void projectModel(Model model) {
        model.addAttribute("project_name", "testProject");
    }

    //异常处理，使得拦截的控制器发生异常时，都能用相同的视图响应
    @ExceptionHandler(value = Exception.class)
    public String exception(Model model, Exception ex) {
        model.addAttribute("exception_message", ex.getMessage());
        return "exception";
    }
}
