package com.van.dusty.velocity;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:40
 **/
public class PageUtil {
    public PageUtil() {
    }

    public static Paginator pager(int currentPage, int pageSize, int total) {
        Paginator pg = new Paginator(pageSize, total);
        pg.setPage(currentPage);
        return pg;
    }
}
