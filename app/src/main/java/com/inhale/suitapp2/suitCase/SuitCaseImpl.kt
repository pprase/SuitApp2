package com.inhale.suitapp2.suitCase

import android.util.Log
import com.inhale.suitapp2.enum.DeclareWinner
import com.inhale.suitapp2.enum.Suit

class SuitCaseImpl : SuitUseCase {


    companion object {
        const val TAG = "SUIT CASE"
    }


    override fun getWinner(player: Suit, computer: Suit): DeclareWinner {
        return when {
            player == Suit.PAPER && computer == Suit.ROCK -> DeclareWinner.PLAYER
            player == Suit.ROCK && computer == Suit.SCISSOR -> DeclareWinner.PLAYER
            player == Suit.SCISSOR && computer == Suit.PAPER -> DeclareWinner.PLAYER
            player == Suit.PAPER && computer == Suit.SCISSOR -> DeclareWinner.COMPUTER
            player == Suit.ROCK && computer == Suit.PAPER -> DeclareWinner.COMPUTER
            player == Suit.SCISSOR && computer == Suit.ROCK -> DeclareWinner.COMPUTER
            else -> {
                DeclareWinner.DRAW
            }
        }
    }

    override fun handlePickComputer(): Suit {
        val pickComputer = Suit.values().random()
        Log.d(TAG, "Result Pick $pickComputer")
        return when (pickComputer) {
            Suit.ROCK -> {
                Suit.ROCK
            }
            Suit.PAPER -> {
                Suit.PAPER
            }
            else -> {
                Suit.SCISSOR
            }
        }
    }

    override fun setColorButtonComputer(): Suit {
        return handlePickComputer()
    }
}

