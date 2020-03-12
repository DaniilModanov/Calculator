package modanov.test.calculator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var leftBracketCounter = 0
        var rightBracketCounter = 0

        addTextToField(btn0, "0")
        addTextToField(btn1, "1")
        addTextToField(btn2, "2")
        addTextToField(btn3, "3")
        addTextToField(btn4, "4")
        addTextToField(btn5, "5")
        addTextToField(btn6, "6")
        addTextToField(btn7, "7")
        addTextToField(btn8, "8")
        addTextToField(btn9, "9")
        addTextToField(btnMinus, "-")
        addTextToField(btnPlus, "+")
        addTextToField(btnDivide, "/")
        addTextToField(btnMultiply, "*")
        addTextToField(btnPoint, ".")
        addTextToField(btnRightBracket, ")")
        addTextToField(btnLeftBracket, "(")


        btnClear.setOnClickListener {
            inputTV.text = ""
        }
        btnBackspace.setOnClickListener {
            val str = inputTV.text.toString()
            if (inputTV.text.isNotEmpty()) {
                if (str.substring(str.length - 1, str.length) == " ") {
                    inputTV.text = str.substring(0, str.length - 3)
                } else {
                    inputTV.text = str.substring(0, str.length - 1)
                }
            } else {
                inputTV.text = ""
            }
        }
        btnMultiply.setOnClickListener {
            if (!inputTV.text.toString().endsWith("+") and !inputTV.text.toString().endsWith("-") and
                !inputTV.text.toString().endsWith("/") and !inputTV.text.toString().endsWith("*")
            ) {
                inputTV.text = inputTV.text.toString() + "*"
            }
        }
        btnPlus.setOnClickListener {
            if (!inputTV.text.toString().endsWith("+") and !inputTV.text.toString().endsWith("-") and
                !inputTV.text.toString().endsWith("/") and !inputTV.text.toString().endsWith("*")
            ) {
                inputTV.text = inputTV.text.toString() + "+"
            }
        }
        btnMinus.setOnClickListener {
            if (!inputTV.text.toString().endsWith("+") and !inputTV.text.toString().endsWith("-") and
                !inputTV.text.toString().endsWith("/") and !inputTV.text.toString().endsWith("*")
            ) {
                inputTV.text = inputTV.text.toString() + "-"
            }
        }
        btnDivide.setOnClickListener {
            if (!inputTV.text.toString().endsWith("+") and !inputTV.text.toString().endsWith("-") and
                !inputTV.text.toString().endsWith("/") and !inputTV.text.toString().endsWith("*")
            ) {
                inputTV.text = inputTV.text.toString() + "/"
            }
        }

        btnEqual.setOnClickListener {
            if (leftBracketCounter==rightBracketCounter) {
                val e = ExpressionBuilder(inputTV.text.toString()).build()
                inputTV.text = "${inputTV.text}="
                resTV.text = e.evaluate().toString()
            } else {
                resTV.text = "Ошибка"
            }
        }
        btnLeftBracket.setOnClickListener {
            inputTV.text = inputTV.text.toString() + "("
            leftBracketCounter++
        }
        btnRightBracket.setOnClickListener {
            inputTV.text = inputTV.text.toString() + ")"
            rightBracketCounter++
        }
    }

    @SuppressLint("SetTextI18n")
    fun addTextToField(btn: Button, str: String) {
        btn.setOnClickListener {
            if (inputTV.text.toString().endsWith("="))
            {
                inputTV.text = str
            }
            else {
                inputTV.text = inputTV.text.toString() + str
            }
        }
    }
}

