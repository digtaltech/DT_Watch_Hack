package dt.prot.bottom_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes


public class MyAdapter(
    context: Context,
    @LayoutRes res: Int,
    arrText1: ArrayList<String>,
    //arrText2: ArrayList<String>
) : BaseAdapter() {

    private val _res: Int = res
    private val _arrText1:ArrayList<String> = arrText1
    //private val _arrText2:ArrayList<String> = arrText2
    private var lInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return _arrText1.size
    }

    override fun getItem(p0: Int): Any {
        return _arrText1[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = lInflater.inflate(_res, p2, false)
            view.findViewById<TextView>(android.R.id.text1).text = _arrText1[p0]
           // view.findViewById<TextView>(android.R.id.text2).text = _arrText2[p0]
        }
        return view
    }


}