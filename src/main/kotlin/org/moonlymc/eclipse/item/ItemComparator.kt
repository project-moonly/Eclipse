package org.moonlymc.eclipse.item

import net.minestom.server.item.ItemStack

fun interface ItemComparator {

    companion object {
        val SIMILAR = ItemComparator(ItemStack::isSimilar)
        val EQUALS = ItemComparator(ItemStack::equals)
    }
    public fun compare(item1 : ItemStack, item2 : ItemStack) : Boolean
}