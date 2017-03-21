package com.glad.message;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.MessageSource;

public class LocalizeMessageSource {
	private final MessageSource source;
	private final Locale locale;

	public LocalizeMessageSource(MessageSource source) {
		this(source, Locale.getDefault());
	}

	public LocalizeMessageSource(MessageSource source, Locale locale) {
		this.source = source;
		this.locale = locale;
	}

	public final String getMessage(String code) {
		Object[] args = null;
		return this.getMessage(code, args);
	}

	private String getMessage(String code, Object... args) {
		String message = this.source.getMessage(code, args, this.locale);
		Pattern pattern = Pattern.compile("(\\$\\{.+?\\})");
		Matcher matcher;
		while ((matcher = pattern.matcher(message)).find()) {
			String match = matcher.group();
			String replacement = this.getMessage(match.substring(2, match.length() - 2));
			message = matcher.replaceFirst(replacement);
		}
		return message;
	}

}
