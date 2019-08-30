package com.tachisatok.notelesson.view.select

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.view.ui.OnItemClickCallback
import kotlinx.android.synthetic.main.range_select_item_horizontal_recycler_view.view.*
import kotlinx.android.synthetic.main.range_select_item_section.view.*

class RangeSelectRecyclerAdapter(
        private val context: Context,
        recentGameList: List<ScaleRange>,
        gClefList: List<ScaleRange>,
        fClefList: List<ScaleRange>,
        private val itemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<RangeSelectRecyclerAdapter.ItemViewHolder>() {

    private val itemHolder: ItemHolder

    private val itemAlgorithm: ItemAlgorithm

    init {
        itemHolder = ItemHolder(context, recentGameList, gClefList, fClefList)
        itemAlgorithm = ItemAlgorithm(recentGameList.isNotEmpty())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (ViewHolderType.of(viewType)) {
            ViewHolderType.SECTION -> SectionViewHolder.getHolder(parent)
            ViewHolderType.RANGE_ITEMS -> HorizontalRecyclerViewHolder.getHolder(parent, context, itemClickCallback)
        }
    }

    override fun getItemCount(): Int {
        return itemAlgorithm.getItemCount()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemHolder.get(itemAlgorithm.of(position)), position)
    }

    override fun getItemViewType(position: Int): Int {
        return itemAlgorithm.of(position).viewHolderType.viewType
    }

    abstract class ItemViewHolder(
            view: View
    ) : RecyclerView.ViewHolder(view) {

        /**
         * Viewをバインドする
         *
         * @param itemData 表示するアイテム
         * @param position リストポジション
         */
        abstract fun onBind(itemData: ItemData, position: Int)
    }

    /**
     * セクション
     */
    private class SectionViewHolder private constructor(
            view: View
    ) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(parent: ViewGroup): SectionViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_item_section, parent, false)
                return SectionViewHolder(view)
            }
        }

        override fun onBind(itemData: ItemData, position: Int) {
            this.itemView.range_select_item_section_text_view.text = itemData.text
        }
    }

    /**
     * 横スクロールする[RecyclerView]のViewHolder
     */
    private class HorizontalRecyclerViewHolder private constructor(
            view: View,
            private val context: Context,
            private val itemClickCallback: OnItemClickCallback
    ) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(parent: ViewGroup, context: Context, itemClickCallback: OnItemClickCallback): HorizontalRecyclerViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_item_horizontal_recycler_view, parent, false)
                return HorizontalRecyclerViewHolder(view, context, itemClickCallback)
            }
        }

        override fun onBind(itemData: ItemData, position: Int) {
            val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val adapter = RangeSelectHorizontalRecyclerAdapter(context, itemData.clefList!!, itemClickCallback)
            this.itemView.range_select_item_horizontal_recycler_view_root.layoutManager = layoutManager
            this.itemView.range_select_item_horizontal_recycler_view_root.adapter = adapter
        }
    }

    private class ItemHolder(
        context: Context,
        private val recentGameList: List<ScaleRange>,
        private val gClefList: List<ScaleRange>,
        private val fClefList: List<ScaleRange>
    ) {
        private val sectionRecentText = Characters.RECENT_GAME_RANGE.getString(context)
        private val sectionGClefText = Characters.G_CLEF.getString(context)
        private val sectionFClefText = Characters.F_CLEF.getString(context)

        /**
         * リストに表示する[ItemData]を返却する
         *
         * @param position リストポジション
         * @return リストに表示する[ItemData]
         */
        fun get(item: Item): ItemData {
            return when (item) {
                Item.SECTION_RECENT -> ItemData(text = sectionRecentText)
                Item.RANGE_ITEMS_RECENT -> ItemData(clefList = recentGameList)
                Item.SECTION_G_CLEF -> ItemData(text = sectionGClefText)
                Item.RANGE_ITEMS_G_CLEF -> ItemData(clefList = gClefList)
                Item.SECTION_F_CLEF -> ItemData(text = sectionFClefText)
                Item.RANGE_ITEMS_F_CLEF -> ItemData(clefList = fClefList)
            }
        }
    }

    /**
     * リストに表示するアイテムを保持するデータクラス
     *
     * [text]もしくは[clefList]に値が格納されている
     */
    data class ItemData(
            val text: String? = null,
            val clefList: List<ScaleRange>? = null
    )

    private class ItemAlgorithm(
        private val existRecentList: Boolean
    ) {
        fun of(position: Int): Item {
            val sortOrder = if (existRecentList) position else position + RECENT_AREA_COMPENSATE
            return Item.values().first { it.sortOrder == sortOrder }
        }

        fun getItemCount(): Int {
            return if (existRecentList) Item.values().size else Item.values().size - RECENT_AREA_COMPENSATE
        }

        companion object {
            /**
             * 最近練習した領域がないときの埋め合わせ分
             */
            private const val RECENT_AREA_COMPENSATE = 2

        }
    }

    private enum class Item(val sortOrder: Int, val viewHolderType: ViewHolderType) {
        SECTION_RECENT(0, ViewHolderType.SECTION),
        RANGE_ITEMS_RECENT(1, ViewHolderType.RANGE_ITEMS),
        SECTION_G_CLEF(2, ViewHolderType.SECTION),
        RANGE_ITEMS_G_CLEF(3, ViewHolderType.RANGE_ITEMS),
        SECTION_F_CLEF(4, ViewHolderType.SECTION),
        RANGE_ITEMS_F_CLEF(5, ViewHolderType.RANGE_ITEMS)
    }

    /**
     * ViewHolderのタイプを表す
     */
    private enum class ViewHolderType(val viewType: Int) {
        SECTION(0),
        RANGE_ITEMS(1);

        companion object {
            @JvmStatic
            fun of(viewType: Int): ViewHolderType {
                return values().first { it.viewType == viewType }
            }
        }
    }
}