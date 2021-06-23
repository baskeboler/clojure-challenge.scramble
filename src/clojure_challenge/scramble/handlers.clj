(ns clojure-challenge.scramble.handlers
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [integrant.core :as ig]))

(defmethod ig/init-key :clojure-challenge.scramble.handlers/get
  [_ {:keys [scramble?]}]
  (fn [{[_ s1 s2] :ataraxy/result}]
    {:body ( scramble? s1 s2)}))

(defmethod ig/init-key :clojure-challenge.scramble.handlers/post
  [_ {:keys [scramble?]}]
  (fn [{[_ req] :ataraxy/result}]
    (let [{:keys [s1 s2]} req]
      {:body (scramble? s1 s2)})))
