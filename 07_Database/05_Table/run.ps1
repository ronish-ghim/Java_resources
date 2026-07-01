Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

New-Item -ItemType Directory -Force -Path "bin" | Out-Null

javac -cp "lib/*" -d bin src\App.java
java -cp "bin;lib/*" App