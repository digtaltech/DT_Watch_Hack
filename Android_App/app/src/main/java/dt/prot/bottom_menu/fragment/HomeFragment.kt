package dt.prot.bottom_menu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dt.prot.bottom_menu.MyAdapter
import dt.prot.bottom_menu.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var boolShit: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        boolShit = !boolShit
        onClickHome()
    }

    fun onClickHome(){

        if (boolShit){
            home_text_1.text = "Завершение смены"
            home_text_2.text = "Для завершения смены, необходимо соблюдение следующих параметров"
            list_home.adapter = MyAdapter(context!!,R.layout.item_home,arrayListOf("Местоположение на работе","Синхронизация с браслетом (Необязательно)"))
            button_home.text = "Завершить смену"
        }else{
            home_text_1.text = "Выход на смену"
            home_text_2.text = "Для выхода на смену, необходимо соблюдение следующих параметров"
            list_home.adapter = MyAdapter(context!!,R.layout.item_home,arrayListOf("Выбрать место рабочего объекта в профиле","Местоположение на работе","Синхронизация с браслетом (Необязательно)"))
            button_home.text = "Выйти на смену"
        }
        boolShit = !boolShit
    }
}
