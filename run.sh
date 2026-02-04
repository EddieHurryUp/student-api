#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

mvn -q -DskipTests package

if [ -n "${DB_PATH:-}" ]; then
  mvn -q spring-boot:run -Dspring-boot.run.arguments="--app.db.path=$DB_PATH"
else
  mvn -q spring-boot:run
fi
