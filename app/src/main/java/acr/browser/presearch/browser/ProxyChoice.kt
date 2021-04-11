package acr.browser.presearch.browser

import acr.browser.presearch.preference.IntEnum

/**
 * The available proxy choices.
 */
enum class ProxyChoice(override val value: Int) : IntEnum {
    NONE(0),
    ORBOT(1),
    I2P(2),
    MANUAL(3)
}
