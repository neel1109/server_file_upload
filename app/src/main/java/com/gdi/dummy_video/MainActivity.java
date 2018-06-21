package com.gdi.dummy_video;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int RESULT_LOAD_VIDEO = 1;
    String filemanagerstring, selectedImagePath, pathToStoredVideo,pathToStoredImage;
    private Button btnImage, btnVideo, btnPost;
    private TextView tvImage, tvVideo;
    private int REQUEST_TAKE_GALLERY_VIDEO = 1,REQUEST_TAKE_GALLERY_IMAGE=2;
    private Uri selectedVideoUri,selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImage = (Button) findViewById(R.id.btnImage);
        btnVideo = (Button) findViewById(R.id.btnVideo);
        btnPost = (Button) findViewById(R.id.btnPost);
        tvImage = (TextView) findViewById(R.id.tvImage);
        tvVideo = (TextView) findViewById(R.id.tvVideo);
        btnImage.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        btnPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnImage) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Image"), REQUEST_TAKE_GALLERY_IMAGE);

        }
        if (view == btnVideo) {
            Intent intent = new Intent();
            intent.setType("video/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Video"), REQUEST_TAKE_GALLERY_VIDEO);

        }
        if (view == btnPost) {
            uploadVideo(pathToStoredVideo,pathToStoredImage);
        }
    }

    private void uploadVideo(String pathToStoredVideo, String pathToStoredImage) {

        File imageFile = new File(pathToStoredImage);
        File videoFile = new File(pathToStoredVideo);
        RequestBody imageBody = RequestBody.create(MediaType.parse("image/*"), imageFile);
        RequestBody videoBody = RequestBody.create(MediaType.parse("video/*"), videoFile);
        MultipartBody.Part iFile = MultipartBody.Part.createFormData("thumbnail", imageFile.getName(), imageBody);
        MultipartBody.Part vFile = MultipartBody.Part.createFormData("video", videoFile.getName(), videoBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.255.249.65/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Video service = retrofit.create(Video.class);
        Call<ModelResponse> call = service.uploadVideoToServer(vFile,iFile, "http://54.255.249.65/socialcommerce-laravel/public/api/uploadvideo");
        call.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call,
                                   Response<ModelResponse> response) {
                Log.v("Upload", "success");
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO) {
                selectedVideoUri = data.getData();

                // OI FILE Manager

                try {
                    pathToStoredVideo = PathUtil.getPath(getApplicationContext(), selectedVideoUri);
                    tvVideo.setText(pathToStoredVideo);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }


            }
            if (requestCode == REQUEST_TAKE_GALLERY_IMAGE) {
                selectedImageUri = data.getData();

                // OI FILE Manager

                try {
                    pathToStoredImage = PathUtil.getPath(getApplicationContext(), selectedImageUri);
                    tvImage.setText(pathToStoredImage);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }


            }
        }
    }


}