rootProject.name = "code-kata"

val projects = rootDir.listFiles()!!
    .filter { it.isDirectory }
    .map { it.name }
    .filter { it.contains("(java|kt)".toRegex()) }

include(projects)
