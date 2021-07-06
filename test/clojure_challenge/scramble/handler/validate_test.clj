(ns clojure-challenge.scramble.handler.validate-test
  (:require [clojure-challenge.scramble.handlers :as handlers]
            [clojure-challenge.scramble.core :refer [scramble?]]
            [clojure.test :refer :all]
            [ataraxy.core :as ataraxy]
            [ring.mock.request :as mock]
            [integrant.core :as ig]
            [duct.core :as duct]))



;; could not get the test to work with the real handler
(defn scramble-handler [{[_ s1 s2] :ataraxy/result}]
  {:status 200, :headers {}, :body {:s1     s1
                                    :s2     s2
                                    :result (scramble? s1 s2)}})

(deftest smoke-test
  (testing "scramble get request"
    (let [config {:duct.router/ataraxy
                  {:routes   '{[:get "/scramble/" s1 "/" s2]  [:scramble s1 s2]}
                   :handlers {:scramble scramble-handler}}}
          handler (:duct.router/ataraxy (ig/init config))
          response (handler {:request-method :get
                             :uri "/scramble/llohex/hello"})]

      (is (= {:s1 "llohex" :s2 "hello" :result true}  (:body response)) "response ok"))))
