package com.glad.aspectj;

import org.aspectj.lang.JoinPoint;

import com.glad.aspectj.pointcut.IAllRoundPointCut;

public abstract class AbstractAdvice implements IAllRoundPointCut {

	@Override
	public void before(JoinPoint joinPoint) {

	}

	@Override
	public void afterReturning(JoinPoint joinPoint, Object result) {

	}

	@Override
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {

	}

	@Override
	public void around(JoinPoint joinPoint) {

	}

	@Override
	public void after(JoinPoint joinPoint) {

	}
}
