#!/usr/bin/env sh

VERSION=1.15.0
JAR_FILE=../libs/google-java-format-$VERSION-all-deps.jar

chmod +x $JAR_FILE

echo "Find java files..."
echo "`find ../ -name '*.java'`"

echo "\nApply google-java-format..."

java \
  --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
  --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
  --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
  --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
  --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
  -jar $JAR_FILE -replace -aosp `find ../ -name '*.java'`

echo "Done."