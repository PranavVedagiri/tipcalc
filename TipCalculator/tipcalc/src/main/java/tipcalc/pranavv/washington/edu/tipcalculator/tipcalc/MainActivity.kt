package tipcalc.pranavv.washington.edu.tipcalculator.tipcalc

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById(R.id.tipButton) as Button
        val amount = findViewById(R.id.amount) as EditText
        button.isEnabled = false

        amount.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                if (s.toString().isEmpty()) {
                    amount.setText("$")
                }
                if (!s.toString().startsWith("$")) {
                    amount.setText("$$s")
                } else if (!s.toString().contains(".")) {
                    var split = s.toString().split(".")
                    var first = split[1]
                    if (first.length > 2) {
                        amount.setText(first[0] + "." + first.substring(0, 2))
                    }
                }

                button.isEnabled = !s.isEmpty()
                amount.setSelection(amount.text.length)

            }

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }
        })
    }
}


