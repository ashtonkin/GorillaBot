package utilities

import java.awt.Color

object Utils {

    fun hex2rgb(colorString: String): Color {
        return Color(
            Integer.valueOf(colorString.substring(1, 3), 16),
            Integer.valueOf(colorString.substring(3, 5), 16),
            Integer.valueOf(colorString.substring(5, 7), 16)
        )
    }

}