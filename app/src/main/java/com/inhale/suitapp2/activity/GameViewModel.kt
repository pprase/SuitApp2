package com.inhale.suitapp2.activity

import androidx.lifecycle.ViewModel
import com.inhale.suitapp2.enum.DeclareWinner
import com.inhale.suitapp2.enum.Suit
import com.inhale.suitapp2.suitCase.SuitCaseImpl

class GameViewModel : ViewModel (){

  private val suitCaseImpl = SuitCaseImpl()

    fun getWinner(player: Suit,computer: Suit):DeclareWinner {
        return suitCaseImpl.getWinner(player, computer)
    }

    fun handlePickComputer ():Suit {
        return suitCaseImpl.handlePickComputer()
    }
        fun setColorButtonComputer(): Suit {
            return suitCaseImpl.setColorButtonComputer()
        }

}