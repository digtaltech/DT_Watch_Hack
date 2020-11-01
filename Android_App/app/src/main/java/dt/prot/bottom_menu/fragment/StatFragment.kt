package dt.prot.bottom_menu.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dt.prot.bottom_menu.R
import kotlinx.android.synthetic.main.fragment_stat.*
import java.util.concurrent.ThreadLocalRandom

class StatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stat, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updateTimer()
    }

    override fun onPause() {
        super.onPause()
        stopTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
    }

    fun statPulse(){
        stat_pulse_last.text = (ThreadLocalRandom.current().nextInt(60,70)).toString()
    }

    private var timer: Timer?=null

    private fun startTimer(){
        timer = Timer(3000)
        timer?.start()
    }

    private fun stopTimer(){
        timer?.cancel()
    }

    private fun updateTimer(){
        if(timer!=null) {
            val miliis = 3000
            timer?.cancel()
            timer = Timer(miliis.toLong())
            timer?.start()
        }else{
            startTimer()
        }
    }

    inner class Timer(miliis:Long) : CountDownTimer(miliis,1000){
        private var millisUntilFinished:Long = 0
        override fun onFinish() {
            statPulse()
            updateTimer()
        }

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
        }
    }
}
