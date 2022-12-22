package maestro.studio

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class DeviceScreen(
    val screenshot: String,
    val width: Int,
    val height: Int,
    val elements: List<UIElement>,
)

data class UIElementBounds(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int,
)

data class UIElement(
    val id: String, // Autogenerated uuid to make this easier to work with on the frontend
    val bounds: UIElementBounds?,
    val resourceId: String?,
    val resourceIdIndex: Int?,
    val text: String?,
    val textIndex: Int?
)

enum class ReplCommandStatus {
    @JsonProperty("pending")
    PENDING,
    @JsonProperty("running")
    RUNNING,
    @JsonProperty("success")
    SUCCESS,
    @JsonProperty("error")
    ERROR,
    @JsonProperty("canceled")
    CANCELED,
}

data class ReplCommand(
    val id: UUID,
    val yaml: String,
    val status: ReplCommandStatus,
)

data class Repl(
    val version: Int,
    val commands: List<ReplCommand>,
)