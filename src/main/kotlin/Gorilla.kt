import listeners.JoinListener
import listeners.StatusListener
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Gorilla {

    private val logger = LoggerFactory.getLogger("Gorilla") as Logger

    companion object {
        private const val token =
            "YOUR TOKEN HERE"
        private val builder = DefaultShardManagerBuilder.createDefault(token)
            .disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING)
    }

    //TODO: Add setup command
    //      - give role on join (need to know the role ID and save within guild file)

    init {
        registerListeners()
        builder.build()
        logger.info("Gorilla is alive!!")
    }

    private fun registerListeners() {
        val listeners = listOf(
            JoinListener(),
            StatusListener()
        )
        logger.info("Registering ${listeners.size} listeners...")
        listeners.forEach { builder.addEventListeners(it) }
    }


}
