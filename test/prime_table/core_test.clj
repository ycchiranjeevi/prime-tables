(ns prime-table.core-test
  (:require [clojure.test :refer :all]
            [prime-table.core :refer :all]))

(deftest a-test
  (testing "Testing table for first three prime numbers"
    (is (= "  0  2  3  5\n  2  4  6\n  3  6  9\n  5 10 15 25")
        (with-out-str (print-prime-table 3))))
  (testing "Testing for the first three prime numbers"
    (is (= [2 3 5] (vec (take 3 (lazy-primes)))))))

