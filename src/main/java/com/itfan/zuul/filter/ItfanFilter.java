package com.itfan.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: ralap
 * @date: created at 2018/1/12 11:38
 */
@Component
public class ItfanFilter extends ZuulFilter {

    public static final Logger logger = LoggerFactory.getLogger(ItfanFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest reques = context.getRequest();
        logger.info("请求IP: " + reques.getRemoteHost());
        logger.info("send {} request {}", reques.getMethod(), reques.getRequestURL().toString());
        String token = reques.getParameter("accessToken");
        if (token == null) {
            logger.info("access token is null");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.getResponse().setCharacterEncoding("UTF-8");
            context.setResponseBody("<h1>没有权限访问</h1>");
            return null;
        }

        logger.info("access is ok");
        return null;

    }
}
