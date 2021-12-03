package com.example.persistentbottomsheetdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<NestedScrollView>
    var stateText:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomSheet = findViewById<NestedScrollView>(R.id.bottom_sheet)
        stateText = findViewById<TextView>(R.id.stateText)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Toast.makeText(
                            this@MainActivity,
                            "STATE_COLLAPSED",
                            Toast.LENGTH_SHORT
                        ).show()
                        stateText?.text = "STATE_COLLAPSED"
                    }

                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Toast.makeText(
                            this@MainActivity,
                            "STATE_EXPANDED",
                            Toast.LENGTH_SHORT
                        ).show()
                        stateText?.text = "STATE_EXPANDED"

                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Toast.makeText(
                            this@MainActivity,
                            "STATE_DRAGGING",
                            Toast.LENGTH_SHORT
                        ).show()
                        stateText?.text = "STATE_DRAGGING"

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Toast.makeText(
                            this@MainActivity,
                            "STATE_SETTLING",
                            Toast.LENGTH_SHORT
                        ).show()
                        stateText?.text = "STATE_SETTLING"

                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Toast.makeText(
                            this@MainActivity,
                            "STATE_HIDDEN",
                            Toast.LENGTH_SHORT
                        ).show()
                        stateText?.text = "STATE_HIDDEN"

                    }
                    else -> {Toast.makeText(this@MainActivity, "OTHER_STATE", Toast.LENGTH_SHORT)
                        .show()
                        }
                }
            }
        })
    }
}