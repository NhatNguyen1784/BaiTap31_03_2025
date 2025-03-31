package vn.hcmute.app.model;

import java.io.Serializable;

public class Images implements Serializable {
    private int imgId;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public Images(int imgId) {
        this.imgId = imgId;
    }
}
