(ns clojure-challenge.scramble.handler.validate-test
  (:require [clojure-challenge.scramble.handler.validate]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [integrant.core :as ig]))


(deftest smoke-test
  (testing "scramble get request"
    (let [handler (ig/init-key :clojure-challenge.scramble.handler/validate {})
          response (handler (mock/request :get "/scramble?s1=llohexx&s2=hello"))]
      (is (= :ataraxy.response/ok (first response)) "response ok"))))
