import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.githubConnection
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    vcsRoot(HttpsGithubComIyankeVersioned1)
    vcsRoot(Versioned2)

    buildType(One)

    features {
        githubConnection {
            id = "PROJECT_EXT_3"
            displayName = "GitHub.com"
            clientId = "810d6d167220ea6677d1"
            clientSecret = "credentialsJSON:402058c0-3186-43a2-80f0-7fa3a4dca7bb"
        }
    }
}

object One : BuildType({
    name = "One"
})

object HttpsGithubComIyankeVersioned1 : GitVcsRoot({
    name = "https://github.com/iyanke/versioned1"
    url = "https://github.com/iyanke/versioned1"
    branch = "refs/heads/main"
})

object Versioned2 : GitVcsRoot({
    name = "versioned2"
    url = "https://github.com/iyanke/versioned3"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "iyanke"
        password = "credentialsJSON:e7e03def-93d1-4e6e-a93b-ba0fd8b94c00"
    }
})
