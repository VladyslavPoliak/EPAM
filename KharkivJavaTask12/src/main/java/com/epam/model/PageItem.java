package com.epam.model;

public class PageItem {

    private final String url;
    private final String caption;

    private PageItem(String url, String caption) {
        super();
        this.url = url;
        this.caption = caption;
    }

    static PageItem createCurrent(String caption) {
        return new PageItem(null, caption);
    }

    static PageItem createEllipsis() {
        return new PageItem(null, null);
    }

    static PageItem createPageItems(String url, String caption) {
        return new PageItem(url, caption);
    }

    public String getUrl() {
        return url;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isEllipsis() {
        return url == null && caption == null;
    }

    public boolean isCurrent() {
        return url == null && caption != null;
    }

    public boolean isPageItem() {
        return url != null && caption != null;
    }

}
