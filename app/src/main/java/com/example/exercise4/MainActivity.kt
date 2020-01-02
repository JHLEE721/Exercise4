package com.example.exercise4


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.exercise4.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import java.text.SimpleDateFormat
import java.util.*
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Calendar
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)

        val formatter = SimpleDateFormat("dd/MM/yyyy")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ageButton.setOnClickListener {
        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
          {view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
              c.set(mYear, mMonth, mDay)
               binding.dateTextView.setText("${formatter.format(c.time)}")
           }, year, month+1, day)
            datePicker.show()
        }

        binding.calculateButton.setOnClickListener {
            calculate()
        }

        binding.clearButton.setOnClickListener {
            clear()
        }

    }

    private fun calculate() {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)

        var date: Int = year.minus(binding.dateTextView.text.takeLast(4).toString().toInt())
        val birthMonth: Int = binding.dateTextView.text.substring(3..4).toInt()
        val saving = binding.savingEditText.text.toString().toDouble()
        var investment: Double
        //val takeWholeDate = binding.dateTextView.text

        //val birthDate = LocalDate.parse(takeWholeDate, DateTimeFormatter.ISO_DATE)
        //var month = monthFromDate(birthDate)
        //binding.ageNow.setText("Age : " + date.toString())

        //if(birthMonth < month){
        //    date--
        //}else{

        //}

        if(date < 55){
        if (date in 16..20) {
            investment = saving - 5000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 21..25) {
            investment = saving - 14000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 26..30) {
            investment = saving - 29000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 31..35) {
            investment = saving - 50000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 36..40) {
            investment = saving - 78000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 41..45) {
            investment = saving - 116000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 46..50) {
            investment = saving - 165000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date in 51..55) {
            investment = saving - 228000
            if(investment <= 0) {
                binding.message.setText("Minimum basic saving do not reached.")
                binding.message.isVisible = true
                investment = 0.00
            }
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        } else if (date < 16) {
            binding.message.setText("Age Below 16 could not have EPF.")
            binding.message.isVisible = true
            investment = 0.00
            investment = investment.times(0.3)
            binding.amountTextView.setText(investment.toString())
        }
    }else{
            binding.amountTextView.setText(saving.toString())
            binding.message.setText("You can transfer all the basic saving now.")
            binding.message.isVisible = true
        }


    }

    private fun clear(){
        binding.dateTextView.text = null
        binding.ageNow.text = "Age :"
        binding.savingEditText.text = null
        binding.amountTextView.text = "0"
        binding.message.text = null
        binding.message.isVisible = false
    }

}
