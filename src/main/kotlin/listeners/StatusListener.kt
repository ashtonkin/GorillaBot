package listeners

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.events.guild.GuildReadyEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class StatusListener: ListenerAdapter() {

    override fun onGuildReady(event: GuildReadyEvent) =
        updatePresence(event.jda, event.guild.memberCount)


    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) =
        updatePresence(event.jda, event.guild.memberCount)


    override fun onGuildMemberRemove(event: GuildMemberRemoveEvent) =
        updatePresence(event.jda, event.guild.memberCount)


    private fun updatePresence(jda: JDA, members: Int) =
        jda.presence.setPresence(Activity.watching("$members members"), false)

}