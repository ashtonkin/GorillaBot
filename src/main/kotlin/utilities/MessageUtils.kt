package utilities

import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.TextChannel

class MessageUtils {

    fun TextChannel.queueMessage(message : Message) = sendMessage(message).queue()

    fun TextChannel.queueMessage(message : CharSequence) = sendMessage(message).queue()

    fun TextChannel.queueMessage(message : MessageEmbed) = sendMessageEmbeds(message).queue()

    fun MessageChannel.queueMessage(message : Message) = sendMessage(message).queue()

    fun MessageChannel.queueMessage(message : CharSequence) = sendMessage(message).queue()

    fun MessageChannel.queueMessage(message : MessageEmbed) = sendMessageEmbeds(message).queue()

}