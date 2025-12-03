#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
cd "$(dirname "$0")"
ant clean build
echo "Projet reconstruit avec succès !"
