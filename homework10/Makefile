JNI=/usr/java/jdk1.8.0_131/include/
JNIOSX=/usr/java/jdk1.8.0_131/include/linux

libmultiple.so: homework10.c homework10.h
	cc -I${JNI} -I${JNIOSX} -shared -o libmultiple.so homework10.c

homework10.h: homework10.class
	javah -verbose homework10

homework10.class: homework10.java
	javac homework10.java

run: homework10.class
	java -Djava.library.path=. homework10
