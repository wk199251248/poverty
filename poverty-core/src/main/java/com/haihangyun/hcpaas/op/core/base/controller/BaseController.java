package com.haihangyun.hcpaas.op.core.base.controller;

import com.haihangyun.hcpaas.op.core.base.result.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseController {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public BaseResult defaultErrorHandler(Exception e) throws Exception {
		BaseResult baseResult = new BaseResult();
		baseResult.setSuccess(false);
		baseResult.setType("error");
		baseResult.setMessage(e.getMessage());
		return baseResult;
	}

}
