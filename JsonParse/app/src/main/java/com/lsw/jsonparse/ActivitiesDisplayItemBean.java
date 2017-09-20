package com.lsw.jsonparse;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luosiwei on 2017/7/3.
 */

public class ActivitiesDisplayItemBean {
    // 对属性重新命名
    // 校外活动id
    @SerializedName("_id")
    private String outsideId;
    // 发表时间
    private Long when;
    // 地点
    @SerializedName("where")
    private String where1;
    //学科
    private String subject;
    // 主题
    private String content;
    //感想
    private String summary;
    // 相册资源
    private List<AssetsBean> assets;

    public String getOutsideId() {
        return outsideId;
    }

    public void setOutsideId(String outsideId) {
        this.outsideId = outsideId;
    }

    public Long getWhen() {
        return when;
    }

    public void setWhen(Long when) {
        this.when = when;
    }

    public String getWhere() {
        return where1;
    }

    public void setWhere(String where) {
        this.where1 = where;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<AssetsBean> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetsBean> assets) {
        this.assets = assets;
    }

    public class AssetsBean {
        // 媒体url
        private String url;
        // 媒体类型
        private String type;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "AssetsBean{" +
                    "url='" + url + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ActivitiesDisplayItemBean{" +
                "outsideId='" + outsideId + '\'' +
                ", when=" + when +
                ", where1='" + where1 + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", assets=" + assets +
                '}';
    }
}
