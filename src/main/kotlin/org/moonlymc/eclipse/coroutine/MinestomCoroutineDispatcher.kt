package org.moonlymc.eclipse.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.SupervisorJob
import net.minestom.server.ServerProcess
import net.minestom.server.timer.ExecutionType
import kotlin.coroutines.CoroutineContext

open class MinestomCoroutineDispatcher(
    private val serverProcess: ServerProcess,
    val type : ExecutionType
) : CoroutineDispatcher() {

    val scope : CoroutineScope by lazy { CoroutineScope(this + SupervisorJob()) }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        if (!serverProcess.isAlive) {
            return
        }

        serverProcess.scheduler().scheduleNextProcess(block, type)
    }
}