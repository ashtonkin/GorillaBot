import listeners.JoinListener
import listeners.StatusListener
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Gorilla {

    private val logger = LoggerFactory.getLogger("Gorilla") as Logger

    //TODO: Add setup command
    //      - give role on join (need to know the role ID and save within guild file)

    init {
        val props = Properties()
        props.load(Gorilla::class.java.getResourceAsStream("/bot.properties"))
        val token = props.getProperty("TOKEN")
        val bot = DefaultShardManagerBuilder.createDefault(token)
            .disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING)
        registerListeners(bot)
        bot.build()
        logger.info("Gorilla is alive!!")
    }

    private fun registerListeners(bot: DefaultShardManagerBuilder) {
        val listeners = listOf(
            JoinListener(),
            StatusListener()
        )
        logger.info("Registering ${listeners.size} listeners...")
        listeners.forEach { bot.addEventListeners(it) }
    }


}