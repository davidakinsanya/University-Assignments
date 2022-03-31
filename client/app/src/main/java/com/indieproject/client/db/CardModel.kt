package com.indieproject.client.db

class CardModel {
  var id : Int = 0
  var objectType : String = ""
  var log : String = ""
  var danger_status = false

  fun createCard(id: Int, objectType: String, log: String, danger: Boolean): CardModel {
    val card = CardModel()
    card.id = id
    card.objectType = objectType
    card.log = log
    card.danger_status = danger

    return card
  }
}