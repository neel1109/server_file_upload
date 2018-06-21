package com.gdi.dummy_video;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by sunarcneel on 21/6/18.
 */

public interface Video {

    @Multipart
    @POST
    Call<ModelResponse> uploadVideoToServer(@Part MultipartBody.Part video,@Part MultipartBody.Part image, @Url String path);
}
