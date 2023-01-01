package org.moonlymc.eclipse.coroutine

import kotlinx.coroutines.Dispatchers
import net.minestom.server.MinecraftServer
import net.minestom.server.ServerProcess
import net.minestom.server.timer.ExecutionType


internal val minestomSyncDispatcher = MinestomSyncCoroutineDispatcher(MinecraftServer.process())

val Dispatchers.MinestomSync : MinestomCoroutineDispatcher get() = minestomSyncDispatcher
class MinestomSyncCoroutineDispatcher(serverProcess: ServerProcess) : MinestomCoroutineDispatcher(serverProcess, ExecutionType.SYNC) {
}