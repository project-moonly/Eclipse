package org.moonlymc.eclipse.inventory

import net.minestom.server.inventory.AbstractInventory
import net.minestom.server.inventory.condition.InventoryCondition
import net.minestom.server.item.ItemStack
import org.moonlymc.eclipse.item.ItemComparator

val AbstractInventory.slots : IntRange
    get() = this.itemStacks.indices

fun AbstractInventory.removeCondition(condition : InventoryCondition) : Boolean = inventoryConditions.remove(condition)

fun AbstractInventory.lockItemPositions() : InventoryCondition {
    val condition = InventoryCondition { _, _, _, result ->
        result.isCancel = true
    }
    addInventoryCondition(condition)
    return condition
}

fun AbstractInventory.onSlotClick(slot : Int, handler : InventoryCondition) : InventoryCondition {
    val condition = InventoryCondition { player, s, clickType, result ->
        if (s == slot) {
            handler.accept(player, s, clickType, result)
        }
    }
    addInventoryCondition(condition)
    return condition
}

fun AbstractInventory.onItemClick(item : ItemStack, comparator: ItemComparator = ItemComparator.EQUALS, handler : InventoryCondition) : InventoryCondition {
    val condition = InventoryCondition { player, slot, clickType, result ->
        if(slot in slots && comparator.compare(item, getItemStack(slot))) {
            handler.accept(player, slot, clickType, result)
        }
    }
    addInventoryCondition(condition)
    return condition
}