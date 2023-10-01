package com.e.prismetrictestapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.prismetrictestapplication.AdapterList.AdapterClass
import com.e.prismetrictestapplication.ListModel.ModelList
import com.e.prismetrictestapplication.utilClasses.Utility
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * This is Main Activity created for handles ui based logics.
 *
 * @author Atu Mishra
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        if (Utility.INSTANCE.isNetworkAvailable(this@MainActivity)) {
            val toast =
                Toast.makeText(applicationContext, "Network is available", Toast.LENGTH_SHORT)
            toast.show()
            Utility.INSTANCE.locationDetails(this@MainActivity)
            Recyclerview()
        } else {
            val toast =
                Toast.makeText(applicationContext, "Network is not available", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun Recyclerview() {
        val llm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = llm
    }

    companion object {
        private var recyclerView: RecyclerView? = null
        private var adapterClass: AdapterClass? = null
        fun Update(activity: Activity, response: String) {
            if (!response.isEmpty()) {
                val gson = Gson()
                val modelRespList = gson.fromJson<List<ModelList>>(
                    response,
                    object : TypeToken<List<ModelList?>?>() {}.type
                )
                Log.d("sonubhai", modelRespList[0].address!!.geo!!.lat!!)
                adapterClass = AdapterClass(activity.applicationContext, modelRespList)
                recyclerView!!.adapter = adapterClass
                adapterClass!!.notifyDataSetChanged()


//            locAdapter = new ListAdapter(activity, collaboratorResponse);
//            rv.setAdapter(locAdapter);
//            locAdapter.notifyDataSetChanged();
            } else {
            }
        }
    }
}