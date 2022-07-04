package utilities

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.User
import java.time.LocalDateTime

class EmbedUtils(user: User? = null, timestamp: Boolean = false) {

    private val embed = EmbedBuilder()
    private var footer: String = ""
    private var userImage = user?.avatarUrl ?: user?.defaultAvatarUrl

    constructor(timestamp: Boolean) : this(null, timestamp)

    init {
        embed.setColor(Utils.hex2rgb(ColorUtils.DEFAULT.code))

        if (user != null) {
            footer = "Requested by: ${user.asTag}"
            embed.setFooter(footer, userImage)
        }
        embed.setTimestamp(LocalDateTime.now())
    }

    fun title(title: String): EmbedUtils {
        embed.setTitle(title)
        return this
    }

    fun footer(footer: String): EmbedUtils {
        embed.setFooter(footer)
        return this
    }

    fun footer(footer: String, icon: String): EmbedUtils {
        embed.setFooter(footer, icon)
        return this
    }

    fun appendFooter(footer: String): EmbedUtils {
        this.footer += footer
        embed.setFooter(this.footer, userImage)
        return this
    }

    fun color(color: String): EmbedUtils {
        embed.setColor(Utils.hex2rgb(color))
        return this
    }

    fun color(color: ColorUtils): EmbedUtils {
        embed.setColor(Utils.hex2rgb(color.code))
        return this
    }

    fun field(title: String, body: String): EmbedUtils {
        embed.addField(title, body, false)
        return this
    }

    fun field(field: MessageEmbed.Field): EmbedUtils {
        embed.addField(field)
        return this
    }

    fun field(title: String, body: String, inline: Boolean): EmbedUtils {
        embed.addField(title, body, inline)
        return this
    }

    fun thumbnail(url: String): EmbedUtils {
        embed.setThumbnail(url)
        return this
    }

    fun empty(): EmbedUtils {
        embed.addBlankField(false)
        return this
    }

    fun image(url: String): EmbedUtils {
        embed.setImage(url)
        return this
    }

    fun author(author: String): EmbedUtils {
        embed.setAuthor(author)
        return this
    }

    fun author(author: String, image: String): EmbedUtils {
        embed.setAuthor(author, null, image)
        return this
    }

    fun description(description: String): EmbedUtils {
        embed.setDescription(description)
        return this
    }

    fun build(): MessageEmbed {
        return embed.build()
    }

}