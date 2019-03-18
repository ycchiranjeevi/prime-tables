# prime-table

This program Prints Product Table of Primes; First Row, First Column are the list of primes.
Value in each cell is the product of corresponding prime numbers in the row and column.

## Installation

Prerequisites: Clojure is a LISP on Java, hence installation of Java is mandatory for running and development of this program.

We use **Leiningen** as the building tool, which is the most famous tool for Clojure development. To install Leiningen (which also installs Clojure), follow instructions given here:
```
https://leiningen.org/
```
## Compile the program

Run the following command at the root of the source director
```
lein do clean, uberjar
```

## Run Unit tests
```
lein test
```

## Usage

Run the following commands to start the program

    $ java -jar target/prime-table-0.1.0-SNAPSHOT-standalone.jar [args]


## Examples
1. Without args (10 primes)

```java -jar target/prime-table-0.1.0-SNAPSHOT-standalone.jar```

Answer:
```
          0          2          3          5          7         11         13         17         19         23         29
          2          4          6         10         14         22         26         34         38         46         58
          3          6          9         15         21         33         39         51         57         69         87
          5         10         15         25         35         55         65         85         95        115        145
          7         14         21         35         49         77         91        119        133        161        203
         11         22         33         55         77        121        143        187        209        253        319
         13         26         39         65         91        143        169        221        247        299        377
         17         34         51         85        119        187        221        289        323        391        493
         19         38         57         95        133        209        247        323        361        437        551
         23         46         69        115        161        253        299        391        437        529        667
         29         58         87        145        203        319        377        493        551        667        841
```

2. With args (custom)

```java -jar target/prime-table-0.1.0-SNAPSHOT-standalone.jar 5```

Answer:
```
     0     2     3     5     7    11
     2     4     6    10    14    22
     3     6     9    15    21    33
     5    10    15    25    35    55
     7    14    21    35    49    77
    11    22    33    55    77   121
```

## Time Complexity

1. To generate n primes: approximately n * squaroot(n)
2. To print the table: (n + 1) * (n + 1)

## Scalability

We can include memoized version of the lazy-primes for high number of random requests. The memoized version stores incremental additions of primes.

For the memoized version, we can not use the current *lazy-primes*. Instead we can write *get-next-prime* function. Using this function we can memoize the primes, and use that for subsequent retrieval list of first n primes for any number of random requests.
...

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
