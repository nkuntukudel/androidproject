package com.qq.nps16signup.network.response;
public class Data
{
    private String guid;

    private String sludge;

    private String name;

    private boolean status;

    private String image;

    private String language;

    private int position;

    private String createdAt;

    private String updatedAt;

    public void setGuid(String guid){
        this.guid = guid;
    }
    public String getGuid(){
        return this.guid;
    }
    public void setSludge(String sludge){
        this.sludge = sludge;
    }
    public String getSludge(){
        return this.sludge;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return this.image;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }

}
