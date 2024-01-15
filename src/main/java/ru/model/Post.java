package ru.model;

public class Post {
    private static final boolean IS_NOT_REMOVED = false;
    private long id;
    private String content;
    private boolean isRemoved;

    public Post() {
    }

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
        this.isRemoved = IS_NOT_REMOVED;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRemoved(){
        this.isRemoved = true;
    }

    public boolean getIsRemoved(){
        return this.isRemoved;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
