package com.example.sliderdots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSlideAdapter = IntroSlideAdapter(
        listOf(
            IntroSlide(
                "hello",
                "hello world",
                R.drawable.first
            ),
            IntroSlide(
                "jksdhjkds",
                "vshdgfhjfgdsd",
                R.drawable.second
            ),
            IntroSlide(
                "jhhdhjjdsfdsf",
                "dfbhjdsfjdsfds",
                R.drawable.third
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupindicators()
        setcurrentindicators(0)
        introSliderViewPager.registerOnPageChangeCallback(
            object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setcurrentindicators(position)
                }
            }
        )
    }


    private fun setupindicators() {
        val indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)

layoutParams.setMargins(8,0,8,0)
    for (i in indicators.indices){
        indicators[i]= ImageView(applicationContext)
        indicators[i].apply {
            this?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive)
            )
            this?.layoutParams=layoutParams
        }
        indicatorsContainer.addView(indicators[i])

    }
    }

    private fun setcurrentindicators(index: Int) {

val childCount=indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView=indicatorsContainer[i]as ImageView
            if (i ==index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_active
                    )
                )

            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
