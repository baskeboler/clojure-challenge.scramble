(ns clojure-challenge.scramble.handler.validate
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [integrant.core :as ig]
            [clojure-challenge.scramble.core :refer [scramble?]]))

(defmethod ig/init-key :clojure-challenge.scramble.handler/validate [_ options]
  (fn [{[_ s1 s2] :ataraxy/result}]
    [::response/ok {:s1 s1 :s2 s2 :result (scramble? s1 s2)}]))
