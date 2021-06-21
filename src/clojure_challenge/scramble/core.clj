(ns clojure-challenge.scramble.core
  (:require [clojure.string :as cstr :refer [blank?]]))

(defn remove-first [f coll]
  "removes the first element of the collection where (f x) returns true"
  (let [first-part  (take-while (comp not f) coll)
        second-part (rest (drop (count first-part) coll))]
    (concat first-part second-part)))

(defn scramble? [s1 s2]
  (cond
    (blank? s2) true
    (blank? s1) (blank? s2)
    :else  (:ok? (reduce
                  (fn [{:keys [remaining] :as res} the-char]
                    (if (some #{the-char} remaining)
                      (-> res
                          (update :remaining #(remove-first  #{the-char} %)))
                      (reduced (-> res (assoc :ok? false)))))
                  {:remaining s1 :ok? true}
                  s2))))
