package edu.temple.imagegallery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_activity)

        val imageArray = arrayOf(
            ImageObject("badlands", R.drawable.badlands),
            ImageObject("plateau", R.drawable.plateau),
            ImageObject("bayou", R.drawable.bayou),
            ImageObject("savannah", R.drawable.savannah),
            ImageObject("scrubland", R.drawable.scrubland),
            ImageObject("taiga", R.drawable.taiga),
            ImageObject("trop", R.drawable.trop),
            ImageObject("tundra", R.drawable.tundra),
            ImageObject("usea", R.drawable.usea),
            ImageObject("volc", R.drawable.volc)
        )

        recyclerView.adapter = ImageAdapter(this, imageArray)
    }


    var textView: TextView = findViewById(R.id.textView)

    var imageView: ImageView = findViewById(R.id.imageView2)

    var recyclerView: RecyclerView = findViewById(R.id.recyclerView)








}

class ImageAdapter(var _context: Context, private val dataSet: Array<ImageObject>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        var imageDescription: String = ""

        init {
            // Define click listener for the ViewHolder's View.
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.image_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.imageDescription = dataSet[position].description
        viewHolder.imageView.setImageResource(dataSet[position].resourceID)

    }

    override fun getItemCount() = dataSet.size

}


