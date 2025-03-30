package vn.hcmute.app.model;

import java.io.Serializable;

public class Icon implements Serializable {
    private Integer imgId;
    private String imgName;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Icon(Integer imgId, String imgName) {
        this.imgId = imgId;
        this.imgName = imgName;
    }
}
