package com.ifading.coinmarket.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created  on 20180408//.
 *
 * @author by yangjingsheng
 */
public class NewsData {

    private List<Data> data;

    private int pageSize;

    private int totalItems;

    private int totalPages;

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    public class Data implements MultiItemEntity {

        public static final int TYPE_WITH_SUMMARY = 1;
        public static final int TYPE_WITHOUT_SUMMARY = 0;

        private int id;

        private String title;

        private String summary;

        private String summaryAuto;

        private String url;

        private String mobileUrl;

        private String siteName;

        private String siteSlug;

        private String language;

        private String authorName;

        private String publishDate;

        private int itemType = TYPE_WITHOUT_SUMMARY;

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return this.summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSummaryAuto() {
            return this.summaryAuto;
        }

        public void setSummaryAuto(String summaryAuto) {
            this.summaryAuto = summaryAuto;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMobileUrl() {
            return this.mobileUrl;
        }

        public void setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
        }

        public String getSiteName() {
            return this.siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSiteSlug() {
            return this.siteSlug;
        }

        public void setSiteSlug(String siteSlug) {
            this.siteSlug = siteSlug;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getAuthorName() {
            return this.authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getPublishDate() {
            return this.publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }
    }

}
