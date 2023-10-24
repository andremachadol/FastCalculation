package br.edu.scl.ifsp.sdm.fastcalculation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScoreResult(
    val points: String = ""
) : Parcelable