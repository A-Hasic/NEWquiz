package com.example.kviznovi

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel()  {
    var pitanja = listOf(
        Pitanja(
            text = "Sarajevo je glavni grad Bosne",
            odgovor = true ,
            dalijeOdgovoreno = false

        ),
        Pitanja(
            text = "Zagreb je glavni grad Hrvatske",
            odgovor = true,
            dalijeOdgovoreno = false

        ),
        Pitanja(
            text = "Istanbul je glavni grad Turske",
            odgovor = false,
            dalijeOdgovoreno = false
        ),
        Pitanja(
            text = "Beograd je glavni grad Srbije",
            odgovor = true,
            dalijeOdgovoreno = false

        ),
        Pitanja(
            text = "Maribor je glavni grad Slovenije",
            odgovor = false,
            dalijeOdgovoreno = false

        ),
        Pitanja(
            text = "Berlin je glavni grad Njemacke",
            true ,
            dalijeOdgovoreno = false

        ),
        Pitanja(
            text = "London je glavni grad Rusije",
            odgovor = false,
            dalijeOdgovoreno = false
        )
    )
    var trenutniIndex = 0
    var trenutniRezultat = 0
}