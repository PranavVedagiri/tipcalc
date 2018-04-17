
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
import tipcalc.pranavv.washington.edu.tipcalculator.tipcalc.R.id.Button
import tipcalc.pranavv.washington.edu.tipcalculator.tipcalc.R.id.amount
import java.text.DecimalFormat
import java.text.NumberFormat



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val amount = findViewById<EditText>(R.id.amount)
        val btn = findViewById<Button>(R.id.Button)

        amount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
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
                btn.isEnabled = !amount.text.isEmpty()
                amount.setSelection(amount.text.length)
            }
        })
        btn.setOnClickListener{
            var dub = amount.text.toString().replace("$", "").toDouble()
            var finalTip = dub * 1.15
            Toast.makeText(this, ("$" + "%.2f".format(finalTip)), Toast.LENGTH_LONG).show()
        }
    }
}




