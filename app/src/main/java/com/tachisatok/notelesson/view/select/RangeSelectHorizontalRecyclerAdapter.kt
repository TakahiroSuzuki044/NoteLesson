package com.tachisatok.notelesson.view.select

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Clef
import com.tachisatok.notelesson.view.ui.OnClickCallback
import kotlinx.android.synthetic.main.range_select_horizontal_item.view.*

class RangeSelectHorizontalRecyclerAdapter(
        private val context: Context,
        private val items: List<RangeSelectHorizontalItemData>,
        private val clickCallback: OnClickCallback
) : RecyclerView.Adapter<RangeSelectHorizontalRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (ItemType.of(viewType)) {
            ItemType.SINGLE -> {
                SingleViewHolder.getHolder(context, parent, clickCallback)
            }
            ItemType.DOUBLE -> {
                DoubleViewHolder.getHolder(context, parent, clickCallback)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(items[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].fClefScaleRange != null && items[position].gClefScaleRange != null) {
            ItemType.DOUBLE.viewType
        } else {
            ItemType.SINGLE.viewType
        }
    }

    private class SingleViewHolder private constructor(
            view: View,
            private val context: Context,
            private val clickCallback: OnClickCallback) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(context: Context, parent: ViewGroup, clickCallback: OnClickCallback): SingleViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_horizontal_item, parent, false)
                return SingleViewHolder(view, context, clickCallback)
            }
        }

        override fun onBind(item: RangeSelectHorizontalItemData, position: Int) {
            val clef = if (item.gClefScaleRange != null) Clef.G_CLEF else Clef.F_CLEF
            when (clef) {
                Clef.G_CLEF -> {
                    this.itemView.range_select_horizontal_item_f_clef_linear_layout.visibility = View.GONE
                    this.itemView.range_select_horizontal_item_g_clef_linear_layout.visibility = View.VISIBLE
                    this.itemView.range_select_horizontal_item_g_clef_text_view.text = item.gClefScaleRange?.characters?.getString(context)
                    this.itemView.range_select_horizontal_item_root_layout.setOnClickListener {
                        clickCallback.onClick(it, item, position)
                    }
                }
                Clef.F_CLEF -> {
                    this.itemView.range_select_horizontal_item_g_clef_linear_layout.visibility = View.GONE
                    this.itemView.range_select_horizontal_item_f_clef_linear_layout.visibility = View.VISIBLE
                    this.itemView.range_select_horizontal_item_f_clef_text_view.text = item.fClefScaleRange?.characters?.getString(context)
                    this.itemView.range_select_horizontal_item_root_layout.setOnClickListener {
                        clickCallback.onClick(it, item, position)
                    }
                }
            }
        }
    }

    private class DoubleViewHolder private constructor(
            view: View,
            private val context: Context,
            private val clickCallback: OnClickCallback) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(context: Context, parent: ViewGroup, clickCallback: OnClickCallback): DoubleViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_horizontal_item, parent, false)
                return DoubleViewHolder(view, context, clickCallback)
            }
        }

        override fun onBind(item: RangeSelectHorizontalItemData, position: Int) {
            this.itemView.range_select_horizontal_item_g_clef_text_view.text = item.gClefScaleRange?.characters?.getString(context)
            this.itemView.range_select_horizontal_item_f_clef_text_view.text = item.fClefScaleRange?.characters?.getString(context)
            this.itemView.range_select_horizontal_item_root_layout.setOnClickListener {
                clickCallback.onClick(it, item, position)
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
        abstract fun onBind(item: RangeSelectHorizontalItemData, position: Int)
    }

    private enum class ItemType(val viewType: Int) {
        SINGLE(0),
        DOUBLE(1);

        companion object {
            @JvmStatic
            fun of(viewType: Int): ItemType {
                return values().first { it.viewType == viewType }
            }
        }
    }
}