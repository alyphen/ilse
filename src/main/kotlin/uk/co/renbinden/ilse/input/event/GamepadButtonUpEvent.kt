package uk.co.renbinden.ilse.input.event

import uk.co.renbinden.ilse.event.EventMapper
import uk.co.renbinden.ilse.input.gamepad.Gamepad


class GamepadButtonUpEvent(gamepad: Gamepad, val button: Int) : GamepadEvent(gamepad) {
    companion object : EventMapper<GamepadButtonUpEvent>(GamepadButtonUpEvent::class)
}