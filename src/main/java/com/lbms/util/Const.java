package com.lbms.util;
public class Const {
	public static final int AD_SIZE = Integer.parseInt(ConfigUtils.getValue("AD_SIZE"));
	public static final int INDEX_INFORMATION_PAGE_SIZE = Integer
			.parseInt(ConfigUtils.getValue("INDEX_INFORMATION_PAGE_SIZE"));
	public static final int COMMENT_PAGE_SIZE = Integer.parseInt(ConfigUtils.getValue("COMMENT_PAGE_SIZE"));
	public static final int COMMENT_CHILD_PAGE_SIZE = Integer.parseInt(ConfigUtils.getValue("COMMENT_CHILD_PAGE_SIZE"));
	public static final String IMAGE_DOMAIN = ConfigUtils.getValue("IMAGE_DOMAIN");
	public static final int INFORMATION_PAGE_SIZE = Integer.parseInt(ConfigUtils.getValue("INFORMATION_PAGE_SIZE"));
	public static final int FAVORITE_PAGE_SIZE = Integer.parseInt(ConfigUtils.getValue("FAVORITE_PAGE_SIZE"));
	public static final String USER_DEFAULT_IMAGE = ConfigUtils.getValue("USER_DEFAULT_IMAGE");
}
