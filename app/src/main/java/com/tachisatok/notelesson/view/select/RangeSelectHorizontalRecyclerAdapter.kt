package com.tachisatok.notelesson.view.select

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.view.ui.OnItemClickCallback
import kotlinx.android.synthetic.main.range_select_horizontal_item.view.*

class RangeSelectHorizontalRecyclerAdapter(
        private val context: Context,
        private val items: List<ScaleRange>,
        private val itemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<RangeSelectHorizontalRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return SingleViewHolder.getHolder(context, parent, itemClickCallback)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(items[position], position)
    }

    private class SingleViewHolder private constructor(
            view: View,
            private val context: Context,
            private val itemClickCallback: OnItemClickCallback) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(context: Context, parent: ViewGroup, itemClickCallback: OnItemClickCallback): SingleViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_horizontal_item, parent, false)
                return SingleViewHolder(view, context, itemClickCallback)
            }
        }

        override fun onBind(item: ScaleRange, position: Int) {
            this.itemView.range_select_horizontal_item_image_view.setImageResource(item.imageRes)
            this.itemView.range_select_horizontal_item_range_text_view.text = item.characters.getString(context)
            this.itemView.range_select_horizontal_item_root_layout.setOnClickListener {
                itemClickCallback.onItemClick(it, item, position)
            }
        }
    }

    abstract class ItemViewHolder(
            view: View
    ) : RecyclerView.ViewHolder(view) {

        /**
         * Viewをバインドする
         *
         * @param item 表示するアイテム
         */
        abstract fun onBind(item: ScaleRange, position: Int)
    }
}