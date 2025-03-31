package vn.hcmute.app.network.api;

import vn.hcmute.app.model.MessageModel;

public interface ApiService {
    @FormUrlEncoded
    @POST("newimagesmanager.php")
    Call<MessageModel> LoadImageSlider(@Field("position") int position);
}
