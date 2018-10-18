package org.wa.rceditor.application.model

import javafx.beans.property.ObjectProperty
import tornadofx.*
import java.util.*

class CheckingEntityItem(text: String) {
    val id: UUID = UUID.randomUUID()

    var text: String by property(text)
    val textProperty = getProperty(CheckingEntityItem::text)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as CheckingEntityItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return text
    }
}

class CheckingEntityItemModel(property: ObjectProperty<CheckingEntityItem>) :
        ItemViewModel<CheckingEntityItem>(itemProperty = property) {
    val text = bind(autocommit = true) { item?.textProperty }
}