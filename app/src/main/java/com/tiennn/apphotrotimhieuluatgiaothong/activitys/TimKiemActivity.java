package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.VideoYouTubeAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.models.VideoYouTube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimKiemActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    VideoYouTubeAdapter adapter;

    ArrayList<VideoYouTube> arrayVideo;

    private ListView lv_timKiem;
    private ImageView imgReturn;
    private SearchView searchView;
    private LinearLayout ll_timkiemvideo;

    String urlGetJson ="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL-Jb0pGe73AHx9g8ERZfelLqKe0XRaxIO&key=AIzaSyApcGDUOHfrLtd3ZWG7jKJdG2dG6RM7U24&maxResults=50";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);

        ll_timkiemvideo = findViewById(R.id.ll_timkiemvideo);
        Intent i1 = getIntent();
        int value = i1.getIntExtra("KEY1",getResources().getColor(R.color.xanh1));
        ll_timkiemvideo.setBackgroundColor(value);

        lv_timKiem = findViewById(R.id.lv_timKiem);

        searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(this);

        arrayVideo = new ArrayList<>();

        //adapter = new VideoYouTubeAdapter(this,R.layout.row_video_youtube,arrayVideo);
        //lv_timKiem.setAdapter(adapter);

        GetJsonYoutube(urlGetJson);


        lv_timKiem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TimKiemActivity.this, PlayVideoActivity.class);
                intent.putExtra("idVideoYouTube",arrayVideo.get(i).getIdVideo());
                startActivity(intent);
            }
        });


        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_timkiemvideo.getBackground();
                int manau2 = colorDrawable.getColor();
                Intent i5 = new Intent(TimKiemActivity.this,MenuTimKiemActivity.class);
                i5.putExtra("KEY",manau2);
                startActivity(i5);
            }
        });
    }


    private void GetJsonYoutube(String API_KEY){
        final RequestQueue requestQueue = Volley.newRequestQueue(TimKiemActivity.this);
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

                            //adapter.notifyDataSetChanged();

                            adapter = new VideoYouTubeAdapter(TimKiemActivity.this,R.layout.row_video_youtube,arrayVideo);
                            lv_timKiem.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TimKiemActivity.this,"loi",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filer(text);
        return false;
    }
}
