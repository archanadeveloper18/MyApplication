package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.model.items;
import com.example.myapplication.network.APIclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GridView grideView;
    CustomAdapter customAdapter;
    
    public static List<items> itemsList;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grideView = findViewById(R.id.gridView);

        itemsList = new ArrayList<>();

        //make network call
        Call<List<items>> call = APIclient.apIinterface().getitems();

        call.enqueue(new Callback<List<items>>() {
            @Override
            public void onResponse(Call<List<items>> call, Response<List<items>> response) {
                if(response.isSuccessful()){

                    itemsList = response.body();

                    customAdapter = new CustomAdapter(response.body(),MainActivity.this);

                    grideView.setAdapter(customAdapter);

                    //onclicklistiner is used in grideview when user click on the items of grideview it will show th detail screen.
                    grideView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //Intent to go to detail Activity
                            Intent intent = new Intent();

                            startActivity(new Intent(getApplicationContext(), DetailActivity.class)
                                    .putExtra("name", itemsList.get(position).getName())
                                    .putExtra("image",itemsList.get(position).getUrl())
                                    .putExtra("value",itemsList.get(position).getCurrentValue())
                                    .putExtra("description",itemsList.get(position).getDescription())
                                    .putExtra("terms",itemsList.get(position).getTerms()));
                        }
                    });


                    Log.d("body", response.body().toString());
                    Log.d("name", response.body().get(0).name);
                    Log.d("url", response.body().get(0).url);
                    Log.d("value", response.body().get(0).current_value.substring(1,5).trim());
                    for (int i = 0; i < response.body().size(); i++){
                        System.out.print(response.body().get(i).getCurrentValue().substring(1,5));

                    }

                }else{
                    Toast.makeText(getApplicationContext()," An error occured ", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<items>> call, Throwable t) {
                Toast.makeText(getApplicationContext()," An error occured "+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    //This methods is call when the user click the menu at the toolbar(top).
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //This methods is call when the user click the sub list of menu at the toolbar(top) it will go to browsebyctegory Screen..
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.category:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
            default:
            return super.onOptionsItemSelected(item);

        }
    }

}
