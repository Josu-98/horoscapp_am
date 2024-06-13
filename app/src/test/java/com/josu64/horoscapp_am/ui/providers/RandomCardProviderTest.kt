package com.josu64.horoscapp_am.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should return a non null card`(){
        //Given
        val randomCard = RandomCardProvider()
        //When
        val card = randomCard.getLuck()
        //Then
        assertNotNull(card)
    }

}