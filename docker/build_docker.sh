#!/usr/bin/env bash

SERVICE_NAME=poc-service
TIMESTAMP=$(date +%s)
GIT_HASH=$(git rev-parse --verify HEAD)
GIT_SHORT_HASH=$(git rev-parse --short HEAD)
#VERSION=$(head gradle.properties | sed -e "s/^version=//")
VERSION=$(gradle printVersion -q)

cp ./build/libs/*${VERSION}.jar ./build/${SERVICE_NAME}.jar
docker build . \
  --file ./docker/Dockerfile \
  --build-arg JAR_FILE="${SERVICE_NAME}.jar" \
  --tag "${SERVICE_NAME}:${VERSION}" \
  --tag "${SERVICE_NAME}:tmp-${TIMESTAMP}" \
  --tag "${SERVICE_NAME}:git-${GIT_HASH}" \
  --tag "${SERVICE_NAME}:git-${GIT_SHORT_HASH}" \
  --tag "${SERVICE_NAME}:latest"
