package com.glad.aspectj;

import org.aspectj.lang.JoinPoint;

import com.glad.aspectj.pointcut.IAllRoundPointCut;

public class GenericAdvisor<TAdvice extends AbstractAdvice> implements IAllRoundPointCut {

	private final TAdvice advice;

	protected GenericAdvisor() {
		throw new UnsupportedOperationException("This constuctor is invalid");
	}

	protected GenericAdvisor(TAdvice advice) {
		this.advice = advice;
	}

	@Override
	public void before(JoinPoint joinPoint) {
		this.advice.around(joinPoint);

	}

	@Override
	public void afterReturning(JoinPoint joinPoint, Object result) {
		this.advice.afterReturning(joinPoint, result);

	}

	@Override
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		this.advice.afterThrowing(joinPoint, ex);
	}

	@Override
	public void around(JoinPoint joinPoint) {
		this.advice.around(joinPoint);
	}

	@Override
	public void after(JoinPoint joinPoint) {
		this.advice.after(joinPoint);

	}

}
