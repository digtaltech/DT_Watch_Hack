package dt.prot.bottom_menu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dt.prot.bottom_menu.fragment.HomeAlertFragment
import dt.prot.bottom_menu.fragment.HomeFragment
import dt.prot.bottom_menu.fragment.ProfileFragment
import dt.prot.bottom_menu.fragment.StatFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var homeFragment: HomeFragment? = null
    private var profileFragment: ProfileFragment? = null
    private var statFragment: StatFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivHome.setOnClickListener(this)
        ivStat.setOnClickListener(this)
        ivProfile.setOnClickListener(this)

        onClick(ivHome)
    }

    override fun onClick(v: View?) {
        when(v) {
            ivHome -> {
                onClickSrc(booleanArrayOf(true, false, false))
                if (homeFragment == null) homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment!!).commit()
            }
            ivStat -> {
                onClickSrc(booleanArrayOf(false,true,false))
                if (statFragment == null) statFragment = StatFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, statFragment!!).commit()
            }
            ivProfile -> {
                onClickSrc(booleanArrayOf(false,false,true))
                if (profileFragment == null) profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment!!).commit()
            }
            else -> {
                Log.d("bottom navigation", "else part of bottom navigation")
            }
        }
    }

    fun onClickBtnHome(view: View){
        homeFragment?.onClickHome()
        if(homeFragment?.boolShit == false) supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeAlertFragment()).commit()
    }

    fun onClickHomeAlert(view: View){
        onClick(ivHome)
    }

    private fun onClickSrc(boolArr: BooleanArray){
        if (boolArr[0]) ivHome.setImageResource(R.drawable.ic_checkinactive) else ivHome.setImageResource(R.drawable.ic_checkin)
        if (boolArr[1]) ivStat.setImageResource(R.drawable.ic_statsactive) else ivStat.setImageResource(R.drawable.ic_stats)
        if (boolArr[2]) ivProfile.setImageResource(R.drawable.ic_profile2) else ivProfile.setImageResource(R.drawable.ic_profile)
    }
}