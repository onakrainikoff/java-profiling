# java-profiling

## Thread Dump
- mvn clean install -f deadlock/pom.xml
- java -jar deadlock/target/deadlock.jar
- jcmd
- jcmd <vmid> Thread.print -l > oom/target/thread-dump.txt
- load thread-dump.txt to https://fastthread.io

## Heap Dump
- mvn clean install -f oom/pom.xml
- java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=oom/target/heap-dumps -jar oom/target/oom-jar-with-dependencies.jar
- jсmd
- jcmd <vmid> GC.heap_dump
- load dump to MAT(with IBM Memory Analyzer tool)
- or load dump to to https://heaphero.io/

## GC Logs
- mvn clean install -f gc/pom.xml
- java -Xlog:gc:gc/target/gc.log -jar gc/target/gc-jar-with-dependencies.jar
- load log to https://gceasy.io/

## VM Info
- jps -lvm
- jinfo -flags <vmid>
- jinfo -sysprops <vmid>
- jcmd <vmid> VM.system_properties
- jcmd <vmid> VM.flags

## Remote Profiling
- mvn clean install -f gc/pom.xml
-
```
java \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=65535 \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.local.only=false \
-Djava.rmi.server.hostname=localhost \
-jar gc/target/gc-jar-with-dependencies.jar
  ```
- java -jar gc/target/gc-jar-with-dependencies.jar
- connect with jconsole
-
## Remote Debugging
- mvn clean install -f gc/pom.xml
- java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 gc/target/gc-jar-with-dependencies.jar
- connect with idea