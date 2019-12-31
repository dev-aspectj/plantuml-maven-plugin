import org.junit.jupiter.api.Assertions

import java.nio.file.Path
import java.nio.file.Paths

println "prebuild started"

final Path pngPath = Paths.get(basedir.toString()+ "/target/plantuml/Statechart.png")
if (!pngPath.toFile().exists()) {
    final String errorMessage = "No diagram Statechart.png found at: " + pngPath.toAbsolutePath().toString()
    Assertions.fail(errorMessage)
}
