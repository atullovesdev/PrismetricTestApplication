package com.e.prismetrictestapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.prismetrictestapplication.AdapterList.AdapterClass;
import com.e.prismetrictestapplication.ListModel.ModelList;
import com.e.prismetrictestapplication.utilClasses.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * This is Main Activity created for handles ui based logics.
 *
 * @author Atu Mishra
 */
public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static AdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);


        if (Utility.INSTANCE.isNetworkAvailable(MainActivity.this)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Network is available", Toast.LENGTH_SHORT);
            toast.show();
            Utility.INSTANCE.locationDetails(MainActivity.this);
            Recyclerview();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Network is not available", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private void Recyclerview() {
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

    }


    public static void Update(Activity activity, String response) {
        if (!response.isEmpty()) {
            Gson gson = new Gson();
            List<ModelList> modelRespList = gson.fromJson(response, new TypeToken<List<ModelList>>() {
            }.getType());
            Log.d("sonubhai", modelRespList.get(0).getAddress().getGeo().getLat());

            adapterClass = new AdapterClass(activity.getApplicationContext(), modelRespList);
            recyclerView.setAdapter(adapterClass);
            adapterClass.notifyDataSetChanged();


//            locAdapter = new ListAdapter(activity, collaboratorResponse);
//            rv.setAdapter(locAdapter);
//            locAdapter.notifyDataSetChanged();
        } else {

        }
    }


}