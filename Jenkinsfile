#!/usr/bin/env groovy

def docsOutDir = 'docsOut'
def docsRepositoryUrl = 'git@github.com:CraftTweaker/CraftTweaker-Documentation.git'
def gitSshCredentialsId = 'crt_git_ssh_key'
def botUsername = 'crafttweakerbot'
def botEmail = 'crafttweakerbot@gmail.com'

def documentationDir = 'CrafttweakerDocumentation'
def exportDirInRepo = 'docs_exported/1.18/iceandfire'

pipeline {
    agent any
    tools {
        jdk "jdk-17.0.1"
    }
    stages {
        stage('Clean') {
            steps {
                withCredentials([file(credentialsId: 'mod_build_secrets', variable: 'ORG_GRADLE_PROJECT_secretFile')]) {
                    echo 'Cleaning Project'
                    sh 'chmod +x gradlew'
                    sh './gradlew clean'
                }
            }
        }
        stage('Build') {
            steps {
                withCredentials([file(credentialsId: 'mod_build_secrets', variable: 'ORG_GRADLE_PROJECT_secretFile')]) {
                    echo 'Building'
                    sh './gradlew build'
                }
            }
        }
        stage('Git Changelog') {
            steps {
                withCredentials([file(credentialsId: 'mod_build_secrets', variable: 'ORG_GRADLE_PROJECT_secretFile')]) {
                    sh './gradlew genGitChangelog'
                }
            }
        }

        stage('Publish') {
            steps {
                withCredentials([file(credentialsId: 'mod_build_secrets', variable: 'ORG_GRADLE_PROJECT_secretFile')]) {
                    echo 'Updating version'
                    sh './gradlew updateVersionTracker'

                    echo 'Deploying to Maven'
                    sh './gradlew publish'

                    echo 'Deploying to CurseForge'
                    sh './gradlew curseforge'

                }
            }
        }

        stage('Exporting Documentation') {
            steps {
                echo "Cloning Repository at Branch main"

                dir(documentationDir) {
                    git credentialsId: gitSshCredentialsId, url: docsRepositoryUrl, branch: "main", changelog: false
                }


                echo "Clearing existing Documentation export"
                dir(documentationDir) {
                    sh "rm --recursive --force ./$exportDirInRepo"
                }

                echo "Moving Generated Documentation to Local Clone"
                sh "mkdir --parents ./$documentationDir/$exportDirInRepo"
                sh "mv ./$docsOutDir/* ./$documentationDir/$exportDirInRepo/"


                echo "Committing and Pushing to the repository"
                dir(documentationDir) {
                    sshagent([gitSshCredentialsId]) {
                        sh "git config user.name $botUsername"
                        sh "git config user.email $botEmail"
                        sh 'git add -A'
                        //Either nothing to commit, or we create a commit
                        sh "git diff-index --quiet HEAD || git commit -m 'CI Doc export for iceandfiretweaker build ${env.BRANCH_NAME}-${env.BUILD_NUMBER}\n\nMatches git commit ${env.GIT_COMMIT}'"
                        sh "git push origin main"
                    }
                }
            }
        }
    }
}