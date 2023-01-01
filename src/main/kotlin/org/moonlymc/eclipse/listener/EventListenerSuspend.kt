package org.moonlymc.eclipse.listener

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minestom.server.event.Event
import net.minestom.server.event.EventListener
import org.moonlymc.eclipse.coroutine.MinestomSync


abstract class EventListenerSuspend<E : Event>(
    private val coroutineScope : CoroutineScope = Dispatchers.MinestomSync.scope
) : EventListener<E> {

    override fun run(event: E): EventListener.Result {
        coroutineScope.launch(start = CoroutineStart.UNDISPATCHED) {
            runSuspend(event)
        }

        return EventListener.Result.SUCCESS
    }

    protected abstract suspend fun runSuspend(event : E)
}