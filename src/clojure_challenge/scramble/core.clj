(ns clojure-challenge.scramble.core
  (:require [clojure.string :as cstr :refer [blank?]]
            [ataraxy.core :as ataraxy]
            [integrant.core :as ig]
            [ataraxy.response :as response]))

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
                  ;; we consume all chars from s2 and remove them from
                  ;; s1 in each step, if the char is not found in the remaining
                  ;; chars from s1 then the reduction completes with fail status
                  (fn [{:keys [remaining] :as res} the-char]
                    (if (some #{the-char} remaining)
                      (-> res
                          (update :remaining #(remove-first  #{the-char} %)))
                      (reduced (-> res (assoc :ok? false)))))
                  {:remaining s1 :ok? true}
                  s2))))

(defmethod ig/init-key :clojure-challenge.scramble.core/scramble? [_ opts]
  (fn [s1 s2 ]
    {:s1 s1 :s2 s2 :result (scramble? s1 s2)}))
