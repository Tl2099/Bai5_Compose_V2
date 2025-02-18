import org.jetbrains.compose.web.renderComposable
import org.jetbrains.compose.web.dom.*

fun main() {
    renderComposable(rootElementId = "root") {
        H1 { Text("Hello, KMM Web!") }
    }
}
