package com.hand.exam.vo;

import com.hand.exam.entity.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
@Component
public class RequestJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(ParamModel.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		Page pa = new Page();
		String page = nativeRequest.getParameter("page");
		String pagesize = nativeRequest.getParameter("pageSize");

		pa.setPage(Integer.valueOf(page));
		pa.setPageSize(Integer.valueOf(pagesize));
		return pa;
	}



}
