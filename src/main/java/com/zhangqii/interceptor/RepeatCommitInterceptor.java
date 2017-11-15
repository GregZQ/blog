package com.zhangqii.interceptor;

import com.zhangqii.annocation.Token;
import org.springframework.cglib.transform.impl.InterceptFieldTransformer;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Jone on 2017-11-13.
 */
public class RepeatCommitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        if (o instanceof HandlerMethod){
            HandlerMethod handlerMethod= (HandlerMethod) o;
            Method method=handlerMethod.getMethod();
            Token annocation=method.getAnnotation(Token.class);

            if (annocation!=null){
                boolean needSaveSession=annocation.save();
                if(needSaveSession){
                    System.out.println("当前可以提交文件");
                    httpServletRequest.getSession(true).
                            setAttribute("token", UUID.randomUUID().toString());
                }

                boolean needRemoveSession=annocation.remove();
                if (needRemoveSession){
                    System.out.println("需要删除文件");
                    if (isRepeatSubmit(httpServletRequest)){
                        httpServletResponse.getWriter().write("不得重复提交~");
                        return  false;
                    }
                    System.out.println("可以执行");
                    httpServletRequest.getSession(true).removeAttribute("token");
                }else{
                    System.out.println("当前不需要删除");
                }
            }
            return  true;
        }
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public  boolean isRepeatSubmit(HttpServletRequest request){
        String serverToken= (String) request.getSession(true).getAttribute("token");
        if (serverToken==null){
            return  true;
        }
        String clinetToken=request.getParameter("token");
        if (clinetToken==null){
            return  true;
        }
        if (!serverToken.equals(clinetToken)){
            return  true;
        }
        return  false;

    }
}
