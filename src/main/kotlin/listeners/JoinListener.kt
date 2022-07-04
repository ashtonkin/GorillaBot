package listeners

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class JoinListener: ListenerAdapter() {

    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        val guild = event.guild
        guild.getRoleById("873551197104111627")?.let { guild.addRoleToMember(event.member, it).queue() }
        if (event.guild.id == "873547180642807909") {
            guild.getRoleById("873588935710887946")?.let { guild.addRoleToMember(event.member, it).queue() }
        }
    }
}