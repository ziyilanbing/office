package com.glad.aspectj.pointcut;

import org.aspectj.lang.JoinPoint;

public interface IStandardPointCut {

	public abstract void before(JoinPoint joinPoint);

	public abstract void afterReturning(JoinPoint joinPoint, Object result);

	public abstract void afterThrowing(JoinPoint joinPoint, Exception ex);

}
