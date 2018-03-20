package com.ifading.coinmarket.bean;

import java.util.List;

/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */


public class NewsResult {


    private boolean success;

    private String code;

    private String msg;

    private String requestId;

    private Data data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }


    public class Data {
        private int count;

        private String first_id;

        private String last_id;

        private List<News> news;

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return this.count;
        }

        public void setFirst_id(String first_id) {
            this.first_id = first_id;
        }

        public String getFirst_id() {
            return this.first_id;
        }

        public void setLast_id(String last_id) {
            this.last_id = last_id;
        }

        public String getLast_id() {
            return this.last_id;
        }

        public void setNews(List<News> news) {
            this.news = news;
        }

        public List<News> getNews() {
            return this.news;
        }

        public class News {
            private String news_id;

            private String title;

            private String source;

            private long gmt_publish;

            private int hot_index;

            private boolean selection;

            private List<String> category;

            private List<String> thumbnail_img;

            private String url;

            private String summary_create_time;

            private String summary_update_time;

            private String summary;

            private String content;

            public void setNews_id(String news_id) {
                this.news_id = news_id;
            }

            public String getNews_id() {
                return this.news_id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return this.title;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getSource() {
                return this.source;
            }

            public void setGmt_publish(long gmt_publish) {
                this.gmt_publish = gmt_publish;
            }

            public long getGmt_publish() {
                return this.gmt_publish;
            }

            public void setHot_index(int hot_index) {
                this.hot_index = hot_index;
            }

            public int getHot_index() {
                return this.hot_index;
            }

            public void setSelection(boolean selection) {
                this.selection = selection;
            }

            public boolean getSelection() {
                return this.selection;
            }

            public void setCategory(List<String> category) {
                this.category = category;
            }

            public List<String> getCategory() {
                return this.category;
            }

            public void setThumbnail_img(List<String> thumbnail_img) {
                this.thumbnail_img = thumbnail_img;
            }

            public List<String> getThumbnail_img() {
                return this.thumbnail_img;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return this.url;
            }

            public void setSummary_create_time(String summary_create_time) {
                this.summary_create_time = summary_create_time;
            }

            public String getSummary_create_time() {
                return this.summary_create_time;
            }

            public void setSummary_update_time(String summary_update_time) {
                this.summary_update_time = summary_update_time;
            }

            public String getSummary_update_time() {
                return this.summary_update_time;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getSummary() {
                return this.summary;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getContent() {
                return this.content;
            }

            @Override
            public String toString() {
                return "News{" +
                        "news_id='" + news_id + '\'' +
                        ", title='" + title + '\'' +
                        ", source='" + source + '\'' +
                        ", gmt_publish=" + gmt_publish +
                        ", hot_index=" + hot_index +
                        ", selection=" + selection +
                        ", category=" + category +
                        ", thumbnail_img=" + thumbnail_img +
                        ", url='" + url + '\'' +
                        ", summary_create_time='" + summary_create_time + '\'' +
                        ", summary_update_time='" + summary_update_time + '\'' +
                        ", summary='" + summary + '\'' +
                        ", content='" + content + '\'' +
                        '}';
            }


        }

        @Override
        public String toString() {
            return "Data{" +
                    "count=" + count +
                    ", first_id='" + first_id + '\'' +
                    ", last_id='" + last_id + '\'' +
                    ", news=" + news +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", requestId='" + requestId + '\'' +
                ", data=" + data +
                '}';
    }
}