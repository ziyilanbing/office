package com.glad.aspectj.pointcut;

import org.aspectj.lang.JoinPoint;

public interface IAllRoundPointCut extends IStandardPointCut {

	public abstract void around(JoinPoint joinPoint);

	public abstract void after(JoinPoint joinPoint);

}
