package com.example.kviznovi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kviznovi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateQuestion()

        binding.trueOdgovor.setOnClickListener {
            showTrue()
            pogledajOdgovor(true)
        }

        binding.falseOdgovor.setOnClickListener {
            showFalse()
            pogledajOdgovor(false)
        }

        binding.nextDugme.setOnClickListener {
            nextQuestion()
            updateQuestion()
        }

        binding.backButton.setOnClickListener {
            previousQuestion()
            updateQuestion()
        }

        binding.cheatButton.setOnClickListener {
            cheatVisibility()
        }

        binding.buttonSljedeci.setOnClickListener {
            val intent = Intent(this, DrugiActivity::class.java)
            startActivity(intent)
        }





    }

    private fun cheatVisibility() {
        binding.textAnswer.visibility = View.VISIBLE
    }

    private fun nextQuestion() {
        if (viewmodel.trenutniIndex == viewmodel.pitanja.size - 1)
        else viewmodel.trenutniIndex++
    }

    private fun previousQuestion() {
        if (viewmodel.trenutniIndex == 0)
            println(viewmodel.trenutniIndex)
        else viewmodel.trenutniIndex--
    }

    private fun updateQuestion() {
        val trenutnoPitanje = viewmodel.pitanja[viewmodel.trenutniIndex]
        binding.pitanjeJe.text = trenutnoPitanje.text
        binding.textAnswer.text = trenutnoPitanje.odgovor.toString()
        binding.textAnswer.visibility = View.GONE

        if (trenutnoPitanje.dalijeOdgovoreno) {
            binding.trueOdgovor.isEnabled = false
            binding.falseOdgovor.isEnabled = false
        } else {
            binding.trueOdgovor.isEnabled = true
            binding.falseOdgovor.isEnabled = true
        }
    }

    private fun pogledajOdgovor(userovOdgovor: Boolean) {
        val ispravanOdgovor = viewmodel.pitanja[viewmodel.trenutniIndex].odgovor
        binding.trueOdgovor.isEnabled = false
        binding.falseOdgovor.isEnabled = false

        if (userovOdgovor == ispravanOdgovor) {
            showTrue()
            povecajRezultat()
            viewmodel.pitanja[viewmodel.trenutniIndex].dalijeOdgovoreno = true
        } else {
            showFalse()
            smanjiRezultat()
            viewmodel.pitanja[viewmodel.trenutniIndex].dalijeOdgovoreno = true
        }

    }

    private fun smanjiRezultat() {
        viewmodel.trenutniRezultat = viewmodel.trenutniRezultat - 5
        binding.rezultatTrenutni.text = "Trenutni rezultat je ${viewmodel.trenutniRezultat} "

    }

    private fun povecajRezultat() {
        viewmodel.trenutniRezultat = viewmodel.trenutniRezultat + 10
        binding.rezultatTrenutni.text = "Trenutni rezultat je ${viewmodel.trenutniRezultat} "
    }

    private fun showTrue() {
        Toast.makeText(this, "AFERIM", Toast.LENGTH_SHORT).show()
    }

    private fun showFalse() {
        Toast.makeText(this, "FALSE", Toast.LENGTH_SHORT).show()
    }
}


























