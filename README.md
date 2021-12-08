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
