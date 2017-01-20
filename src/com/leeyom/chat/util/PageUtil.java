package com.leeyom.chat.util;

public class PageUtil {
	// ��ȡ��ҳ��
	public static int getPageCount(int rowCount, int pageSize) {
		return (rowCount + pageSize - 1) / pageSize;
	}

	// ��ȡ��ǰҳ
	public static int getCurrentPage(int rowCount, int pageSize, int currentPage) {
		if (currentPage - getPageCount(rowCount, pageSize) == 1) {
			currentPage--;
		}
		if (currentPage - getPageCount(rowCount, pageSize) > 1
				|| currentPage < 1) {
			currentPage = 1;
		}
		if (rowCount == 0)
			currentPage = 0;
		return currentPage;
	}
}
