package com.inhale.suitapp2.activity


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.inhale.suitapp2.R
import com.inhale.suitapp2.databinding.ActivityMainBinding
import com.inhale.suitapp2.enum.DeclareWinner
import com.inhale.suitapp2.enum.Suit

class GameActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Game Activity"

    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        setClickPlayerOptions()
    }
    private fun initialize() {
        supportActionBar?.hide()
       viewModel = GameViewModel()
    }
    private fun setClickPlayerOptions() {
                 binding.flScissorLeft.setOnClickListener {
                binding.flPaperLeft.setBackgroundColor(0)
                binding.flScissorLeft.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                binding.flRockLeft.setBackgroundColor(0)
                processGameWinner(Suit.ROCK,viewModel.handlePickComputer())
            }
            binding.flRockLeft.setOnClickListener {
                binding.flPaperLeft.setBackgroundColor(0)
                binding.flScissorLeft.setBackgroundColor(0)
                binding.flRockLeft.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                processGameWinner(Suit.PAPER,viewModel.handlePickComputer())
            }
            binding.btnReset.setOnClickListener {
                setClickPlayerOptions()
                binding.flPaperLeft.setBackgroundColor(0)
                binding.flScissorLeft.setBackgroundColor(0)
                binding.flRockLeft.setBackgroundColor(0)
                binding.flPaperRight.setBackgroundColor(0)
                binding.flScissorRight.setBackgroundColor(0)
                binding.flRockRight.setBackgroundColor(0)
                binding.tvWinner.text = getString(R.string.text_winnerr)
            }
        }

        private fun processGameWinner(player: Suit, computer: Suit) {
            setColorButtonComputer(computer)
            resultGameWinner(DeclareWinner.COMPUTER)
        }

        private fun resultGameWinner(result: DeclareWinner) {
            when (result) {
                DeclareWinner.PLAYER -> {
                    binding.tvWinner.text =getString(R.string.text_player_win)
                    Log.d(TAG, "Winner -> Player")
                    binding.flPaperLeft.setOnClickListener(null)
                    binding.flScissorLeft.setOnClickListener(null)
                    binding.flRockLeft.setOnClickListener(null)
                }
                DeclareWinner.COMPUTER -> {
                    binding.tvWinner.text = getString(R.string.text_computer_win)
                    Log.d(TAG, "Winner -> Computer")
                    binding.flPaperLeft.setOnClickListener(null)
                    binding.flScissorLeft.setOnClickListener(null)
                    binding.flRockLeft.setOnClickListener(null)
                }
                DeclareWinner.DRAW -> {
                    binding.tvWinner.text = getString(R.string.text_draw)
                    Log.d(TAG, "Draw")
                    binding.flPaperLeft.setOnClickListener(null)
                    binding.flScissorLeft.setOnClickListener(null)
                    binding.flRockLeft.setOnClickListener(null)
                }
            }
        }

        private fun setColorButtonComputer(computer: Suit) {
            when (computer) {
                Suit.ROCK -> {
                    binding.flPaperRight.setBackgroundColor(0)
                    binding.flScissorRight.setBackgroundColor(0)
                    binding.flRockRight.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
                Suit.PAPER -> {
                    binding.flPaperRight.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    binding.flScissorRight.setBackgroundColor(0)
                    binding.flRockRight.setBackgroundColor(0)
                }
                else -> {
                    binding.flPaperRight.setBackgroundColor(0)
                    binding.flScissorRight.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        )
                    )
                    binding.flRockRight.setBackgroundColor(0)
                }
            }
        }

    }
