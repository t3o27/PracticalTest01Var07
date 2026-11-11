package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01var07MainActivity : AppCompatActivity() {


    private  lateinit var mtext_left_t: EditText
    private  lateinit var mtext_right_t: EditText
    private  lateinit var mtext_left_b : EditText
    private  lateinit var mtext_right_b : EditText
    private  lateinit var mset_but : Button
    private  lateinit var mrandom_but : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_practical_test01_var07_main)


        mtext_right_b =  findViewById(R.id.right_bottom_edit)
        mtext_right_t = findViewById(R.id.right_top_edit)
        mtext_left_b = findViewById(R.id.left_bottom_edit)
        mtext_left_t = findViewById(R.id.left_top_edit)

        mset_but = findViewById(R.id.set_b)
        mrandom_but = findViewById(R.id.random_but)

        mrandom_but.setOnClickListener {
            if(mtext_left_t.text.isNotEmpty()){
                mtext_left_t

            }
        }


    }
}