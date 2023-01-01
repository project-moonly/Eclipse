package org.moonlymc.eclipse.coroutine

import kotlinx.coroutines.Dispatchers
import net.minestom.server.MinecraftServer
import net.minestom.server.ServerProcess
import net.minestom.server.timer.ExecutionType

internal val minestomAsyncDispatcher = MinestomAsyncCoroutineDispatcher(MinecraftServer.process())

val Dispatchers.MinestomAsync : MinestomCoroutineDispatcher get() = minestomAsyncDispatcher
class MinestomAsyncCoroutineDispatcher(serverProcess : ServerProcess) : MinestomCoroutineDispatcher(serverProcess, ExecutionType.ASYNC){
}