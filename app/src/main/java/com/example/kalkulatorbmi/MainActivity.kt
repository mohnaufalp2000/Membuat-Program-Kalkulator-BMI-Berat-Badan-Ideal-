package com.example.kalkulatorbmi

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val RESULT = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState!=null){
            val saveInstance = savedInstanceState.getString(RESULT)
            result.text = saveInstance
        }

        button.setOnClickListener {
            var weight = berat_badan.text.toString()
            var height = tinggi_badan.text.toString()
            lateinit var text: String

            val checkedRadioButtonId = rgSex.checkedRadioButtonId
            if (checkedRadioButtonId!=-1){
                when(checkedRadioButtonId){
                    R.id.man -> {
                        var resultMan =
                            weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                        resultMan = Math.floor(resultMan * 100) / 100
                        if (resultMan < 17) {
                            text = "${resultMan}\nKurus"
                        } else if (resultMan >= 17 && resultMan <= 23) {
                            text = "${resultMan}\nNormal (Ideal)"
                        } else if (resultMan >= 24 && resultMan <= 27) {
                            text = "${resultMan}\nGemuk"
                        } else if (resultMan > 27) {
                            text = "${resultMan}\nObesitas"
                        }
                        result.text = text
                    }

                    R.id.woman -> {
                        var resultWoman =
                            weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                        resultWoman = Math.floor(resultWoman * 100) / 100
                        if (resultWoman < 18) {
                            text = "${resultWoman}\nKurus"
                        } else if (resultWoman >= 18 && resultWoman <= 25) {
                            text = "${resultWoman}\nNormal (Ideal)"
                        } else if (resultWoman >= 25 && resultWoman <= 27) {
                            text = "${resultWoman}\nGemuk"
                        } else if (resultWoman > 27) {
                            text = "${resultWoman}\nObesitas"
                        }
                        result.text = text
                    }
                }
            }
        }

        clear.setOnClickListener {
            rgSex.clearCheck()
            berat_badan.setText("")
            tinggi_badan.setText("")
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(RESULT, result.text.toString())
    }



}