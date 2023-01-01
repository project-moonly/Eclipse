package org.moonlymc.eclipse.command

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandSyntax
import net.minestom.server.command.builder.arguments.Argument
import org.moonlymc.eclipse.coroutine.MinestomSync

inline fun Command.setDefaultExecutorSuspend(
    coroutineScope: CoroutineScope = Dispatchers.MinestomSync.scope,
    crossinline executor : suspend(sender : CommandSender, context : CommandContext) -> Unit
) : Unit = setDefaultExecutor { sender, context ->
    coroutineScope.launch(start = CoroutineStart.UNDISPATCHED) {
        executor.invoke(sender, context)
    }
}

inline fun Command.addSyntaxSuspend(
    crossinline executor: suspend (sender: CommandSender, context: CommandContext) -> Unit,
    vararg arguments : Argument<*>,
    coroutineScope: CoroutineScope = Dispatchers.MinestomSync.scope
) : MutableCollection<CommandSyntax> = addSyntax({sender, context ->
    coroutineScope.launch(start = CoroutineStart.UNDISPATCHED) {
        executor.invoke(sender, context)
    }
}, *arguments)

inline fun Command.addConditionalSyntaxSuspend(
    noinline condition : (sender : CommandSender, commandString : String?) -> Boolean,
    crossinline executor: suspend (sender: CommandSender, context: CommandContext) -> Unit,
    vararg arguments : Argument<*>,
    coroutineScope: CoroutineScope = Dispatchers.MinestomSync.scope
) : MutableCollection<CommandSyntax> = addConditionalSyntax(condition, {sender, context ->
    coroutineScope.launch(start = CoroutineStart.UNDISPATCHED) {
        executor.invoke(sender, context)
    }
}, *arguments)