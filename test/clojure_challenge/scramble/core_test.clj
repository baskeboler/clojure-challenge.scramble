(ns clojure-challenge.scramble.core-test
  (:require [clojure-challenge.scramble.core :as sut]
            [clojure.test :refer :all]))

(deftest scrambled?-test
  (testing "scrambled? test 1"
    (is (sut/scramble? "rekqodlw" "world")))
  (testing "scrambled? test 2"
    (is (sut/scramble? "cedewaraaossoqqyt" "codewars")))
  (testing "scrambled? test 3"
    (is (not (sut/scramble? "katas" "steak"))))
  (testing "scramble? empty s2"
    (is (sut/scramble? "whatever" "")))
  (testing "scramble? nil s2"
    (is (sut/scramble? "whatever" nil)))
  (testing "scramble? nil s1"
    (is (not (sut/scramble? nil "lala"))))
  (testing "scramble? blank s1"
    (is (not (sut/scramble? "" "lala"))))
  (testing "scramble? both nil strings"
    (is (sut/scramble? nil nil)))
  (testing "scramble? both blank"
    (is (sut/scramble? "" ""))))
