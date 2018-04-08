package com.ifading.coinmarket.bean;

import java.util.List;

/**
 * Created  on 20180330//.
 *
 * @author by yangjingsheng
 */
public class ReadHubNewData {

    private String id;

    private String createdAt;

    private String eventData;

    private List<NewsArray> newsArray;

    private int order;

    private String publishDate;

    private String summary;

    private String title;

    private String updatedAt;

    private String timeline;

    private Extra extra;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setEventData(String eventData){
        this.eventData = eventData;
    }
    public String getEventData(){
        return this.eventData;
    }
    public void setNewsArray(List<NewsArray> newsArray){
        this.newsArray = newsArray;
    }
    public List<NewsArray> getNewsArray(){
        return this.newsArray;
    }
    public void setOrder(int order){
        this.order = order;
    }
    public int getOrder(){
        return this.order;
    }
    public void setPublishDate(String publishDate){
        this.publishDate = publishDate;
    }
    public String getPublishDate(){
        return this.publishDate;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getSummary(){
        return this.summary;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }
    public void setTimeline(String timeline){
        this.timeline = timeline;
    }
    public String getTimeline(){
        return this.timeline;
    }
    public void setExtra(Extra extra){
        this.extra = extra;
    }
    public Extra getExtra(){
        return this.extra;
    }

    public class Extra
    {
        private boolean instantView;

        public void setInstantView(boolean instantView){
            this.instantView = instantView;
        }
        public boolean getInstantView(){
            return this.instantView;
        }
    }


    public class NewsArray
    {
        private int id;

        private String url;

        private String title;

        private int groupId;

        private String siteName;

        private String siteSlug;

        private String mobileUrl;

        private String authorName;

        private int duplicateId;

        private String publishDate;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setGroupId(int groupId){
            this.groupId = groupId;
        }
        public int getGroupId(){
            return this.groupId;
        }
        public void setSiteName(String siteName){
            this.siteName = siteName;
        }
        public String getSiteName(){
            return this.siteName;
        }
        public void setSiteSlug(String siteSlug){
            this.siteSlug = siteSlug;
        }
        public String getSiteSlug(){
            return this.siteSlug;
        }
        public void setMobileUrl(String mobileUrl){
            this.mobileUrl = mobileUrl;
        }
        public String getMobileUrl(){
            return this.mobileUrl;
        }
        public void setAuthorName(String authorName){
            this.authorName = authorName;
        }
        public String getAuthorName(){
            return this.authorName;
        }
        public void setDuplicateId(int duplicateId){
            this.duplicateId = duplicateId;
        }
        public int getDuplicateId(){
            return this.duplicateId;
        }
        public void setPublishDate(String publishDate){
            this.publishDate = publishDate;
        }
        public String getPublishDate(){
            return this.publishDate;
        }
    }


    public class Location
    {
    }

    public class Azure
    {
        private double weight;

        public void setWeight(double weight){
            this.weight = weight;
        }
        public double getWeight(){
            return this.weight;
        }
    }


    public class Windows
    {
        private double weight;

        public void setWeight(double weight){
            this.weight = weight;
        }
        public double getWeight(){
            return this.weight;
        }
    }

    public class Product
    {
        private Azure Azure;

        private Windows Windows;

        public void setAzure(Azure Azure){
            this.Azure = Azure;
        }
        public Azure getAzure(){
            return this.Azure;
        }
        public void setWindows(Windows Windows){
            this.Windows = Windows;
        }
        public Windows getWindows(){
            return this.Windows;
        }
    }


    public class Result
    {
        private double weight;

        private String nerName;

        private int entityId;

        private String entityName;

        private String entityType;

        private int entityUniqueId;

        public void setWeight(double weight){
            this.weight = weight;
        }
        public double getWeight(){
            return this.weight;
        }
        public void setNerName(String nerName){
            this.nerName = nerName;
        }
        public String getNerName(){
            return this.nerName;
        }
        public void setEntityId(int entityId){
            this.entityId = entityId;
        }
        public int getEntityId(){
            return this.entityId;
        }
        public void setEntityName(String entityName){
            this.entityName = entityName;
        }
        public String getEntityName(){
            return this.entityName;
        }
        public void setEntityType(String entityType){
            this.entityType = entityType;
        }
        public String getEntityType(){
            return this.entityType;
        }
        public void setEntityUniqueId(int entityUniqueId){
            this.entityUniqueId = entityUniqueId;
        }
        public int getEntityUniqueId(){
            return this.entityUniqueId;
        }
    }

}
