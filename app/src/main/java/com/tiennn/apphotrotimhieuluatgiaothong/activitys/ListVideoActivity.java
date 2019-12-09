package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.models.VideoYouTube;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.VideoYouTubeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListVideoActivity extends AppCompatActivity {
    ListView lvVideo;
    ArrayList<VideoYouTube> arrayVideo;
    VideoYouTubeAdapter adapter;

    private ImageView imgReturn;
    private LinearLayout ll_video;


    public static String API_KEY1 = "AIzaSyB4VA5OIWwh4Ap-PU_8QsEuyXutWf_YwnA";
    String ID_PLAY_LIST ="PL-Jb0pGe73AHx9g8ERZfelLqKe0XRaxIO";
    String urlGetJson ="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL-Jb0pGe73AHx9g8ERZfelLqKe0XRaxIO&key=AIzaSyApcGDUOHfrLtd3ZWG7jKJdG2dG6RM7U24&maxResults=50";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);

        ll_video = findViewById(R.id.ll_video);

        Intent i3 = getIntent();
        int value = i3.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_video.setBackgroundColor(value);

        lvVideo = findViewById(R.id.lvVideo);
        arrayVideo = new ArrayList<>();
        adapter = new VideoYouTubeAdapter(this,R.layout.row_video_youtube,arrayVideo);
        lvVideo.setAdapter(adapter);

        GetJsonYoutube(urlGetJson);

        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListVideoActivity.this, PlayVideoActivity.class);
                intent.putExtra("idVideoYouTube",arrayVideo.get(i).getIdVideo());
                startActivity(intent);
            }
        });

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListVideoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void GetJsonYoutube(String API_KEY){
        final RequestQueue requestQueue = Volley.newRequestQueue(ListVideoActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_KEY, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonItems = response.getJSONArray("items");

                            String title = "";
                            String url = "";
                            String idVideo = "";

                            for (int i = 0 ; i < jsonItems.length() ; i++){
                                JSONObject jsonItem = jsonItems.getJSONObject(i);

                                JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                                title = jsonSnippet.getString("title");

                                JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");

                                url = jsonMedium.getString("url");

                                JSONObject jsonResourceID = jsonSnippet.getJSONObject("resourceId");
                                idVideo = jsonResourceID.getString("videoId");

                                arrayVideo.add(new VideoYouTube(title,url,idVideo));
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListVideoActivity.this,"loi",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
