package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class PracticalTest01var07MainActivity : AppCompatActivity() {


    private  lateinit var mtext_left_t: EditText
    private  lateinit var mtext_right_t: EditText
    private  lateinit var mtext_left_b : EditText
    private  lateinit var mtext_right_b : EditText
    private  lateinit var mset_but : Button
    private  lateinit var mrandom_but : Button

    private var numar1: Double = 0.0

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
            if(mtext_left_t.text.isEmpty() or !isNumericToX(mtext_left_t.text.toString())){

                mtext_left_t.setText(Random.nextDouble(10.0).toString())

            }
            if(mtext_left_b.text.isEmpty() or !isNumericToX(mtext_left_b.text.toString())){

                mtext_left_b.setText(Random.nextDouble(10.0).toString())

            }

            if(mtext_right_t.text.isEmpty() or !isNumericToX(mtext_right_t.text.toString())){

                mtext_right_t.setText(Random.nextDouble(10.0).toString())

            }

            if(mtext_right_b.text.isEmpty() or !isNumericToX(mtext_right_b.text.toString())){

                mtext_right_b.setText(Random.nextDouble(10.0).toString())

            }

        }

        mset_but.setOnClickListener { val intent = android.content.Intent(this,
            PracticalTest01var07SecondaryActivity::class.java)
            intent.putExtra("nr1", mtext_right_b.text.toString().toDouble())
            intent.putExtra("nr2", mtext_right_t.text.toString().toDouble())
            intent.putExtra("nr3", mtext_left_b.text.toString().toDouble())
            intent.putExtra("nr4", mtext_left_t.text.toString().toDouble())
            startActivityForResult(intent, 1) }


    }
    fun isNumericToX(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    android.content.Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                val mesajIntors = data?.getDoubleExtra("suma", 0.0)
                val stringintors = mesajIntors.toString()
                numar1 = stringintors.toDouble()
                android.widget.Toast.makeText(
                    this, " $stringintors",
                    android.widget.Toast.LENGTH_SHORT
                ).show()


            }
            else if(resultCode == RESULT_CANCELED){
                val mesajIntors = data?.getDoubleExtra("prod", 0.0)
                val stringintors = mesajIntors.toString()
                numar1 = stringintors.toDouble()

                android.widget.Toast.makeText(
                    this, " $stringintors",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
            }
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("numarul",numar1)
        Log.d("measj", numar1.toString())
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        numar1 = savedInstanceState.getDouble("numarul")
        Log.d("measj", numar1.toString())
    }
    }
