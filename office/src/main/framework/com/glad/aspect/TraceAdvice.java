package com.glad.aspect;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.aspectj.AbstractAdvice;

public final class TraceAdvice extends AbstractAdvice {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TraceAdvice.class);

	/**
	 * default
	 */
	private TraceAdvice() {

	}

	@Override
	public void before(JoinPoint joinPoint) {

		String classname = joinPoint.getTarget().getClass().getName();

		Signature methodInfo = joinPoint.getSignature();
		String methodName = methodInfo.getName();

		String arguments = formatArguments(joinPoint.getArgs());

		logger.trace(String.format("TraceAdvice  %s.%s(%s)", classname, methodName, arguments));
	}

	@Override
	public void afterReturning(JoinPoint joinPoint, Object result) {

		String classname = joinPoint.getTarget().getClass().getName();

		MethodSignature methodInfo = (MethodSignature) joinPoint.getSignature();
		String methodName = methodInfo.getName();
		Class<?> returnType = methodInfo.getReturnType();
		if (returnType.equals(void.class)) {
			result = "<void>";
		}

		logger.trace(String.format("TraceAdvice  %s.%s | Return=[%s <%s>]", classname, methodName, result, returnType));
	}

	@Override
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String classname = joinPoint.getTarget().getClass().getName();

		MethodSignature methodInfo = (MethodSignature) joinPoint.getSignature();
		String methodName = methodInfo.getName();

		logger.warn(String.format("TraceAdvice  %s.%s | Throws=[%s <%s>]", classname, methodName, ex.getMessage(),
				ex.getClass().getSimpleName()));
	}

	private static String formatArguments(Object[] args) {
		StringBuilder result = new StringBuilder(args.length * 32);
		for (Object arg : args) {
			result.append(result.length() <= 0 ? StringUtils.EMPTY : ",");
			result.append(arg);
		}
		return result.length() > 0 ? result.toString() : "<void>";
	}

}
