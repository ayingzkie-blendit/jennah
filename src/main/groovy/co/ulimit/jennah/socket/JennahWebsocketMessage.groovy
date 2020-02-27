package co.ulimit.jennah.socket

class JennahWebsocketMessage {

	JennahWebsocketMessage(String from, String message, String title, JennahMessageType type) {
		this.from = from
		this.message = message
		this.title = title
		this.type = type
	}
	String from = ""
	String message = ""
	String title = ""
	JennahMessageType type = null
}
