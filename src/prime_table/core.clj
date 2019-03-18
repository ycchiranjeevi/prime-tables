(ns prime-table.core
  "Functions to generate First N Primes and their tables"
  (:gen-class))

(defn lazy-primes
  "Generates Primes Lazily.
   Time Complexity of generating n-primes is n*sqrt(n)
   As per the link:
   https://stackoverflow.com/questions/32270569/calculating-time-complexity-for-finding-first-n-prime-numbers
  It almost holds true for lazy version also"
  []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                  (dissoc candidate)
                  (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate
                    (lazy-seq (next-primes (next-sieve sieve candidate)
                                           (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))

(defn print-prime-table
  "Prints Product Table of Primes
   First Row, First Column are the list of primes.
   Value in each cell is the product of corresponding prime numbers in the row and column.

   Assuming that the primes are not too large so that,
   Time to multiply is same as time to lookup up the stored (memoized) product.

   Time Compexity is (n + 1) * (n + 1)
   "
  [n]
  (let [primes (vec (take n (lazy-primes)))
        last-prime (peek primes)
        num-of-digits (-> (* last-prime last-prime) str count)
        fmt-str (str "%" (inc n) "d") ]
    (printf fmt-str 0)
    (println (apply str (map #(format fmt-str %) primes)))
    (doseq [row primes]
      (printf fmt-str row)
      (doseq [col primes]
        (printf fmt-str (* row col)))
      (println))))

(defn -main
  "The main entry point"
  [& args]
  (if (> (count args) 0)
    (print-prime-table (args first #(Long/parseLong %)))
    (print-prime-table 10)))
