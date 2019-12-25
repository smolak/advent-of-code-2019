(ns v2019.day01_test
    (:require [clojure.test :refer [deftest is testing]]
              [v2019.day01 :refer [calculateFuelConsumption calculateFuelRequirement part1 part2]]))

(deftest fule-consumption-mass-12
  (testing "Fuel consumption for mass 12 should be 2"
           (is (= (calculateFuelConsumption 12) 2)))
  (testing "Fuel consumption for mass 14 should be 2"
           (is (= (calculateFuelConsumption 14) 2)))
  (testing "Fuel consumption for mass 1969 should be 654"
           (is (= (calculateFuelConsumption 1969) 654)))
  (testing "Fuel consumption for mass 100756 should be 33583"
           (is (= (calculateFuelConsumption 100756) 33583))))

(deftest calculate-fuel-requirement-12
  (testing "Fuel requirement for mass 12 should be 2"
           (is (= (calculateFuelRequirement 0 12) 2)))
  (testing "Fuel requirement for mass 14 should be 2"
           (is (= (calculateFuelRequirement 0 14) 2)))
  (testing "Fuel requirement for mass 256 should be 114"
           (is (= (calculateFuelRequirement 0 1969) 966)))
  (testing "Fuel requirement for mass 100756 should be 14205"
           (is (= (calculateFuelRequirement 0 100756) 50346))))

(deftest process-file
  (testing "Should return a sum of fuel consumption for masses defined in a file"
           (def filePath "./test/v2019/resources/day01/input.txt")
           (def fuelConsumptionSum (part1 filePath))
           (is (= fuelConsumptionSum 34241))))

(deftest process-file-part-2
  (testing "Should return a sume of fuel requirement for masses defined in a file"
           (def filePath "./test/v2019/resources/day01/input.txt")
           (def fuelConsumptionSum (part2 filePath))
           (is (= fuelConsumptionSum 51316))))
