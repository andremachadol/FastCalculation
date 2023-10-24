package br.edu.scl.ifsp.sdm.fastcalculation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.edu.scl.ifsp.sdm.fastcalculation.Extras.EXTRA_SCORE
import br.edu.scl.ifsp.sdm.fastcalculation.databinding.FragmentGameFinalBinding

class GameFinalFragment : Fragment() {
    private lateinit var binding: FragmentGameFinalBinding
    private lateinit var points: ScoreResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            points = it.getParcelable(EXTRA_SCORE)?: ScoreResult()
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentGameFinalBinding.inflate(inflater, container, false)
        points.also {
            binding.tScore.text = it.points
        }
        binding.buttonRestartGame.setOnClickListener{
            (context as OnPlayGame).onPlayGame()
        }
        return binding.root
    }
        companion object {
            @JvmStatic
            fun newInstance(points: ScoreResult)=
                GameFinalFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(EXTRA_SCORE, points)
                    }
                }
        }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.restartGameMi).isVisible = false
    }

}