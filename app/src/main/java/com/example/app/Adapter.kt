package com.example.app

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.size

class Adapter(val adapter:List<Iocal>)
    :RecyclerView.Adapter<Adapter.ViewHolder>() {
        class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            var image:ImageView
            var place:TextView
            var temp:TextView
            var humi:TextView
            var rain:TextView

            init{
                image=view.findViewById(R.id.weatherImage)
                place=view.findViewById(R.id.location)
                temp=view.findViewById(R.id.temperature)
                humi=view.findViewById(R.id.tmqeh)
                rain=view.findViewById(R.id.tmqeh)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.weather22,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.place.text=adapter[position].place
        holder.temp.text=adapter[position].x
        holder.humi.text=adapter[position].y
    }

    override fun getItemCount(): Int {
    return adapter.size
    }
}
