package ru.octol1ttle.flightassistant.impl.computer.autoflight

import dev.architectury.event.events.common.InteractionEvent
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.FireworkRocketItem
import net.minecraft.world.item.ItemStack
import ru.octol1ttle.flightassistant.FlightAssistant
import ru.octol1ttle.flightassistant.api.computer.Computer
import ru.octol1ttle.flightassistant.api.computer.ComputerBus
import ru.octol1ttle.flightassistant.api.computer.ComputerQuery
import ru.octol1ttle.flightassistant.config.FAConfig
import ru.octol1ttle.flightassistant.impl.display.StatusDisplay

class FireworkComputer(computers: ComputerBus) : Computer(computers) {
    private var safeFireworkCount: Int = 0

    override fun subscribeToEvents() {
        InteractionEvent.RIGHT_CLICK_ITEM.register(InteractionEvent.RightClickItem { player, hand ->
            val stack: ItemStack = player.getItemInHand(hand)
            if (player.level().isClientSide() && computers.data.flying && stack.item is FireworkRocketItem) {
                val explosive = FAConfig.safety.fireworkLockExplosive && !isEmptyOrSafe(player, hand)
                val anyTerrainAhead = FAConfig.safety.fireworkLockObstacles && anyTerrainAhead()
                if (computers.data.automationsAllowed() && (explosive || anyTerrainAhead)) {
//? if >=1.21.2 {
                    /*return@RightClickItem net.minecraft.world.InteractionResult.FAIL
*///?} else
                    return@RightClickItem dev.architectury.event.CompoundEventResult.interruptFalse(stack)
                }
            }

//? if >=1.21.2 {
            /*return@RightClickItem net.minecraft.world.InteractionResult.PASS
*///?} else
            return@RightClickItem dev.architectury.event.CompoundEventResult.pass()
        })
    }

    override fun tick() {
        safeFireworkCount = 0
        for (stack: ItemStack in
//? if >=1.21.5 {
        /*computers.data.player.inventory.nonEquipmentItems
*///?} else
        computers.data.player.inventory.items
        ) {
            if (isFireworkAndSafe(stack)) {
                safeFireworkCount += stack.count
            }
        }
        if (isFireworkAndSafe(computers.data.player.offhandItem)) {
            safeFireworkCount += computers.data.player.offhandItem.count
        }
    }

    fun isEmptyOrSafe(player: Player, hand: InteractionHand): Boolean {
        return hasNoExplosions(player.getItemInHand(hand))
    }

    private fun isFireworkAndSafe(stack: ItemStack): Boolean {
        return stack.item is FireworkRocketItem && hasNoExplosions(stack)
    }

    private fun hasNoExplosions(stack: ItemStack): Boolean {
//? if >=1.21 {
        /*return stack.get(net.minecraft.core.component.DataComponents.FIREWORKS)?.explosions?.isEmpty() != false
*///?} else
        return stack.getTagElement("Fireworks")?.getList("Explosions", net.minecraft.nbt.Tag.TAG_COMPOUND.toInt())?.isEmpty() != false
    }

    private fun anyTerrainAhead(): Boolean {
        val velocity = computers.data.player.forward.scale(FIREWORK_SPEED.toDouble())
        return computers.gpws.computeObstacleImpactTime(velocity, computers.gpws.cautionThreshold) <= computers.gpws.warningThreshold
    }

    override fun <Response> handleQuery(query: ComputerQuery<Response>) {
        if (query is StatusDisplay.StatusMessageQuery && computers.data.flying && safeFireworkCount > 0) {
            query.respond(Component.translatable("status.flightassistant.firework_count", safeFireworkCount))
        }
    }

    override fun reset() {
        safeFireworkCount = 0
    }

    companion object {
        val ID: ResourceLocation = FlightAssistant.id("firework")

        private const val FIREWORK_SPEED: Float = 33.33f
    }
}
