package com.tachisatok.notelesson.view.select

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.view.ui.OnClickCallback
import kotlinx.android.synthetic.main.range_select_item_horizontal_recycler_view.view.*
import kotlinx.android.synthetic.main.range_select_item_section.view.*
import kotlinx.android.synthetic.main.range_select_item_title.view.*

class RangeSelectRecyclerAdapter(
        private val context: Context,
        private val gClefList: List<RangeSelectHorizontalItemData>,
        private val fClefList: List<RangeSelectHorizontalItemData>,
        private val gClefAndFClefList: List<RangeSelectHorizontalItemData>,
        private val clickCallback: OnClickCallback
) : RecyclerView.Adapter<RangeSelectRecyclerAdapter.ItemViewHolder>() {

    private val itemAlgorithm: ItemAlgorithm

    init {
        itemAlgorithm = ItemAlgorithm(context, gClefList, fClefList, gClefAndFClefList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (ViewHolderType.of(viewType)) {
            ViewHolderType.TITLE -> TitleViewHolder.getHolder(parent)
            ViewHolderType.SECTION -> SectionViewHolder.getHolder(parent)
            ViewHolderType.RANGE_ITEMS -> HorizontalRecyclerViewHolder.getHolder(parent, context, clickCallback)
        }
    }

    override fun getItemCount(): Int {
        return itemAlgorithm.getItemCount()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemAlgorithm.get(position), position)
    }

    override fun getItemViewType(position: Int): Int {
        return ItemDataType.of(position).viewHolderType.viewType
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
     * タイトル
     */
    private class TitleViewHolder private constructor(
            view: View
    ) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(parent: ViewGroup): TitleViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_item_title, parent, false)
                return TitleViewHolder(view)
            }
        }

        override fun onBind(itemData: ItemData, position: Int) {
            this.itemView.range_select_item_title_text_view.text = itemData.text
        }
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
            private val clickCallback: OnClickCallback
    ) : ItemViewHolder(view) {

        companion object {
            @JvmStatic
            fun getHolder(parent: ViewGroup, context: Context, clickCallback: OnClickCallback): HorizontalRecyclerViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.range_select_item_horizontal_recycler_view, parent, false)
                return HorizontalRecyclerViewHolder(view, context, clickCallback)
            }
        }

        override fun onBind(itemData: ItemData, position: Int) {
            val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val adapter = RangeSelectHorizontalRecyclerAdapter(context, itemData.clefList!!, clickCallback)
            this.itemView.range_select_item_horizontal_recycler_view_root.layoutManager = layoutManager
            this.itemView.range_select_item_horizontal_recycler_view_root.adapter = adapter
        }
    }

    private class ItemAlgorithm(
            context: Context,
            private val gClefList: List<RangeSelectHorizontalItemData>,
            private val fClefList: List<RangeSelectHorizontalItemData>,
            private val gClefAndFClefList: List<RangeSelectHorizontalItemData>
    ) {
        private val titleText = Characters.PLEASE_SELECT_RANGE.getString(context)
        private val sectionGClefText = Characters.G_CLEF.getString(context)
        private val sectionFClefText = Characters.F_CLEF.getString(context)
        private val sectionGClefAndFClefText = "${sectionGClefText}と$sectionFClefText"

        /**
         * リストに表示する[ItemData]を返却する
         *
         * @param position リストポジション
         * @return リストに表示する[ItemData]
         */
        fun get(position: Int): ItemData {
            return when (ItemDataType.of(position)) {
                ItemDataType.TITLE -> ItemData(text = titleText)
                ItemDataType.SECTION_G_CLEF -> ItemData(text = sectionGClefText)
                ItemDataType.RANGE_ITEMS_G_CLEF -> ItemData(clefList = gClefList)
                ItemDataType.SECTION_F_CLEF -> ItemData(text = sectionFClefText)
                ItemDataType.RANGE_ITEMS_F_CLEF -> ItemData(clefList = fClefList)
                ItemDataType.SECTION_G_CLEF_AND_F_CLEF -> ItemData(text = sectionGClefAndFClefText)
                ItemDataType.RANGE_ITEMS_G_CLEF_AND_F_CLEF -> ItemData(clefList = gClefAndFClefList)
            }
        }

        fun getItemCount(): Int {
            return ItemDataType.values().size
        }
    }

    /**
     * リストに表示するアイテムを保持するデータクラス
     *
     * [text]もしくは[clefList]に値が格納されている
     */
    data class ItemData(
            val text: String? = null,
            val clefList: List<RangeSelectHorizontalItemData>? = null
    )

    /**
     * 各リストの定義
     *
     * @property position リストポジション
     */
    private enum class ItemDataType(val position: Int, val viewHolderType: ViewHolderType) {
        TITLE(0, ViewHolderType.TITLE),
        SECTION_G_CLEF(1, ViewHolderType.SECTION),
        RANGE_ITEMS_G_CLEF(2, ViewHolderType.RANGE_ITEMS),
        SECTION_F_CLEF(3, ViewHolderType.SECTION),
        RANGE_ITEMS_F_CLEF(4, ViewHolderType.RANGE_ITEMS),
        SECTION_G_CLEF_AND_F_CLEF(5, ViewHolderType.SECTION),
        RANGE_ITEMS_G_CLEF_AND_F_CLEF(6, ViewHolderType.RANGE_ITEMS);

        companion object {
            @JvmStatic
            fun of(position: Int): ItemDataType {
                return values().first { it.position == position }
            }
        }
    }

    /**
     * ViewHolderのタイプを表す
     */
    private enum class ViewHolderType(val viewType: Int) {
        TITLE(0),
        SECTION(1),
        RANGE_ITEMS(2);

        companion object {
            @JvmStatic
            fun of(viewType: Int): ViewHolderType {
                return values().first { it.viewType == viewType }
            }
        }
    }
}