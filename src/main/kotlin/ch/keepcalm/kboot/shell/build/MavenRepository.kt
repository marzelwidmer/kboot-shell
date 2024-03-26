package ch.keepcalm.kboot.shell.build

data class MavenRepository (
    val id: String,
    val url: String,
    val name: String,
    val releasesEnabled: Boolean
)


