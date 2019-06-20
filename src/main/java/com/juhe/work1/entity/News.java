package com.juhe.work1.entity;

/**
 * 新闻实体类
 */
public class News {
    private String title;
    private String authorName;
    private String thumbnailPicS;//缩略图

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThumbnailPicS() {
        return thumbnailPicS;
    }

    public void setThumbnailPicS(String thumbnailPicS) {
        this.thumbnailPicS = thumbnailPicS;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", thumbnailPicS='" + thumbnailPicS + '\'' +
                '}';
    }
}
