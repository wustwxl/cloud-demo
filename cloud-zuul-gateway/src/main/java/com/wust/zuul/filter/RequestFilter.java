package com.wust.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wust.utils.JsonUtil;
import com.wust.utils.StringUtil;
import com.wust.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 * 请求拦截 验证Token
 */
public class RequestFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class) ;

	/**
	 * 请求路由之前被拦截 实现 pre 拦截器
	 * @return
	 */
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

		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String token = request.getParameter("token");
		if (StringUtil.IsNullOrEmpty(token)){
			LOGGER.warn("========== The system need token.");
			//过滤请求
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(401);
			//currentContext.setResponseBody("Token Verification Failure.");
			MessageVo mess = new MessageVo().setCode(MessageVo.ZUUL).setInfo("Token Verification Failure.");
			currentContext.setResponseBody(JsonUtil.getJsonFromBean(mess));

			return  null;
		}
		LOGGER.info("---------- token = ",token) ;

		return null;
	}
}
