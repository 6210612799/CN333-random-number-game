package punyawat.randomnumberapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var resetbut: Button
    lateinit var okbut: Button
    lateinit var count: TextView


    var random: Int = nextInt( 1,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        resetbut = findViewById(R.id.resetbut)
        okbut = findViewById(R.id.okbut)
        count = findViewById(R.id.count)
        textView.text = "Hint For Weak"

        var x:Int = 0
        okbut.setOnClickListener {
            var number:Int = 0

            x++
            try {
                number = editText.text.toString().toInt()

            }
            catch (e: NumberFormatException){

            }
            if ((number > 1000) or (number <=  0)){
                textView.text = "pls put number between 1-1000"
                editText.text.clear()
            }
                else if (number < random) {

                textView.text = "HINTS : Number too low"

                count.text=("count : $x")
                editText.text.clear()
            } else if (number > random) {
                textView.text = "HINTS : Number too High"
                count.text=("count : $x")
                editText.text.clear()
            } else {
                textView.text = "YEAHHH U RIGHT!"
                count.text=("count : $x")
                editText.text.clear()

            }
        }

        resetbut.setOnClickListener {
            x = 0
            count.text=("count : $x")

            reset()

        }
    }
    fun reset() {
        random = nextInt(1,1000)
        textView.text = "GUESS THE NUMBER 1-1000"

        editText.text.clear()
    }
}