/*****************************************************************
//  NAME:        Lloyd Sanderson
//
//  HOMEWORK:    10
//
//  CLASS:       ICS 212
//
//  INSTRUCTOR:  Ravi Narayan
// 
//  DATE:        May 3, 2022
//
//  FILE:        homework10.c
//
//  DESCRIPTION:
//   The C Source code of the is_multiple5 code. Calls from homework10.java
//   whther or not the number is divisible by 5. Uses JNI to be called from
//   the library libmultiple.so which was defined in homework10.java and
//   calculates the answer to be used.
//
****************************************************************/

#include "homework10.h"
#include <stdio.h>

/*****************************************************************
//  Function name: Java_homework10_is_1multiple5
//
//  DESCRIPTION:   The Java called native function which takes in the
//                 maximum value from the user and goes through every
//                 number to the maximum value to see if the number is
//                 divisible by 5
//
//  Parameters:    JNIEnv *env: The environment pointer to the native class
//                 is_multiple5. Allows interaction with the JNI environment
//                 and works with this C Source code to rotate data back
//                 and forth.
//                 jclass class: the object on which is_multiple5 is invoked.
//                 A reference to the current class in homework10
//                 jint i: The max value that was input by the user invoked
//                 in java.
//
//  Return values:  0 : not divisible by 5
//                  1 : divisible by 5
//
****************************************************************/        
JNIEXPORT jint JNICALL Java_homework10_is_1multiple5
(JNIEnv *env, jclass class, jint i)
{
    if (i % 5 == 0)
    {
        i = 1;
    }
    
    else
    {
        i = 0;
    }
    
    return i;
}
