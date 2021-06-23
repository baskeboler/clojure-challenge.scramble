(ns clojure-challenge.scramble.handler.validate-test
  (:require [clojure-challenge.scramble.handlers]
            [clojure-challenge.scramble.core :refer [scramble?]]
            [clojure.test :refer :all]
            [ataraxy.core :as ataraxy]
            [ring.mock.request :as mock]
            [integrant.core :as ig]))


;; (deftest smoke-test
;;   (testing "scramble get request"
;;     (let [scramblefn (fn [ a b] {:s1 a :s2 b :result (scramble? a b)})
;;           handler (ig/init-key :clojure-challenge.scramble.handlers/get {:scramble? scramblefn})
;;           response (handler (mock/request :get "/scramble?s1=llohexx&s2=hello" {:s1 "llohe" :s2 "hello"}))]



;;       (is (= {:s1 "llohe" :s2 "hello" :result true}  (:body response)) "response ok"))))
