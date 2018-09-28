########## TOBB ETU BIL481 Fall 2018-2019 Homework Assignment 1 ##########

App takes a string array to be encrypted, 2 integer arrays and 1 integer as encryption keys.
All strings in string array are encrypted using 3 encryption keys and returned.

###Steps:

* App takes 4 parameters: 2 ArrayLists, 1 integer and a string array.
* Integer parameter's modulo of 128 is Key 0
* Integer arrays' elements' modulo of 128 are calculated individually.
** These individual numbers's arithmetic average generates Key1 and Key2
* A master key is generated with Key0, Key1 and Key3's average.
* Strings' characters' ASCII values' and master key's average is calculated individually.
** Averages' modulo of 128 generates new chars.
*** New strings are generated using new chars and returned.

[![Build Status](https://travis-ci.org/OnurDz/myDemoApp.svg?branch=master)](https://travis-ci.org/OnurDz/myDemoApp)