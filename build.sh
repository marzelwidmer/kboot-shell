#!/bin/zsh

./mvnw -Pnative native:compile -DskipTests
cp target/kboot-shell bin/
./bin/kboot-shell