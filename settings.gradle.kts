rootProject.name = "code-kata"

val projectNames = rootDir.listFiles()!!
    .filter { it.isDirectory }
    .map { it.name }
    .filter { it.contains("(java|kt)".toRegex()) }

include(projectNames)
