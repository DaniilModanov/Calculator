package modanov.test.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var usedType = ""
        val inputTV = findViewById<TextView>(R.id.inputTV)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        addNum(btn1, 1)
        addNum(btn2, 2)
        addNum(btn3, 3)
        addNum(btn4, 4)
        addNum(btn5, 5)
        addNum(btn6, 6)
        addNum(btn7, 7)
        addNum(btn8, 8)
        addNum(btn9, 9)


        btnClear.setOnClickListener {
            inputTV.text = ""
        }
        btnMultiply.setOnClickListener() {
            if (usedType == "") {
                inputTV.text = inputTV.text.toString() + " * "
                usedType = "*"
            }
        }
        btnPlus.setOnClickListener() {
            if (usedType == "") {
                inputTV.text = inputTV.text.toString() + " + "
                usedType = "+"
            }
        }
        btnMinus.setOnClickListener() {
            if (usedType == "") {
                inputTV.text = inputTV.text.toString() + " - "
                usedType = "-"
            }
        }
        btnDivide.setOnClickListener() {
            if (usedType == "") {
                inputTV.text = inputTV.text.toString() + " / "
                usedType = "/"
            }
        }
        btnEqual.setOnClickListener() {
            if (usedType != "") {
                val ss = inputTV.text.toString().split(" $usedType ")
                val num1 = ss[0].toInt()
                val num2 = ss[1].toInt()
                when (usedType) {
                    "+" -> inputTV.text = inputTV.text.toString() + " = " + (num1 + num2).toString()
                    "-" -> inputTV.text = inputTV.text.toString() + " = " + (num1 - num2).toString()
                    "*" -> inputTV.text = inputTV.text.toString() + " = " + (num1 * num2).toString()
                    "/" -> inputTV.text = inputTV.text.toString() + " = " + (num1 / num2).toString()
                }
                usedType = ""
            }
        }
    }
    @SuppressLint("SetTextI18n")
    fun addNum (btn: Button, num: Int)
    {
        btn.setOnClickListener{
            inputTV.text = inputTV.text.toString() + num.toString()
        }
    }

}
