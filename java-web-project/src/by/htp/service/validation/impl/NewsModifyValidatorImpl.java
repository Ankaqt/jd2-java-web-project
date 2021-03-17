package by.htp.service.validation.impl;

import by.htp.bean.News;
import by.htp.service.validation.NewsModifyValidator;

public class NewsModifyValidatorImpl implements NewsModifyValidator {

	@Override
	public boolean checkNewsModify(News news) {

		String title = news.getTitle();
		String brief = news.getBrief();
		String content = news.getContent();

		boolean isAnyParamEqNull = title == null || "".equals(title) || brief == null || "".equals(brief)
				|| content == null || "".equals(content);

		if (isAnyParamEqNull) {
			return false;
		}

		boolean check = title.length() < 90 && title.length() > 1 && brief.length() < 400 && brief.length() > 1
				&& content.length() < 10000 && content.length() > 1;

		return check;
	}

}
