package com.inhale.suitapp2.suitCase

import com.inhale.suitapp2.enum.DeclareWinner
import com.inhale.suitapp2.enum.Suit

interface SuitUseCase {
        fun getWinner(player: Suit, computer: Suit): DeclareWinner
        fun handlePickComputer(): Suit
        fun setColorButtonComputer(): Suit

    }
