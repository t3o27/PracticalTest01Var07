package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01var07SecondaryActivity : AppCompatActivity() {

    private  lateinit var mtext_left_t: EditText
    private  lateinit var mtext_right_t: EditText
    private  lateinit var mtext_left_b : EditText
    private  lateinit var mtext_right_b : EditText
    private lateinit var msum : Button
    private lateinit var mproduct : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01var07_secondary)

        mtext_right_b =  findViewById(R.id.right_bottom_edit1)
        mtext_right_t = findViewById(R.id.right_top_edit1)
        mtext_left_b = findViewById(R.id.left_bottom_edit1)
        mtext_left_t = findViewById(R.id.left_top_edit1)
        msum = findViewById(R.id.but_sum)
        mproduct = findViewById(R.id.but_product)




        var nr1 = intent.getDoubleExtra("nr1",0.0)
        var nr2 = intent.getDoubleExtra("nr2",0.0)
        var nr3 = intent.getDoubleExtra("nr3",0.0)
        var nr4 = intent.getDoubleExtra("nr4",0.0)
        mtext_right_b.setText(nr1.toString())
        mtext_right_t.setText(nr1.toString())
        mtext_left_b.setText(nr1.toString())
        mtext_left_t.setText(nr1.toString())

        val intentIntoarcere = Intent()
        msum.setOnClickListener {
            var suma = nr1 + nr2 + nr3 + nr4

            intentIntoarcere.putExtra("suma", suma)
            setResult(RESULT_OK, intentIntoarcere)
            finish()
        }

        mproduct.setOnClickListener {
            var produc = nr1*nr2*nr3*nr4

            intentIntoarcere.putExtra("prod", produc)
            setResult(RESULT_CANCELED, intentIntoarcere)
            finish()
        }




    }
}